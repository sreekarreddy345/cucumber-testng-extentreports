package parallel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseDriver;

public class LoginStepDefinition extends BaseDriver {

    HomePage homePage;
    LoginPage loginPage;


    @Given("^user is already on Data shop home page$")
    public void user_is_already_on_Data_shop_home_page() {
        BaseDriver.getDriver();
    }

    @Then("^user should click login$")
    public void user_should_click_login() {
        homePage = new HomePage();
        homePage.clickLogin();

    }

    @Then("^login \"([^\"]*)\" page should successfully be loaded$")
    public void login_page_should_successfully_be_loaded(String arg1) {
        loginPage = new LoginPage();
        loginPage.isWelcomeSignAvailable(arg1);
    }

    @Then("^user must enters \"([^\"]*)\" and \"([^\"]*)\" and click login$")
    public void user_must_enters_and_and_click_login(String arg1, String arg2) {
        loginPage.enterCredentialsLogin(arg1, arg2);
    }

    @Then("^user should successfully login$")
    public void user_should_successfully_login() {
        loginPage.isLoginSuccessful(driver.getTitle());
    }

    @Then("^User should close the browser$")
    public void user_should_close_the_browser() {
        driver.close();
    }
}
