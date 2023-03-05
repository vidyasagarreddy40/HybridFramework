package Listnerspack;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.loggerlogs;

public class listnerClass implements ITestListener {

    loggerlogs logs=new loggerlogs();

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
       // logs.logger("error", "Test is failed", iTestResult.getTestName(),"");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
