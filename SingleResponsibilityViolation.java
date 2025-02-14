
public class SingleResponsibilityViolation {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1000);
        invoice.printInvoice();
        invoice.saveToDatabase();
    }
}

class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public void printInvoice() {
        System.out.println("Invoice amount: " + amount);
    }

    public void saveToDatabase() {
        System.out.println("Saving invoice to database...");
    }
}
