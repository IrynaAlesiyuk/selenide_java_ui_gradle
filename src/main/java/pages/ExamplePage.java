package pages;

import config.Config;

public class ExamplePage extends BasePage{

    public ExamplePage() {
        super(Config.get("example.base.url"));
    }

    public void open() {
        navigateTo(baseUrl);
    }
}
