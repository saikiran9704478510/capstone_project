package Extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Extent {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String stamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String reportPath = System.getProperty("user.dir") + "/target/ExtentReport_" + stamp + ".html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Booking.com BDD Report");
            spark.config().setReportName("Smoke Suite");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Project", "Wipro Capstone");
            extent.setSystemInfo("Suite", "Booking BDD");
        }
        return extent;
    }
}