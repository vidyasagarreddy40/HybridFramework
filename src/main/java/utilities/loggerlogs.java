package utilities;

import TestBase.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class loggerlogs {

    public Logger log;
    public static String browserName;
    public static String browserVersion;
    SoftAssert softAssert= new SoftAssert();

    public loggerlogs() {
        //log = Logger.getLogger(String.valueOf(classname));
        log = LogManager.getLogger();
    }

    private String currentClassName() {
        return this.getClass().getSimpleName();
    }

    private String currentMethodName(String className) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int threadCount;
        for (threadCount = 0; threadCount < stackTrace.length; threadCount++) {
            if (stackTrace[threadCount].toString().contains(className) && !stackTrace[threadCount].getMethodName().equalsIgnoreCase("currentMethodName")) {
                break;
            }
        }
        return stackTrace[threadCount].getMethodName();
    }

    public void setBrowserAndversion(String browserName, String browserVersion){
        Capabilities cap = ((RemoteWebDriver) TestBase.driver).getCapabilities();
        browserName = cap.getBrowserName().toLowerCase();
        browserVersion=cap.getVersion().toLowerCase();
        this.browserName=browserName;
        this.browserVersion=browserVersion;
    }
    public String getBrowserNameAndVersion(){
        setBrowserAndversion(browserName,browserVersion);
        return browserName+" "+browserVersion;
    }

    public void logger(String logType, String logMessage, String classname, Object... otherVarArgs) {

        String currentclassname = currentClassName();
        String currentmethodname = currentMethodName(String.valueOf(classname));
        String stringFormatMsg=String.format("%1$s: %2$s_%3$s: %4$s", getBrowserNameAndVersion(), classname,currentmethodname,logMessage);

        switch (logType) {
            case "info":

                log.info(stringFormatMsg,otherVarArgs);
                break;
            case "debug":
                log.warn(stringFormatMsg,otherVarArgs);
                break;
            case "error":
                log.error("RP_MESSAGE#FILE#{}#{}",otherVarArgs[0], stringFormatMsg);
                break;
            case "warn":
                log.error("RP_MESSAGE#FILE#{}#{}",otherVarArgs[0], stringFormatMsg);
                break;
        }
    }
}
