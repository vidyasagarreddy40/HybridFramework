package functionalSuite;

import PageObjects.LandingPage;
import PageObjects.SignUp;
import TestBase.TestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.dbHelper;

@Listeners(Listnerspack.listnerClass.class)
public class signUp extends TestBase {

    LandingPage landingPage = new LandingPage();
    SignUp singup= new SignUp();
    SoftAssert asrt=new SoftAssert();
    dbHelper dbhelper=new dbHelper();


    @Test
    public void LandingPageVerification() {
       landingPage.signInClick();
    }

    @Test
    public void signing() {
        landingPage.signInClick();
        singup.login(dbhelper.fetchSignUp(Thread.currentThread().getStackTrace()[1].getMethodName()).get("Email"));

    }
}
