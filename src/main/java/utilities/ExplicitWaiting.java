package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaiting {

    public static WebElement explicitWaitInvisibilityOfElementLocated(WebDriver driver, By element, int time){

        WebDriverWait waitForPresence= new WebDriverWait(driver, time);

        return  waitForPresence.until(ExpectedConditions.presenceOfElementLocated(element));

    }
}
