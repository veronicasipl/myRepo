package ozByTestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasketPage extends BasicPage {

    private static final long TIMEOUT = 1;

    public BasketPage(WebDriver webdriver) {
        super(webdriver);
    }

    public void checkCart(String bookName) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("goods-block")));
        WebElement bookLink = driver.findElement(By.xpath("//a[contains(.,'" + bookName + "')]"));
        Assert.assertTrue(bookLink.isDisplayed(), "Book " + bookName + " is absent in cart");
    }
}