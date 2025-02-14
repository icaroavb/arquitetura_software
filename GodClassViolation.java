
public class GodClassViolation {
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }
}

class Application {
    public void run() {
        System.out.println("Running application...");
        authenticateUser();
        loadDashboard();
        processPayments();
        generateReports();
    }

    private void authenticateUser() {
        System.out.println("Authenticating user...");
    }

    private void loadDashboard() {
        System.out.println("Loading dashboard...");
    }

    private void processPayments() {
        System.out.println("Processing payments...");
    }

    private void generateReports() {
        System.out.println("Generating reports...");
    }
}
