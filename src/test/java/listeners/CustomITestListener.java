package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomITestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        if (System.getenv("RETRY") == null) {
            CustomIRetryAnalyzer.maxCount = 2;
        } else {
            CustomIRetryAnalyzer.maxCount = Integer.parseInt(System.getenv("RETRY"));
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

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
