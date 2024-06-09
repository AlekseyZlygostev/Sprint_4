package additionaltestscenarios;

import commondata.OpenClose;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import pagelocators.HomePage;
import pagelocators.OrderStatus;
import static org.hamcrest.CoreMatchers.endsWith;

public class WrongOrderNumber extends OpenClose {

    @Test
    public void wrongOrderNumberSend() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkOrderNumber("123456789");

        OrderStatus objOrderStatus = new OrderStatus(driver);
        String noSuchOrderImageText = objOrderStatus.noSuchOrderImageGetText();
        //System.out.println(noSuchOrderImageText);
        MatcherAssert.assertThat(noSuchOrderImageText, endsWith("not-found.png"));
    }
}
