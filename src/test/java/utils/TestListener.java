package utils;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.BaseTest;

public class TestListener implements ITestListener {
    private static String getTestMethodName(ITestResult testResult){
        return testResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (){
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(value="{0}", type="test/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result){
        saveScreenshotPNG();
        saveTextLog(getTestMethodName(result));
    }
}