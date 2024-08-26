// AdapterPatternTest.java
public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of the payment gateways
        PayPalPayment payPalPayment = new PayPalPayment();
        StripePayment stripePayment = new StripePayment();
        SquarePayment squarePayment = new SquarePayment();

        // Create adapters for each payment gateway
        PaymentProcessor payPalProcessor = new PayPalPaymentAdapter(payPalPayment);
        PaymentProcessor stripeProcessor = new StripePaymentAdapter(stripePayment);
        PaymentProcessor squareProcessor = new SquarePaymentAdapter(squarePayment);

        // Process payments using the adapters
        payPalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
        squareProcessor.processPayment(300.00);
    }
}
