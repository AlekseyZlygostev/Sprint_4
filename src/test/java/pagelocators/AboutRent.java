package pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Date;

public class AboutRent {

    private WebDriver driver;

    //Поле Дата доставки
    private By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Кнопка Следующий месяц
    private By nextMonthButton = By.xpath(".//button[contains(@class,'react-datepicker__navigation--next')]");
    //Выпадающий квлендарь
    private String daySelect = ".//div[text() = '";
    private By calenderList = By.xpath(daySelect);
    //Поле Срок аренды
    private By rentalPeriodField = By.className("Dropdown-placeholder");
    //Выпадающий список Срок аренды
    private String period = ".//div[text() = '";
    private By rentalPeriodList = By.xpath(period);
    //Поле Цвет самоката
    private By scooterColorField = By.className("Order_Title__3EKne");
    //Чекбокс Черный жемчуг
    private By blackPearlCheckBox = By.id("black");
    //Чекбокс Серая безысходность
    private By grayHopelessnesslCheckBox = By.id("grey");
    //Поле Комментарий для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Заказать
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");

    public AboutRent(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка доступности и выбор Даты доставки
    public void whenBringScooterFieldSelect(String whenBring){
        Date current = new Date();
        int day = current.getDate();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(deliveryDateField)));
        driver.findElement(deliveryDateField).click();
        if (whenBring.equals("завтра")){
            day += 1;
            daySelect = daySelect + day + "']";
            calenderList = By.xpath(daySelect);
        }
        else if (whenBring.equals("позже")){
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(driver.findElement(nextMonthButton)));
            driver.findElement(nextMonthButton).click();
            daySelect = daySelect + 15 + "']";
            calenderList = By.xpath(daySelect);
        }
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(calenderList)));
        driver.findElement(calenderList).click();
    }

    //Проверка доступности и выбор Срока аренды
    public void rentalPeriodFieldSelect(String daysCount){
        period = period + daysCount + "']";
        rentalPeriodList = By.xpath(period);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(rentalPeriodField)));
        driver.findElement(rentalPeriodField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(rentalPeriodList)));
        driver.findElement(rentalPeriodList).click();
    }

    //Клик по чекбоксу Черный жемчуг
    public void blackPearlCheckBoxClick(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(blackPearlCheckBox)));
        driver.findElement(blackPearlCheckBox).click();
    }

    //Клик по чекбоксу Серая безысходность
    public void grayHopelessnessCheckBoxClick(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(grayHopelessnesslCheckBox)));
        driver.findElement(grayHopelessnesslCheckBox).click();
    }

    public void selectColor(int color){
        if (color == 1){
            blackPearlCheckBoxClick();
        } else if (color == 2) {
            grayHopelessnessCheckBoxClick();
        } else if (color == 3) {
            blackPearlCheckBoxClick();
            grayHopelessnessCheckBoxClick();
        }
        else return;
    }

    //Проверка доступности и заполнение поля Комментарий для курьера
    public void commentFieldSendText(String comment){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(commentField)));
        driver.findElement(commentField).sendKeys(comment);
    }

    //Проверка доступности и клик по кнопке Заказать
    public void orderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderButton)));
        driver.findElement(orderButton).click();
    }

    //Шаги заполнения обязательных полей формы Про аренду
    public void aboutRentSend(String whenBring, String daysCount){
        whenBringScooterFieldSelect(whenBring);
        rentalPeriodFieldSelect( daysCount);
        orderButtonClick();
    }

    //Проверка доступности и получение текста плейсхолдера Дата доставки
    public String deliveryDateFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(deliveryDateField)));
        return driver.findElement(deliveryDateField).getAttribute("placeholder");
    }

    //Проверка доступности и получение текста плейсхолдера Срок аренды
    public String rentalPeriodFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(rentalPeriodField)));
        return driver.findElement(rentalPeriodField).getText();
    }

    //Проверка доступности и получение текста плейсхолдера Цвет самоката
    public String scooterColorFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(scooterColorField)));
        return driver.findElement(scooterColorField).getText();
    }

    //Проверка доступности и получение текста плейсхолдера Комментарий для курьера
    public String commentFieldGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(commentField)));
        return driver.findElement(commentField).getAttribute("placeholder");
    }
}
