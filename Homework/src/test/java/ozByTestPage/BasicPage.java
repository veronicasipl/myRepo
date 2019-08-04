package ozByTestPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasicPage {

    protected WebDriver driver;

    public BasicPage(WebDriver webdriver) {
        driver = webdriver;
        PageFactory.initElements(driver, this);
    }
}