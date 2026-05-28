package payment_system;

public class PayPalPayment extends Payment implements Verifiable {
	private String email;
	
	public PayPalPayment(double amount, String email) {
		super(amount);
		this.email = email;
	}
	
	@Override
	public boolean verify() {
		return email != null && email.contains("@");
	}
	
	@Override
	public void processPayment() {
		System.out.println("Processing PayPal payment...");
	}
	
	public String getEmail() {
		return email;
	}
}
