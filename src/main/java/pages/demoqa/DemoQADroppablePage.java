package pages.demoqa;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

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
        logger.info("Dragging element to droppable area");
        actions().dragAndDrop(draggable, simpleDroppable).perform();
    }

    public String getDropText() {
        String text = simpleDroppable.getText();
        logger.info("Droppable text: {}", text);
        return text;
    }
}
