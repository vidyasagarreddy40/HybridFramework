package PageObjects;

import TestBase.TestBase;
import actions.Button;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.webElementHelper;

import java.util.HashMap;
import java.util.Map;

public class LandingPage extends TestBase {


    Map<String, String> landingPageElements = new HashMap<>();
    webElementHelper EH = new webElementHelper();
    Button button = new Button();

    public LandingPage() {

        landingPageElements.put("signIn", "xpath~//a[contains(text(),'Sign in')]");
        landingPageElements.put("getGMail", "xpath~//span[contains(text(),'Get Gmail')]");
        landingPageElements.put("forWork", "xpath~//a[contains(text(),'For work')]");

        PageFactory.initElements(TestBase.driver, this);
    }

    public void signInClick() {
        WebElement ele = EH.waitForInvisibilityOfElement(driver, webElementHelper.elements(landingPageElements.get("signIn").split("~")[0], landingPageElements.get("signIn").split("~")[1]), 5);
        button.click(driver, ele,"signIn","js");
    }

}
