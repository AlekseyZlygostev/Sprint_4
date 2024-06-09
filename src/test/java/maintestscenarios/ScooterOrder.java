package maintestscenarios;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import commondata.OpenClose;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pagelocators.*;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class ScooterOrder extends OpenClose{

    private final int whichButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String phone;
    private final String whenBring;
    private final String daysCount;
    private final int color;
    private final String comment;

    public ScooterOrder(int whichButton, String name, String surname, String address, String station, String phone, String whenBring, String daysCount, int color, String comment) {
        this.whichButton = whichButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.whenBring = whenBring;
        this.daysCount = daysCount;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswer() {
        return new Object[][] {
                {1, "Джон", "Смит", "Вязов, д.13", "Лужники", "+79876543210", "позже", "пятеро суток", 2, "Постучать три раза и дважды подпрыгнуть"},
                {2, "Василий", "Петров", "Петровка 38", "Сокольники", "87777777777", "завтра", "сутки", 0, ""},
        };
    }

    @Test
    public void orderByHeaderButton(){
        HomePage objHomePage = new HomePage(driver);
        objHomePage.appCookieButtonClick();
        //Клик по кнопке Заказать в хедере(1) или внизу страницы (2)
        objHomePage.whichButtonClick(whichButton);
        //Заполнение формы Для кого самокат
        ScooterFor objScooterFor = new ScooterFor(driver);
        objScooterFor.scooterForSend(name, surname, address, station, phone);
        //Заполнение формы Про аренду
        AboutRent objAboutRent = new AboutRent(driver);
        //Выбор цвета самоката: 0 - не выбрано, 1 - Черный жемчуг, 2 - Серая безысходность, 3 - выбрать оба варианта
        objAboutRent.selectColor(color);
        objAboutRent.commentFieldSendText(comment);
        objAboutRent.aboutRentSend(whenBring, daysCount);
        //Подтверждение заказа
        PlaceOrder objPlaceAnOrder = new PlaceOrder(driver);
        objPlaceAnOrder.yesButtonClick();
        //Проверка вывода информации о совершенном заказе
        OrderIsProcessed objOrderIsProcessed = new OrderIsProcessed(driver);
        String actualOrderIsProcessedText = objOrderIsProcessed.orderIsProcessedGetText();
        //System.out.println(actualOrderIsProcessedText);
        MatcherAssert.assertThat(actualOrderIsProcessedText, startsWith("Заказ оформлен"));
    }
}
