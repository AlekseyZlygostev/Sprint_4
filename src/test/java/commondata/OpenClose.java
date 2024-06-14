package commondata;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenClose {

    protected WebDriver driver;

    @Before
    public void openLinkInBrowser() {
        //Выбор драйвера браузера и переход по ссылке
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get(URLs.SCOOTER_HOMEPAGE);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
