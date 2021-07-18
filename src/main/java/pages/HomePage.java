package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseDriver;

public class HomePage extends BaseDriver {
    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement login;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        login.click();
    }
}
