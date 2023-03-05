package actions;

import Reports.extentReportGeneration;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.loggerlogs;

public class Textbox extends TestBase {

    loggerlogs logs = new loggerlogs();
    extentReportGeneration extentreportgeneration = new extentReportGeneration();
    ITestResult result;


    @Test
    public String text(WebDriver driver, WebElement element, String elementName, String value) {

        String status = "";
        String triggerEvent = "";
        try {
            if (element == null) {
                status = "fail";
                return status;
            }
            if (value != null) {
                if (value.contains("~")) {
                    triggerEvent = value.split("~")[1];
                    value = value.split("~")[0];
                }
            }
            if (triggerEvent.equalsIgnoreCase("")) {
                element.sendKeys(value);
                logs.logger("info", value + " is entered in " + elementName, Textbox.class.getSimpleName(), "");
            }
            status = "pass";
        } catch (Exception e) {

            status = "fail";
            e.printStackTrace();
            extentreportgeneration.reportLogs("fail", Textbox.class.getSimpleName() + " - failed to enter the  " + value + " in " + elementName + " - " + driver.getTitle() + "/n" + e, driver);
            logs.logger("error", "failed to enter the" + value + " in " + elementName + "/n" + e, Textbox.class.getSimpleName(), "");


        } finally {
            if (status.equalsIgnoreCase("pass")) {
                extentreportgeneration.reportLogs("pass", Textbox.class.getSimpleName() + " - entered the " + value + " in " + elementName + " - " + driver.getTitle(), driver);
            }
            else{
                TestBase.softassert.fail("failed to intract with an "+ elementName);
            }
            return status;
        }
    }
}
