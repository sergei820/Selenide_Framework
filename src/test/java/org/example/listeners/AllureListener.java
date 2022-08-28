package org.example.listeners;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On start method " + context.getName());
        context.setAttribute("WebDriver", WebDriverRunner.getWebDriver());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + getTestMethodName(result));
        saveScreenshot(WebDriverRunner.getWebDriver());
        saveTextLog(getTestMethodName(result) + " failed. Screenshot taken.");
        Allure.addAttachment("Attaching screenshot to Allure Report", new ByteArrayInputStream(saveScreenshot(WebDriverRunner.getWebDriver())));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + getTestMethodName(result));
        saveScreenshot(WebDriverRunner.getWebDriver());
        saveTextLog(getTestMethodName(result) + " passed. Screenshot taken.");
        Allure.addAttachment("Attaching screenshot to Allure Report", new ByteArrayInputStream(saveScreenshot(WebDriverRunner.getWebDriver())));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + getTestMethodName(result));
    }

    public static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(WebDriver driver) {
        System.out.println("taking screenshot");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
