package pages.demoqa;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.codeborne.selenide.Selenide.$;

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

    public void selectMultipleOptions(String[] values) {
        for (String value : values) {
            multiSelect.selectOption(value);
        }
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
