package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    //Вопросы о важном
    private String questionID = "accordion__heading-";
    private By question = By.id(questionID);
    //Ответы на вопросы
    private By answer = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]//p");
    //Кнопка Заказать в хедере
    private By headerOrderButton = By.className("Button_Button__ra12g");
    //Кнопка Заказать внизу страницы
    private By pageOrderButton = By.xpath(".//button[contains(@class,'Button_UltraBig__UU3Lp')]");
    //Кнопка Статус заказа
    private By orderStatusButton = By.className("Header_Link__1TAG7");
    //Логотип Яндекс
    private By yandexLogo = By.xpath(".//img[@alt='Yandex']");
    //Логотип Самокат
    private By scooterLogo = By.xpath(".//img[@alt='Scooter']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Уточнение локатора выпадающего списка "Вопросы о важном", скролл до элемента списка, ожидание его прогрузки, клик
    public void dropListClick(int questionNumber){
        questionID = questionID + questionNumber;
        question = By.id(questionID);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(question));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(question)));
        driver.findElement(question).click();
    }

    //Проверка доступности и получение выпадающего текста
    public String dropListGetText(){
        assertTrue(driver.findElement(answer).isEnabled());
        return driver.findElement(answer).getText();
    }

    //Шаги клика по элементу выпадающего списка и получение выпадающего текста
    public String dropListCheck(int questionNumber){
        dropListClick(questionNumber);
        String dropListText = dropListGetText();
        return dropListText;
    }

    //Проверка доступности и клик по кнопке Заказать в хедере
    public void headerOrderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(headerOrderButton)));
        driver.findElement(headerOrderButton).click();
    }

    //Скролл, проверка доступности и клик по кнопке Заказать внизу страницы
    public void pageOrderButtonClick(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(pageOrderButton));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(pageOrderButton)));
        driver.findElement(pageOrderButton).click();
    }

    //Проверка доступности и клик по кнопке Статус заказа
    public void orderStatusButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderStatusButton)));
        driver.findElement(orderStatusButton).click();
    }

    //Проверка доступности и клик по лого Яндекса
    public void yandexLogoClick() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(yandexLogo)));
        driver.findElement(yandexLogo).click();
    }

    //Проверка доступности и клик по лого Самоката
    public void scooterLogoClick() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(scooterLogo)));
        driver.findElement(scooterLogo).click();
    }
}
