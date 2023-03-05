package TestBase;

import Reports.extentReportGeneration;
import actions.Textbox;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.*;
import java.util.Map;
import java.util.Properties;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.yaml.snakeyaml.Yaml;
import utilities.loggerlogs;


public class TestBase {

    public static WebDriver driver;
    static Properties properties;
    static BufferedReader reader;
    static loggerlogs logs;
    public ExtentReports extent;
    public ExtentSparkReporter spark;
    public ExtentTest test;
    public static SoftAssert softassert = new SoftAssert();
    // Yaml yamlObject = new Yaml();
    // Map<String, String> TimeoutMap = (Map) (yamlObject.load(getClass().getClassLoader().getResourceAsStream("Timeout.yml")));
    int pageLoadTime;
    public extentReportGeneration extentreportgeneration = new extentReportGeneration();

    private static TestBase testbase = new TestBase();

    public static TestBase getInstance() {
        return testbase;
    }

    public static void initialisation(String browser) throws IOException {
        reader = new BufferedReader(new FileReader("./src/main/resources/propertyfiles/drivers.properties"));
        properties = new Properties();
        properties.load(reader);
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("chromedriver"));
                driver = new ChromeDriver();
                break;
        }
    }

    @BeforeSuite
    public void beforesuite() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Report.html");
        extentreportgeneration.setReportTheme();
    }

    @BeforeTest
    public void beforeTest() throws IOException, NoSuchMethodException {

    }

    @BeforeMethod

    public void beforeMethod(ITestResult result) throws IOException {
        initialisation("chrome");
        logs = new loggerlogs();
        logs.logger("info", "Initialising the browser", TestBase.class.getSimpleName(), "");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com/intl/en-GB/gmail/about/");
        extentreportgeneration.createTestInReport(result.getMethod().getMethodName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        extentreportgeneration.extent.flush();
        softassert.assertAll();
        driver.quit();
    }

    @AfterTest
    public void afterTest() throws IOException {
        Desktop.getDesktop().browse(new File("target/Report.html").toURI());
    }
}
