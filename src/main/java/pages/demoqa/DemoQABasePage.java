package pages.demoqa;

import config.Config;
import pages.BasePage;

public class DemoQABasePage extends BasePage {

    public DemoQABasePage() {
        super(Config.get("demoqa.base.url"));
    }

    protected void openByPath(String pathKey) {
        String url = baseUrl + Config.get(pathKey);
        navigateTo(url);
    }
}
