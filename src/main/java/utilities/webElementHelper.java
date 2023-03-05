package utilities;

import Reports.extentReportGeneration;
import actions.Button;
import actions.Textbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class webElementHelper {

    private WebElement webElementStatus;
    loggerlogs logs = new loggerlogs();
    extentReportGeneration extentreportgeneration = new extentReportGeneration();

    public static By elements(String locatorType, String locator) {
        By objectLocator = null;
        switch (locatorType) {
            case "xpath":
                objectLocator = By.xpath(locator);
                break;
            case "id":
                objectLocator = By.id(locator);
                break;
            case "name":
                objectLocator = By.name(locator);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + locatorType);
        }
        return objectLocator;
    }

    public WebElement waitForInvisibilityOfElement(WebDriver driver, By element, int time) {

        try {
            webElementStatus = ExplicitWaiting.explicitWaitInvisibilityOfElementLocated(driver, element, time);
        } catch (Exception e) {
            e.printStackTrace();
            extentreportgeneration.reportLogs("fail", webElementHelper.class.getSimpleName() + " - failed to identify the  " + element + " - " + driver.getTitle()+"/n"+e,driver);
            logs.logger("error", "failed to identify the " + element+" in "+driver.getTitle()+" /n"+e , webElementHelper.class.getSimpleName(), "");
            return null;
        }
        return webElementStatus;
    }



}
