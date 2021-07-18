package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BaseDriver;

public class LoginPage extends BaseDriver {

    @FindBy(how = How.XPATH, using = "//*[@id=\"lv-pages-banner\"]/div/h1")
    public WebElement signInText;

    @FindBy(how = How.XPATH, using = "//input[@class='button-1 register-button']")
    public WebElement registerButton;

    @FindBy(how = How.ID_OR_NAME, using = "Email")
    public WebElement email;

    @FindBy(how = How.ID_OR_NAME, using = "Password")
    public WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@class='button-1 login-button']")
    public WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void isWelcomeSignAvailable(String text) {
        String welcomeSignIn = signInText.getText();
        Assert.assertEquals(text, welcomeSignIn);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public HomePage enterCredentialsLogin(String username, String pass) {
        email.sendKeys(username);
        password.sendKeys(pass);
        loginButton.click();
        return new HomePage();
    }

    public void isLoginSuccessful(String title) {
        Assert.assertEquals(title, "Options, Equity & ETF - Tick & Trade Data – Cboe LiveVol Data Shop");
    }

    public void closeBrowser() {
        driver.close();
    }
}
