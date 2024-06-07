package additionalTestScenarios;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageLocators.HomePage;
import pageLocators.OrderStatus;
import static org.hamcrest.CoreMatchers.endsWith;

public class WrongOrderNumber {

    private WebDriver driver;

    @Test
    public void wrongOrderNumberSend() {
        //Выбор драйвера браузера и переход по ссылке
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkWrongOrderNumber("123456789");

        OrderStatus objOrderStatus = new OrderStatus(driver);
        String noSuchOrderImageText = objOrderStatus.noSuchOrderImageGetText();
        //System.out.println(noSuchOrderImageText);
        MatcherAssert.assertThat(noSuchOrderImageText, endsWith("not-found.png"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
