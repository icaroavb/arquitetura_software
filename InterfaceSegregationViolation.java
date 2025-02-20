interface MachineFax {
    void viewFax();
}

interface MachinePrint{
    void viewPrint();
}

interface  MachineScan {
    void viewScan();
}

public class Fax implements MachineFax{

    @Override
    public void viewFax() {
        System.out.println("Faxing...");
    }
}

class Print implements MachinePrint{

    @Override
    public void viewPrint() {
        System.out.println("Printing...");
    }
    
}

class Scan implements MachineScan{

    @Override
    public void viewScan() {
        System.out.println("Scanning...");
    }
    
}

public class Main {
    public static void main(String[] args) throws Exception {
        MachineFax fax = new Fax();
        MachinePrint print = new Print();
        MachineScan scan = new Scan();

        fax.viewFax();
        print.viewPrint();
        scan.viewScan();

    }
}
