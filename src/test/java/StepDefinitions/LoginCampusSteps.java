package StepDefinitions;

import POM.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginCampusSteps {

    LoginPage loginPage;
    @Given("Admin User is on login page")
    public void adminUserIsOnLoginPage() {
        loginPage = new LoginPage();
        loginPage.validateUserOnLoginPage();
    }

    @When("Admin User enters valid admin credentials")
    public void adminUserEntersValidAdminCredentials() {
        loginPage = new LoginPage();
        loginPage.userEnterAdminCredentials();
    }

    @Then("Admin User should login successfully")
    public void adminUserShouldLoginSuccessfully() {
        loginPage = new LoginPage();
        loginPage.validateUserSuccessfullyLoggedIn();
    }

    @When("Admin User enters invalid username and valid password")
    public void adminUserEntersInvalidUsernameAndValidPassword() {
        loginPage = new LoginPage();
        loginPage.adminEnterInvalidUserNameValidPassword();
    }

    @Then("Admin User should not be able to login successfully")
    public void adminUserShouldNotBeAbleToLoginSuccessfully() {
        loginPage = new LoginPage();
        loginPage.validateUserSuccessfullyNotLoggedIn();
    }

    @When("Admin User enters valid username and invalid password")
    public void adminUserEntersValidUsernameAndInvalidPassword() {
        loginPage = new LoginPage();
        loginPage.adminEnterValidUserNameInvalidPassword();
    }

    @When("Admin User enters invalid username and invalid password")
    public void adminUserEntersInvalidUsernameAndInvalidPassword() {
        loginPage = new LoginPage();
        loginPage.adminEnterInvalidUserNameInvalidPassword();
    }
}
