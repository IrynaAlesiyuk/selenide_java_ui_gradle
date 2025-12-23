package pages.demoqa;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DemoQASelectPage extends DemoQABasePage{
    private static final Logger logger = LoggerFactory.getLogger(DemoQASelectPage.class);

    private static final String PATH_KEY = "select.menu.path";

    private final SelenideElement singleSelect = $("#oldSelectMenu");
    private final SelenideElement multiSelect = $("#cars");

    public DemoQASelectPage() {
        super();
    }

    public void open() {
        openByPath(PATH_KEY);
        logger.info("Opened Select Menu page");
    }

    public void selectSingleOption(String value) {
        logger.info("Selecting single option: {}", value);
        singleSelect.selectOption(value);
    }

    public void selectMultipleOptions(String... values) {
        multiSelect
                .shouldBe(visible, enabled)
                .scrollIntoView(true);

        executeJavaScript(
                "Array.from(arguments[0].options).forEach(o => o.selected = false);" +
                        "Array.from(arguments[0].options).forEach(o => {" +
                        "  if (Array.from(arguments[1]).includes(o.value)) o.selected = true;" +
                        "});" +
                        "arguments[0].dispatchEvent(new Event('change'));",
                multiSelect,
                values
        );
    }

    public String getSingleValue() {
        return singleSelect.getValue();
    }

    public String[] getMultipleValues() {
        return multiSelect
                .getSelectedOptions()
                .texts()
                .toArray(new String[0]);
    }
}
