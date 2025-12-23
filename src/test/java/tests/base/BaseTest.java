package tests.base;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        Configuration.timeout = 5000;

        logger.info("Starting Selenide tests...");
        logger.info("Browser: {}, Headless: {}", Configuration.browser, Configuration.headless);
        logger.info("Browser opened and base page loaded");
    }

    @AfterClass
    public void teardown() {
        logger.info("Closing Selenide browser...");
        try {
            com.codeborne.selenide.WebDriverRunner.closeWebDriver();
            logger.info("Browser closed successfully");
        } catch (Exception e) {
            logger.error("Error while closing browser", e);
        }
    }
}
