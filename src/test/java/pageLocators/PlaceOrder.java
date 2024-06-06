package pageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PlaceOrder {

    private WebDriver driver;

    //Кнопка Да
    private By yesButton = By.xpath(".//button[text()='Да']");

    public PlaceOrder(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка доступности и клик по кнопке Да
    public void yesButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(yesButton)));
        driver.findElement(yesButton).click();
    }
}
