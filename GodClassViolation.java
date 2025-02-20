//GodClass: Em programação orientada a objetos, é uma classe que sabe demais ou faz demais.
//É a manifestação prática do SRP - Single Responsability Principle (S)
//A refatoracao do codigo abrange a criacao de varias classes
//A refatoracao do codigo tambem se aplica a metodos - cada metodo deve fazer somente uma unica atividade ou funcao
//1 etapa - divisao das classes
public class GodClassViolation {
    public static void main(String[] args) {

        Authenticator objAuthenticateUser = new Authenticator();
        DashboardLoader objApplicationLoadDashboard = new DashboardLoader();
        PaymentProcessor objProcessPayments = new PaymentProcessor();
        GenerateReport objApplicationGenerateReports = new GenerateReport();

        Application app = new Application(objAuthenticateUser, objApplicationLoadDashboard, objProcessPayments, objApplicationGenerateReports);

        app.run();
    }
}

class Application{

    private Authenticator authenticator;
    private DashboardLoader dashboardLoader;
    private PaymentProcessor paymentProcessor;
    private GenerateReport generateReport;

    public Application(Authenticator authenticator, DashboardLoader dashboardLoader, PaymentProcessor paymentProcessor, GenerateReport generateReport) {
        this.authenticator = authenticator;
        this.dashboardLoader = dashboardLoader;
        this.paymentProcessor = paymentProcessor;
        this.generateReport = generateReport;
    }

    public void run() {
        System.out.println("Running application...");
        authenticator.authenticateUser();
        dashboardLoader.loadDashboard();
        paymentProcessor.processPayments();
        generateReport.generateReports();
    }

}


class Authenticator {
    public void authenticateUser() {
        System.out.println("Authenticating user...");
    }
}

class DashboardLoader {
    public void loadDashboard() {
        System.out.println("Loading dashboard...");
    }
}

class PaymentProcessor {
    public void processPayments() {
        System.out.println("Processing payments...");
    }
}

class GenerateReport {
    public void generateReports() {
        System.out.println("Generating reports...");
    }
}










