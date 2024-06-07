package additionalTestScenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageLocators.HomePage;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class LinksInHederClickCheck {

    private WebDriver driver;

    @Before
    public void openLinkInBrowser() {
        //Выбор драйвера браузера и переход по ссылке
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void linkYandexClickCheck() throws InterruptedException {

        HomePage objHomePage = new HomePage(driver);
        objHomePage.yandexLogoClick();
        Set<String> windowHandles = driver.getWindowHandles();
        String newTab = (String)windowHandles.toArray()[1];
        driver.switchTo().window(newTab);
        Thread.sleep(3000);
        //System.out.println(driver.getCurrentUrl());
        assertEquals("https://dzen.ru/", driver.getCurrentUrl());
    }

    @Test
    public void linkScooterClickCheck() {

        HomePage objHomePage = new HomePage(driver);
        objHomePage.headerOrderButtonClick();
        objHomePage.scooterLogoClick();
        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
