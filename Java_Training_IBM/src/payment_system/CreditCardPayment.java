package payment_system;

public class CreditCardPayment extends Payment implements Verifiable {
	private String cardNumber;
	
	public CreditCardPayment(double amount, String cardNumber) {
		super(amount);
		this.cardNumber = cardNumber;
	}
	
	@Override
	public boolean verify() {
		return cardNumber != null && cardNumber.length() == 16;
	}
	
	@Override
	public void processPayment() {
		System.out.println("Process credit card payment...");
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
}
