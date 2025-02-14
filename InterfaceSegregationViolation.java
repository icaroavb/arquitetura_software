
public class InterfaceSegregationViolation {
    public static void main(String[] args) {
        MultiFunctionPrinter printer = new MultiFunctionPrinter();
        printer.print();
        printer.scan();
        printer.fax();
    }
}

interface Machine {
    void print();
    void scan();
    void fax();
}

class MultiFunctionPrinter implements Machine {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }

    public void fax() {
        System.out.println("Faxing...");
    }
}
