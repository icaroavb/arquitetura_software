public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(1000);
        InvoicePrinter printer = new InvoicePrinter();
        InvoiceRepository repository = new InvoiceRepository();

        printer.printInvoice(invoice);
        repository.saveToDatabase(invoice);
    }
}

class Invoice {
    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}

class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println("Invoice amount: " + invoice.getAmount());
    }
}

class InvoiceRepository {
    public void saveToDatabase(Invoice invoice) {
        System.out.println("Saving invoice to database...");
    }
}
