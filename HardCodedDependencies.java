import javax.swing.text.Document;
import java.sql.SQLOutput;

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
