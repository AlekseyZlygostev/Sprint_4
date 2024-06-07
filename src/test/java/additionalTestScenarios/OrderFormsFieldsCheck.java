package additionalTestScenarios;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageLocators.AboutRent;
import pageLocators.HomePage;
import pageLocators.ScooterFor;

import static org.hamcrest.CoreMatchers.containsString;

public class OrderFormsFieldsCheck {

    private WebDriver driver;

    @Before
    public void openLinkInBrowserAndOrderButtonClick() {
        //Выбор драйвера браузера и переход по ссылке
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.appCookieButtonClick();
        objHomePage.headerOrderButtonClick();
    }

    @Test
    public void nameFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        MatcherAssert.assertThat(objScooterFor.nameFieldGetText(), containsString("Имя"));
    }

    @Test
    public void surnameFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        MatcherAssert.assertThat(objScooterFor.surnameFieldGetText(), containsString("Фамилия"));
    }

    @Test
    public void addressFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        MatcherAssert.assertThat(objScooterFor.adressFieldGetText(), containsString("Адрес"));
    }

    @Test
    public void stationFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        MatcherAssert.assertThat(objScooterFor.stationFieldGetText(), containsString("Станция метро"));
    }

    @Test
    public void phoneFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        MatcherAssert.assertThat(objScooterFor.phoneFieldGetText(), containsString("Телефон"));
    }

    @Test
    public void deliveryDateFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend("Джон", "Смит", "Вязов, д.13", "Лужники", "+79876543210");
        AboutRent objAboutRent = new AboutRent(driver);
        MatcherAssert.assertThat(objAboutRent.deliveryDateFieldGetText(), containsString("Дата доставки"));
    }

    @Test
    public void rentalPeriodFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend("Джон", "Смит", "Вязов, д.13", "Лужники", "+79876543210");
        AboutRent objAboutRent = new AboutRent(driver);
        MatcherAssert.assertThat(objAboutRent.rentalPeriodFieldGetText(), containsString("Срок аренды"));
    }

    @Test
    public void scooterColorFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend("Джон", "Смит", "Вязов, д.13", "Лужники", "+79876543210");
        AboutRent objAboutRent = new AboutRent(driver);
        MatcherAssert.assertThat(objAboutRent.scooterColorFieldGetText(), containsString("Цвет"));
    }

    @Test
    public void commentFieldCheck(){
        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend("Джон", "Смит", "Вязов, д.13", "Лужники", "+79876543210");
        AboutRent objAboutRent = new AboutRent(driver);
        MatcherAssert.assertThat(objAboutRent.commentFieldGetText(), containsString("Комментарий"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
