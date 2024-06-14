package pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ScooterFor {

    private WebDriver driver;

    //Поле Имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    //Поле Фамилия
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле Адрес
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private By stationField = By.xpath(".//input[@placeholder='* Станция метро']");
    //Выпадающий список Станция метро
    private String stationXPath = ".//div[text() = '";
    private By stationList = By.xpath(stationXPath);
    //Поле Телефон
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By nextButton = By.xpath(".//button[text()='Далее']");

    public ScooterFor(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка доступности и заполнение поля Имя
    public void nameFieldSendText(String name){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(nameField)));
        driver.findElement(nameField).sendKeys(name);
    }

    //Проверка доступности и заполнение поля Фамилия
    public void surnameFieldSendText(String surname){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(surnameField)));
        driver.findElement(surnameField).sendKeys(surname);
    }

    //Проверка доступности и заполнение поля Адрес
    public void addressFieldSendText(String address){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(addressField)));
        driver.findElement(addressField).sendKeys(address);
    }

    //Проверка доступности и выбор Станции метро
    public void stationFieldSendText(String station){
        stationXPath = stationXPath + station + "']";
        stationList = By.xpath(stationXPath);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(stationField)));
        driver.findElement(stationField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(stationList)));
        driver.findElement(stationList).click();
    }

    //Проверка доступности и заполнение поля Телефон
    public void phoneFieldSendText(String phone){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(phoneField)));
        driver.findElement(phoneField).sendKeys(phone);
    }

    //Проверка доступности и клик по кнопке Далее
    public void nextButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(nextButton)));
        driver.findElement(nextButton).click();
    }

    //Шаги заполнения формы Для кого самокат
    public void scooterForSend(String name, String surname, String address, String station, String phone){
        nameFieldSendText(name);
        surnameFieldSendText(surname);
        addressFieldSendText(address);
        stationFieldSendText(station);
        phoneFieldSendText(phone);
        nextButtonClick();
    }

    //Проверка доступности и получение текста плейсхолдера Имя
    public String nameFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(nameField)));
        return driver.findElement(nameField).getAttribute("placeholder");
    }

    //Проверка доступности и получение текста плейсхолдера Фамилия
    public String surnameFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(surnameField)));
        return driver.findElement(surnameField).getAttribute("placeholder");
    }

    //Проверка доступности и получение текста плейсхолдера Адрес
    public String addressFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(addressField)));
        return driver.findElement(addressField).getAttribute("placeholder");
    }

    //Проверка доступности и получение текста плейсхолдера Станции метро
    public String stationFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(stationField)));
        return driver.findElement(stationField).getAttribute("placeholder");
    }

    //Проверка доступности и получение текста плейсхолдера Телефон
    public String phoneFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(phoneField)));
        return driver.findElement(phoneField).getAttribute("placeholder");
    }
}
