package payment_system;

public non-sealed class PaymentGateway extends Gateway {
    
    @Override
    public void connect() {
        System.out.println("Connecting to the central payment network...");
    }
    
    // Accepting the amount as a parameter here
    public void processThroughGateway(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Gateway Error: Transaction amount must be greater than 0$.");
        }
        if (amount > 400) {
            throw new IllegalArgumentException("Gateway Error: Fraud Alert! Limit exceeded for unverified offline routes");
        }
        System.out.println("Payment has been processed successfully through the gateway.");
    }
}