package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.*;


public class BasePage {

    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    protected final String baseUrl;

    protected BasePage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected void navigateTo(String url) {
        logger.info("Navigating to URL: {}", url);
        open(url);
    }

    public String getTitle() {
        return title();
    }

    public void goBack() {
        logger.info("Navigating back");
        back();
    }

    public void goForward() {
        logger.info("Navigating forward");
        forward();
    }

    public void reload() {
        logger.info("Reloading page");
        refresh();
    }
}
