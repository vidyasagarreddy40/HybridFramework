package Reports;

import TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class extentReportGeneration {

    public ExtentReports extent = new ExtentReports();
    public ExtentSparkReporter spark = new ExtentSparkReporter("target/Report.html");
    public static ExtentTest test;

    public void setReportTheme() {
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        extent.attachReporter(spark);
    }

    public void createTestInReport(String testName) {
        test = extent.createTest(testName);
    }

    public void reportLogs(String logType, String logMesssage,WebDriver driver) {
        switch (logType) {
            case "info":
                test.info(logMesssage);
                break;
            case "fail":
                test.fail(logMesssage).addScreenCaptureFromBase64String(captureScreenshot(driver));
                break;
            case "warning":
                test.warning(logMesssage);
                break;
            case "pass":
                test.pass(logMesssage);
                break;
            case "skip":
                test.skip(logMesssage);
                break;
        }
    }

    public static String captureScreenshot(WebDriver driver) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);

        return base64Code;
    }

}
