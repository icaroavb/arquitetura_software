
public class OpenClosedViolation {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Discount: " + calculator.calculateDiscount("VIP", 200));
    }
}

class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.1;
        } else if (customerType.equals("VIP")) {
            return amount * 0.2;
        } else {
            return 0;
        }
    }
}
