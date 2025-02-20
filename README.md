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


|- Princípio da Substituição de Liskov -|
--------------------------------------------------------------------------------
O que foi feito:  
O código original fazia com que `Ostrich` herdasse o método `fly()`, que não pode ser aplicado corretamente a essa classe, violando o princípio da substituição de Liskov. Para corrigir, a classe `Bird` foi dividida em `FlyingBird` e `FlightlessBird`, garantindo que cada pássaro tenha apenas comportamentos adequados à sua natureza.  


    public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Bird bird = new Sparrow();
        bird.fly();

        FlightlessBird ostrich = new Ostrich();
        ostrich.walk();
    }
    }

    abstract class Bird {
    public abstract void move();
    }
        
    abstract class FlyingBird extends Bird {
    public abstract void fly();

    @Override
    public void move() {
        fly();
    }
    }

    abstract class FlightlessBird extends Bird {
    public abstract void walk();

    @Override
    public void move() {
        walk();
    }
    }

    class Sparrow extends FlyingBird {
    @Override
    public void fly() {
            System.out.println("Sparrow is flying");
        }
    }

    class Ostrich extends FlightlessBird {
    @Override
    public void walk() {
        System.out.println("Ostrich is walking");
    }
    }




-| Princípio Aberto-Fechado |-
--------------------------------------------------------------------------------
O que foi feito: 
O código original usava `if` e `else if` para verificar o tipo de cliente e calcular o desconto, tornando difícil a adição de novos tipos sem modificar a classe `DiscountCalculator`. Para corrigir isso, foi criada uma interface `DiscountStrategy`, permitindo que novos tipos de desconto sejam adicionados sem modificar o código existente.  

    public class OpenClosedPrinciple {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator(new VIPDiscount());
        System.out.println("Discount: " + calculator.calculateDiscount(200));
        }
    }
    
    interface DiscountStrategy {
        double applyDiscount(double amount);
    }

    class RegularDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.1;
    }
    }

    class VIPDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
            return amount * 0.2;
        }
    }

    class DiscountCalculator {
    private final DiscountStrategy discountStrategy;

    public DiscountCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(double amount) {
        return discountStrategy.applyDiscount(amount);
        }
    }


-| Princípio da Responsabilidade Única |-
--------------------------------------------------------------------------------
O que foi feito:  
A classe `Invoice` no código original fazia múltiplas tarefas: armazenava os dados da fatura, imprimia e salvava no banco de dados. Isso viola o princípio da responsabilidade única. A solução foi dividir essas responsabilidades em três classes: `Invoice` (dados), `InvoicePrinter` (impressão) e `InvoiceRepository` (armazenamento).  

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
