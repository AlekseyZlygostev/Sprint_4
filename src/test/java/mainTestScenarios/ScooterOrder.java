package mainTestScenarios;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageLocators.*;
import static org.hamcrest.CoreMatchers.startsWith;

public class ScooterOrder {

    private WebDriver driver;

    @Before
    public void openLinkInBrowser() {
        //Выбор драйвера браузера и переход по ссылке
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void orderByHeaderButton(){
        HomePage objHomePage = new HomePage(driver);
        objHomePage.appCookieButtonClick();
        //Клик по кнопке Заказать в хедере
        objHomePage.headerOrderButtonClick();
        //Заполнение формы Для кого самокат
        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend("Джон", "Смит", "Вязов, д.13", "Лужники", "+79876543210");
        //Заполнение формы Про аренду
        AboutRent objAboutRent = new AboutRent(driver);
        objAboutRent.blackPearlCheckBoxClick();
        objAboutRent.grayHopelessnessCheckBoxClick();
        objAboutRent.commentFieldSendText("Постучать три раза и дважды подпрыгнуть");
        objAboutRent.aboutRentSend("позже", "пятеро суток");
        //Подтверждение заказа
        PlaceOrder objPlaceAnOrder = new PlaceOrder(driver);
        objPlaceAnOrder.yesButtonClick();
        //Проверка вывода информации о совершенном заказе
        OrderIsProcessed objOrderIsProcessed = new OrderIsProcessed(driver);
        String actualOrderIsProcessedText = objOrderIsProcessed.orderIsProcessedGetText();
        //System.out.println(actualOrderIsProcessedText);
        MatcherAssert.assertThat(actualOrderIsProcessedText, startsWith("Заказ оформлен"));
    }

    @Test
    public void orderByPageButton(){
        HomePage objHomePage = new HomePage(driver);
        objHomePage.appCookieButtonClick();
        //Клик по кнопке Заказать внизу страницы
        objHomePage.pageOrderButtonClick();
        //Заполнение формы Для кого самокат
        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend("Василий", "Петров", "Петровка 38", "Сокольники", "87777777777");
        //Заполнение формы Про аренду
        AboutRent objAboutRent = new AboutRent(driver);
        //objAboutRent.blackPearlCheckBoxClick();
        //objAboutRent.grayHopelessnessCheckBoxClick();
        //objAboutRent.commentFieldSendText("Постучать три раза и дважды подпрыгнуть");
        objAboutRent.aboutRentSend("завтра", "сутки");
        //Подтверждение заказа
        PlaceOrder objPlaceAnOrder = new PlaceOrder(driver);
        objPlaceAnOrder.yesButtonClick();
        //Проверка вывода информации о совершенном заказе
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
