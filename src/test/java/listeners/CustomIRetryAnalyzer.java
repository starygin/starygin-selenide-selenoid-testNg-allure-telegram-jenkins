package listeners;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;

import static org.openqa.selenium.OutputType.BYTES;

public class CustomIRetryAnalyzer implements IRetryAnalyzer {

    static int maxCount;
    Map<String, Integer> hashMap = new HashMap<>();

    @Override
    public boolean retry(ITestResult iTestResult) {
        String testName = iTestResult.getTestClass().toString();
        hashMap.putIfAbsent(testName, 0);
        if (hashMap.get(testName) < maxCount) {
            hashMap.put(testName, hashMap.get(testName) + 1);
            makeScreenshotOnRetry();
            return true;
        }
        return false;
    }

    @Attachment("Retry")
    private byte[] makeScreenshotOnRetry() {
        return Selenide.screenshot(BYTES);
    }


}
