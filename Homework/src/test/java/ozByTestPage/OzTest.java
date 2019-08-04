package ozByTestPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OzTest {

    private static final String EMAIL = "veron.s2011@yandex.ru";
    private static final String PASSWORD = "ts78Pj";
    private static final String BOOK_NAME = "Философия Java";
    private static final String URL = "https://www.oz.by";

    private DriverManager driverManager;
    private Header header;

    @BeforeClass
    public void beforeClass() {
        driverManager = new DriverManager();
        header = new Header(driverManager.getDriver());
        driverManager.getDriver().get(URL);
    }

    @AfterClass
    public void afterClass() {
        driverManager.getDriver().quit();
    }

    @Test
    public void findBook() {
        header.login(EMAIL, PASSWORD);
        BookPage bookPage = header.searchBook(BOOK_NAME);
        bookPage.addToCart();
        BasketPage basketPage = header.openCart();
        basketPage.checkCart(BOOK_NAME);
    }
}