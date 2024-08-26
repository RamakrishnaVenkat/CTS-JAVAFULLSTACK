// PayPalPayment.java
public class PayPalPayment {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

// StripePayment.java
public class StripePayment {
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

// SquarePayment.java
public class SquarePayment {
    public void doPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Square.");
    }
}
