package payment_system;

public class BankTransferPayment extends Payment implements Verifiable {
	private String accountNumber;
	
	public BankTransferPayment(double amount, String accountNumber) {
		super(amount);
		this.accountNumber = accountNumber;
	}
	
	@Override
	public boolean verify() {
		return accountNumber != null && accountNumber.length() == 16;
	}
	
	@Override
	public void processPayment() {
		System.out.println("Processing Bank Transfer...");
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
}
