// PayPalPaymentAdapter.java
public class PayPalPaymentAdapter implements PaymentProcessor {
    private PayPalPayment payPalPayment;

    public PayPalPaymentAdapter(PayPalPayment payPalPayment) {
        this.payPalPayment = payPalPayment;
    }

    @Override
    public void processPayment(double amount) {
        payPalPayment.makePayment(amount);
    }
}

// StripePaymentAdapter.java
public class StripePaymentAdapter implements PaymentProcessor {
    private StripePayment stripePayment;

    public StripePaymentAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void processPayment(double amount) {
        stripePayment.pay(amount);
    }
}

// SquarePaymentAdapter.java
public class SquarePaymentAdapter implements PaymentProcessor {
    private SquarePayment squarePayment;

    public SquarePaymentAdapter(SquarePayment squarePayment) {
        this.squarePayment = squarePayment;
    }

    @Override
    public void processPayment(double amount) {
        squarePayment.doPayment(amount);
    }
}
