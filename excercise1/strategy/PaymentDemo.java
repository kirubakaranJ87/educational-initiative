package strategy;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    public CreditCardStrategy(String cardNumber) { this.cardNumber = cardNumber; }
    public void pay(double amount) {
        System.out.println("Charging " + amount + " to credit card " + cardNumber.substring(cardNumber.length()-4));
    }
}

class PayPalStrategy implements PaymentStrategy {
    private String email;
    public PayPalStrategy(String email) { this.email = email; }
    public void pay(double amount) {
        System.out.println("Processing " + amount + " payment via PayPal account " + email);
    }
}

class Checkout {
    private PaymentStrategy strategy;
    public Checkout(PaymentStrategy strategy) { this.strategy = strategy; }
    public void setStrategy(PaymentStrategy strategy) { this.strategy = strategy; }
    public void processOrder(double amount) { strategy.pay(amount); }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Checkout checkout = new Checkout(new CreditCardStrategy("1234567812345678"));
        checkout.processOrder(49.99);
        checkout.setStrategy(new PayPalStrategy("buyer@paypal.com"));
        checkout.processOrder(19.95);
    }
}
