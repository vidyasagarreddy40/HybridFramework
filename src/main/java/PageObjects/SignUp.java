package PageObjects;

import TestBase.TestBase;
import actions.Button;
import actions.Textbox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import utilities.webElementHelper;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends TestBase {

    Map<String, String> signUpPageElements = new HashMap<>();
    webElementHelper EH = new webElementHelper();
    Textbox textbox=new Textbox();
    Button button=new Button();

    public SignUp() {
        signUpPageElements.put("EmailOrPhone", "xpath~//input[@type='email' and @id='identifierId']");
        signUpPageElements.put("Next", "xpath~//span[text()='Next']");
    }

    public void login(String Email){
        WebElement email = EH.waitForInvisibilityOfElement(driver, webElementHelper.elements(signUpPageElements.get("EmailOrPhone").split("~")[0], signUpPageElements.get("EmailOrPhone").split("~")[1]), 5);
        WebElement next = EH.waitForInvisibilityOfElement(driver, webElementHelper.elements(signUpPageElements.get("Next").split("~")[0], signUpPageElements.get("Next").split("~")[1]), 5);

        textbox.text(driver,email,"EmailOrPhone",Email);
        button.click(driver, next,"next","js");

    }
}
