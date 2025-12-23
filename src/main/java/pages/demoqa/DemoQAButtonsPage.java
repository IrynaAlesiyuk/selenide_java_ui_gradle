package pages.demoqa;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DemoQAButtonsPage extends DemoQABasePage {
    private static final Logger logger = LoggerFactory.getLogger(DemoQAButtonsPage.class);

    private static final String PATH_KEY = "buttons.path";

    private final SelenideElement doubleClickButton = $("#doubleClickBtn");
    private final SelenideElement doubleClickMessage = $("#doubleClickMessage");

    public DemoQAButtonsPage() {
        super();
    }

    public void open() {
        openByPath(PATH_KEY);
        logger.info("Opened Buttons page");
    }

    public void doubleClickButton() {
        logger.info("Double clicking on button");
        doubleClickButton.doubleClick();
    }

    public boolean isDoubleClickMessageVisible() {
        logger.info("Checking if double click message is visible");
        return doubleClickMessage.is(visible);
    }
}
