package maintestscenarios;

import commondata.OpenClose;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pagelocators.HomePage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DropListCheck extends OpenClose {

    private final int questionNumber;
    private final String dropListText;

    public DropListCheck(int questionNumber, String dropListText) {
        this.questionNumber = questionNumber;
        this.dropListText = dropListText;
    }

    @Parameterized.Parameters
    public static Object[][] getAnswer() {
        return new Object[][] {
                //Сравнивать выпадающий текст будем с текстом из требований https://praktikum.notion.site/82-d6b843a12b8e42989267e8ea330f6b1c
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат в эту дату до конца дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Если что-то срочное — всегда можно позвонить в поддержку по номеру 0101."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватит на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, отменить можно, пока курьер не выдвинулся к вам с самокатом. Штрафа не будет, объяснительной записки не попросим."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},

        };
    }

    @Test
    public void dropListTest() {

        HomePage objHomePage = new HomePage(driver);
        objHomePage.appCookieButtonClick();

        String actualDropListText = objHomePage.dropListCheck(questionNumber);
        //System.out.println(actualDropListText);
        assertEquals(dropListText, actualDropListText);
    }
    }
