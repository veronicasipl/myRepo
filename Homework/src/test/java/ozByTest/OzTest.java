package ozByTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OzTest {

    private WebDriver driver;
    private static final String URL = "https://www.oz.by";
    private static final String EMAIL = "veron.s2011@yandex.ru";
    private static final String PASSWORD = "ts78Pj";
    private static final String BOOK_NAME = "Философия Java";
    private static final long TIMEOUT = 1;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        configureImplicitWait();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void findBook() {
        driver.get(URL);
        login(EMAIL, PASSWORD);
        searchBook(BOOK_NAME);
        addToCart();
    }

    private void login(String email, String password) {
        WebElement enterButton = driver.findElement(By.className("top-panel__userbar"));
        enterButton.click();
        WebElement loginByEmailButton = driver.findElement(By.xpath("//*[@id=\"loginFormLoginEmailLink\"]"));
        loginByEmailButton.click();
        WebElement emailField = driver.findElement(By.name("cl_email"));
        emailField.click();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.name("cl_psw"));
        passwordField.sendKeys(password);
        WebElement confirmLoginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button"));
        confirmLoginButton.click();
    }

    private void searchBook(String bookName) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("top-s"))).sendKeys(bookName);
        WebElement searchButton = driver.findElement(By.cssSelector("#search-top > div > span.search-tools > button"));
        searchButton.click();
    }

    private void addToCart() {
        WebElement addToCartButton = driver.findElement(By.className("i-button__text"));
        addToCartButton.click();
    }

    private void configureImplicitWait() {
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }
}