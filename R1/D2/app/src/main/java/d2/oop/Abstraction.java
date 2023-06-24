package d2.oop;

import java.util.List;

/**
 * Abstraction demonstration using interface
 */

interface Report {
    List<Object> run(ReportContext reportContext);
}

class ReportContext {
    // fields
}

class EmployeeReport implements Report {
    @Override
    public List<Object> run(ReportContext reportContext) {
        // some complex logic
        System.out.println("Executing employee report");
        return null;
    }
}

class SalaryReport implements Report {
    @Override
    public List<Object> run(ReportContext reportContext) {
        // some complex logic
        System.out.println("Executing salary report");
        return null;
    }
}

public class Abstraction {
    public static void main(String[] args) {
        ReportContext reportContext = new ReportContext();
        // populate context
        Report eReport = new EmployeeReport();
        eReport.run(reportContext);

        Report sReport = new SalaryReport();
        sReport.run(reportContext);
    }
}
