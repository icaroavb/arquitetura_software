# arquitetura_software
Repositório feito para as atividades da meteria de arquitetura de software

|- DependencyInversionViolation -|
--------------------------------------------------------------------------------
Princípio da inversão da dependência enfatiza o desacoplamento e abstração. Antes a classe Switch estava acoplada firmemente a classe Ligthbulb.
Agora, a classe switch (de maior nível) pode ser usada para ligar vários tipos de dispositivos.

    public class DependencyInversionViolation {
        public static void main(String[] args) {
            LightBulb bulb = new LightBulb();
            Switch lightSwitch = new Switch(bulb);
            lightSwitch.turnOn();
            lightSwitch.turnOff();
        }
    }
    
    class LightBulb implements Switchable {
        public void turnOn() {
            System.out.println("LightBulb is ON");
        }
        public void turnOff() {
            System.out.println("LightBulb is OFF");
        }
    }
    
    interface Switchable {
        //criacao de uma interface de algo que liga e desliga
        public void turnOn();
        public void turnOff();
    }//fim da interface
    
    
    class Switch {
        private Switchable device;
    
        public Switch(Switchable device) {
            this.device = device;
        }
    
        public void turnOn() {
            this.device.turnOn();
        }
    
        public void turnOff() {
            this.device.turnOff();
        }
    }


|- GodClassViolation -|
--------------------------------------------------------------------------------
GodClassViolation é uma manifestação prática da violação do primeiro princípio SOLID, Single Responsability Violation. 
Assim, a refatoração abrange a criação de várias outras classes/módulos, cada uma com suas respectivas funções distintas.

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

|- HardCodedDependencies -|
--------------------------------------------------------------------------------
No código original, a função de nível baixo PDFReportGenerator estava fortemente acoplada com a classe Report. 
Isso limita e viola o princípio do OPEN/CLOSED, pois se houvesse a necessidade de acrescentar mais um tipo de relatório, haveria a necessidade de modificar a classe.
Ademais, restringe também a função de gerar relatórios do tipo PDF à classe Report, o que também diminui a modularidade e reaproveitamento do código. 
A solução seria criar uma interface que admita diferentes tipos geradores de relatórios. In casu, foi acrescentada a classe para gerar mais um tipo de relatório no formato xml.

    public class HardCodedDependencies {
        //necessidade de instanciar a classe report, há a necessidade de criar servicos de baixo nivel que melhor atendam os de nivel superior
        public static void main(String[] args) {
            XMLReportGenerator xmlReportGenerator = new XMLReportGenerator();
            PDFReportGenerator pdfReportGenerator = new PDFReportGenerator();
            Report report = new Report(pdfReportGenerator);
            report.getReportGenerator().generateReport();
            Report report1 = new Report(xmlReportGenerator);
            report1.getReportGenerator().generateReport();
    
        }
    }
    
    class Report {
    
        private final ReportGenerator reportGenerator;
    
        public Report(ReportGenerator reportGenerator) {
            this.reportGenerator = reportGenerator;
        }
    
        public ReportGenerator getReportGenerator() {
            return reportGenerator;
        }
    }
    
    
    interface ReportGenerator {
        //criacao de uma interface que servira para todos os tipos de relatorio: pdf, xml, etc
    
        public void generateReport();
    }
    
    class PDFReportGenerator implements ReportGenerator{
        @Override
        public void generateReport() {
            System.out.println("A PDF report was generated...");
        }
    }
    
    class XMLReportGenerator implements ReportGenerator{
    
        @Override
        public void generateReport() {
            System.out.println("A XML report was generated...");
        }
    }

    
|- ViolationOfEncapsulation -|
--------------------------------------------------------------------------------
Foi privado os atribustos para que nao tenha fragilidade no encapsulamento.

    class Person {
    private String name;
     private int age;
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        }
     }


|- TightCouplingViolation -|
--------------------------------------------------------------------------------
Em vez de instaciar uma classe Engine foi apenas atribuido ela na classe car, ajundando a facilitar a manutenção

    class Engine {
    public void start() {
        System.out.println("Engine started");
    }
    }

    class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();

        }
    }
