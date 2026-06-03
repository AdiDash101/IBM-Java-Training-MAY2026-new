package payment_system;

public abstract  class Payment {
	private double amount;
	
	public Payment(double amount) {
		this.amount = amount;
	}
	public abstract void processPayment();
	
	public void displayAmount() {
		System.out.println("Amount: $" + amount);
	}
	
	public double getAmount() {
		return amount;
	}
}
