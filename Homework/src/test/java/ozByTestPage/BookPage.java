package ozByTestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BookPage extends BasicPage {

    @FindBy(className = "i-button__text")
    @CacheLookup
    private WebElement addToCartButtonLocator;

    public BookPage(WebDriver webdriver) {
        super(webdriver);
    }

    public void addToCart() {
        addToCartButtonLocator.click();
    }
}