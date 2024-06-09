package pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ZenHomePage {

    private WebDriver driver;

    private By zenHeader = By.xpath(".//header");

    public ZenHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void zenHeaderCheck(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(zenHeader)));
    }
}
