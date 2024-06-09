package pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderIsProcessed {

    private WebDriver driver;

    //Сообщение Заказ оформлен
    private By orderIsProcessedMessage = By.className("Order_ModalHeader__3FDaJ");

    public OrderIsProcessed(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка доступности и получение текста сообщения
    public String orderIsProcessedGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(orderIsProcessedMessage)));
        return driver.findElement(orderIsProcessedMessage).getText();

    }
}
