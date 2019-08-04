package ozByTestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {

    private WebDriver driver;
    private static final long TIMEOUT = 1;

    @FindBy(className = "top-panel__userbar")
    private WebElement enterButtonLocator;
    @FindBy(xpath = "//*[@id=\"loginFormLoginEmailLink\"]")
    @CacheLookup
    private WebElement loginByEmailButtonLocator;
    @FindBy(name = "cl_email")
    @CacheLookup
    private WebElement emailFieldLocator;
    @FindBy(name = "cl_psw")
    @CacheLookup
    private WebElement passwordFieldLocator;
    @FindBy(xpath = "//*[@id=\"loginForm\"]/button")
    @CacheLookup
    private WebElement confirmLoginButtonLocator;
    @FindBy(id = "top-s")
    @CacheLookup
    private WebElement searchBoxLocator;
    @FindBy(css = "#search-top > div > span.search-tools > button")
    @CacheLookup
    private WebElement searchButtonLocator;
    @FindBy(className = "top-panel__userbar__cart__item")
    @CacheLookup
    private WebElement cartButtonLocator;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String email, String password) {
        enterButtonLocator.click();
        loginByEmailButtonLocator.click();
        emailFieldLocator.sendKeys(email);
        passwordFieldLocator.sendKeys(password);
        confirmLoginButtonLocator.click();
        return new HomePage(driver);
    }

    public BookPage searchBook(String bookName) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("top-s"))).sendKeys(bookName);
        searchButtonLocator.click();
        return new BookPage(driver);
    }

    public BasketPage openCart() {
        cartButtonLocator.click();
        return new BasketPage(driver);
    }
}