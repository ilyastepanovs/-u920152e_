package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private static final ISettingsFile environment = new JsonSettingsFile("settings.json");
    private static final String DEFAULT_URL = environment.getValue("/url").toString();

    protected BaseTest() {

    }

    @BeforeMethod
    protected void beforeMethod() {
        getBrowser().goTo("http://u920152e.beget.tech/");
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
}
