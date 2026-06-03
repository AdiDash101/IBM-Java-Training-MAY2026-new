package payment_system;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
	
		Gateway gateway  = new PaymentGateway(); // Abstraction
		
		// Poly Collection
		List<Payment> payments = new ArrayList<>();
		payments.add(new CreditCardPayment(150.75, "123456781235678"));
		payments.add(new PayPalPayment(45.00, "user@email.com"));
		payments.add(new BankTransferPayment(500.00, "1234567890"));
		
		List<PaymentDetails> records = new ArrayList<>();
		
		for(Payment payment : payments) {
			payment.displayAmount();
			
			if(payment instanceof Verifiable verifiable) {
				if(verifiable.verify()) {
					payment.processPayment();
					
					if (gateway instanceof PaymentGateway pg) {
						pg.connect();

						pg.processThroughGateway(payment.getAmount());
					}
					
					String txId = UUID.randomUUID().toString().substring(0, 8);
					records.add(new PaymentDetails(
					   txId,
					   payment.getAmount(),
					   payment.getClass().getSimpleName(),
					   LocalDateTime.now()
							));
				} else {
					System.out.println("Verification Failed. ");
				}
			}
			System.out.println();
		}
		
		System.out.println("=== Final Transaction Log ===");
		for (PaymentDetails log : records) {
			System.out.println(log);
		}
	}
}