package payment_system;

public sealed class PaymentType permits OnlinePaymentType, OfflinePaymentType {
    protected String categoryName;
    
    public String getCategoryName() {
        return categoryName;
    }
}

final class OnlinePaymentType extends PaymentType {
    public OnlinePaymentType() { 
        this.categoryName = "Online Payment";
    }
}

final class OfflinePaymentType extends PaymentType {
    public OfflinePaymentType() { 
        this.categoryName = "Offline Payment";
    }
}