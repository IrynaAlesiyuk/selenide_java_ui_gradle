package tests.base.listeners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

import static utils.ScreenshotUtils.getScreenshotName;

public class ScreenshotOnFailListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(ScreenshotOnFailListener.class);
    private static final String SCREENSHOTS_DIR = "screenshots";


    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();

        ScreenshotUtils.createFolderIfNotExists(SCREENSHOTS_DIR);
        Configuration.reportsFolder = SCREENSHOTS_DIR;

        String screenshotName = getScreenshotName("FAIL_" + result.getName());

        String savedScreenshot = Selenide.screenshot(screenshotName);
        logger.error("Test '{}' failed. Screenshot saved at: {}/{}.png", testName, SCREENSHOTS_DIR, savedScreenshot);
    }

    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}
