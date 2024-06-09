package pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderStatus {

    private WebDriver driver;

    //Картинка Такого заказа нет
    private By noSuchOrderImage = By.xpath(".//img[@alt='Not found']");

    public OrderStatus(WebDriver driver) {
        this.driver = driver;
    }

    public String noSuchOrderImageGetText(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(driver.findElement(noSuchOrderImage)));
        return driver.findElement(noSuchOrderImage).getAttribute("src");
    }
}
