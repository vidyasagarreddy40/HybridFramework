package actions;

import Reports.extentReportGeneration;
import TestBase.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.loggerlogs;

import java.lang.reflect.Method;

public class Button extends TestBase {

    loggerlogs logs=new loggerlogs();
    extentReportGeneration extentreportgeneration = new extentReportGeneration();

    public String click(WebDriver driver,WebElement element,String elementName, String value){
        String status="";
        String triggerEvent="";
        try {
            if (element == null) {
                status = "fail";
                return status;
            }
            if (value != null) {
                triggerEvent = value;
            }
            if (triggerEvent.equalsIgnoreCase("js")) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].focus;", element);
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                js.executeScript("window.onbeforeunload=null;", element);
                js.executeScript("arguments[0].click();", element);
                logs.logger("info", elementName + " is clicked",Button.class.getSimpleName(),"");
            }
            status="pass";
        }catch (Exception e){
            status="fail";
            e.printStackTrace();
            extentreportgeneration.reportLogs("fail",Button.class.getSimpleName()+" - "+elementName + " is failed to click in"+driver.getTitle()+"/n"+e,driver);
            logs.logger("error", elementName + " is clicked"+"/n"+e,Button.class.getSimpleName(),"");
        }
        finally {
            if(status.equalsIgnoreCase("pass")){
                extentreportgeneration.reportLogs("pass",Button.class.getSimpleName()+" - "+elementName + " is clicked in "+driver.getTitle(),driver);
            }
            return status;
        }
    }

}
