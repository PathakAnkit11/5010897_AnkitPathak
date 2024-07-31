public class Main {
    public static void main(String[] args) {
        System.out.println();

        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        payPalProcessor.processPayment(14.0); 
        stripeProcessor.processPayment(28.0); 
    }
}
