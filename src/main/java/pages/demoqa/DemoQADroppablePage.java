package pages.demoqa;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQADroppablePage extends DemoQABasePage{
    private static final Logger logger = LoggerFactory.getLogger(DemoQADroppablePage.class);

    private static final String PATH_KEY = "droppable.path";

    private final SelenideElement draggable = $("#draggable");
    private final SelenideElement simpleDroppable = $("#droppable");

    public DemoQADroppablePage() {
        super();
    }

    public void open() {
        openByPath(PATH_KEY);
        logger.info("Opened Droppable page");
    }

    public void dragToDrop() {
        draggable.shouldBe(visible, enabled);
        simpleDroppable.shouldBe(visible);

        actions()
                .moveToElement(draggable)
                .clickAndHold(draggable)
                .moveToElement(simpleDroppable)
                .release(simpleDroppable)
                .perform();
    }

    public String getDropText() {
        return simpleDroppable
                .shouldBe(visible)
                .shouldHave(text("Dropped!"))
                .getText();
    }
}
