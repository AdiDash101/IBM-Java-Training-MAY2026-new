package payment_system;

public sealed abstract class Gateway permits PaymentGateway {
	public abstract void connect();
}
