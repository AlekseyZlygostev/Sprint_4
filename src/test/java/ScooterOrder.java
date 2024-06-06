import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageLocators.*;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;

public class ScooterOrder {

    private WebDriver driver;

    @Test
    public void orderByHeaderButton(){
        //Выбор драйвера браузера и переход по ссылке
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.appCookieButtonClick();
        objHomePage.headerOrderButtonClick();

        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend("Джон", "Смит", "Вязов, д.13", "Лужники", "+79876543210");

        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.blackPearlCheckBoxClick();
        objAboutRent.grayHopelessnessCheckBoxClick();
        objAboutRent.commentFieldSendText("Постучать три раза и дважды подпрыгнуть");
        objAboutRent.aboutRentSend("позже", "пятеро суток");

        PlaceOrder objPlaceAnOrder = new PlaceOrder(driver);
        objPlaceAnOrder.yesButtonClick();

        OrderIsProcessed objOrderIsProcessed = new OrderIsProcessed(driver);
        String actualOrderIsProcessedText = objOrderIsProcessed.orderIsProcessedGetText();
        //System.out.println(actualOrderIsProcessedText);
        MatcherAssert.assertThat(actualOrderIsProcessedText, startsWith("Заказ оформлен"));
    }

    @Test
    public void orderByPageButton(){
        //Выбор драйвера браузера и переход по ссылке
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        HomePage objHomePage = new HomePage(driver);
        objHomePage.appCookieButtonClick();
        objHomePage.pageOrderButtonClick();

        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend("Василий", "Петров", "Петровка 38", "Сокольники", "87777777777");

        AboutRent objAboutRent = new AboutRent(driver);
        //objAboutRent.blackPearlCheckBoxClick();
        //objAboutRent.grayHopelessnessCheckBoxClick();
        //objAboutRent.commentFieldSendText("Постучать три раза и дважды подпрыгнуть");
        objAboutRent.aboutRentSend("завтра", "сутки");

        PlaceOrder objPlaceAnOrder = new PlaceOrder(driver);
        objPlaceAnOrder.yesButtonClick();

        OrderIsProcessed objOrderIsProcessed = new OrderIsProcessed(driver);
        String actualOrderIsProcessedText = objOrderIsProcessed.orderIsProcessedGetText();
        //System.out.println(actualOrderIsProcessedText);
        MatcherAssert.assertThat(actualOrderIsProcessedText, startsWith("Заказ оформлен"));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
