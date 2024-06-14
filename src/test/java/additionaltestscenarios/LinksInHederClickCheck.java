package additionaltestscenarios;

import commondata.OpenClose;
import org.junit.Test;
import pagelocators.HomePage;
import commondata.URLs;
import pagelocators.ZenHomePage;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class LinksInHederClickCheck extends OpenClose {

    @Test
    public void linkYandexClickCheck() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.yandexLogoClick();

        Set<String> windowHandles = driver.getWindowHandles();
        String newTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(newTab);

        ZenHomePage objZenHomePage = new ZenHomePage(driver);
        objZenHomePage.zenHeaderCheck();

        assertEquals(URLs.ZEN_HOMEPAGE, driver.getCurrentUrl());
    }

    @Test
    public void linkScooterClickCheck() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.headerOrderButtonClick();
        objHomePage.scooterLogoClick();
        assertEquals(URLs.SCOOTER_HOMEPAGE, driver.getCurrentUrl());
    }
}
