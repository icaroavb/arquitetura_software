
public class ImproperExceptionHandling {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.divide(10, 0);
    }
}

class Calculator {
    public void divide(int a, int b) {
        try {
            System.out.println("Result: " + (a / b));
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}
