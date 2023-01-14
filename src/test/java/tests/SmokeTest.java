package tests;

import pages.AgePage;
import pages.EighteenYearsOldPage;
import pages.HomePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest{
    private final String expectedUrlEighteenPage = "http://u920152e.beget.tech/page2.html";
    private final String randomEmail = RandomStringUtils.randomAlphabetic(5) + "@"
            + RandomStringUtils.randomAlphabetic(5) + ".com";
    private final String randomPass = RandomStringUtils.randomAlphabetic(5);


    @Test
    public void verityThaTInitialValueOfTimerIsZero(){
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().isDisplayed(), "Home page is not opened");
        Assert.assertEquals(homePage.getMinutesAndSeconds(), "00:00", "Initial state of timer is not \"00:00\"");
    }

    @Test
    public void verifyThatSecondAndThirdPageOpen(){
        HomePage homePage = new HomePage();
        homePage.clickLogin(randomEmail, randomPass);
        AgePage agePage = new AgePage();
        Assert.assertTrue(agePage.state().isDisplayed(), "Age page is not opened");
        agePage.clickFirstValue();
        EighteenYearsOldPage eighteenYearsOldPage = new EighteenYearsOldPage();
        Assert.assertTrue(eighteenYearsOldPage.state().isDisplayed(), "The third page did not open");
        Assert.assertEquals(getBrowser().getCurrentUrl(), expectedUrlEighteenPage, "Url is not correspond to expectation");
    }
}
