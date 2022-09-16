package StepDefinitions;

import ApachePOI.Resources.ExcelReader;
import POM.BasePOM;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginCampusSteps {

    LoginPage loginPage;

    @Given("Admin User navigates to login page")
    public void adminUserNavigatesToLoginPage() {
        loginPage = new LoginPage();
        loginPage.validateUserOnLoginPage();
    }

    @When("Admin User enters valid credentials from given sheet name {string} and row number {int}")
    public void adminUserEntersValidCredentialsFromGivenSheetNameAndRowNumberRowNumber(String sheetName,Integer rowNumber) throws IOException, InvalidFormatException {

        loginPage = new LoginPage();

        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src/test/java/ApachePOI/Resources/NewExcelLoginData.xlsx",sheetName);

        String validUsername = testData.get(rowNumber).get("username");
        String validPassword = testData.get(rowNumber).get("password");

        loginPage.userEnterValidCredentials(validUsername,validPassword);

    }

    @And("Admin User clicks on login button")
    public void adminUserClicksOnLoginButton() {
        loginPage = new LoginPage();
        loginPage.AdminUserClickLoginButton();
    }

    @Then("Successfully message should be displayed")
    public void successfullyMessageShouldBeDisplayed() {

        loginPage = new LoginPage();
        loginPage.validateUserSuccessfullyLoggedIn();
    }

    @When("Admin User enters invalid username and valid password credentials from given sheet name {string} and row number {int}")
    public void adminUserEntersInvalidUsernameAndValidPasswordCredentialsFromGivenSheetNameAndRowNumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {

        loginPage = new LoginPage();

        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src/test/java/ApachePOI/Resources/NewExcelLoginData.xlsx",sheetName);

        String invalidUsername = testData.get(rowNumber).get("username");
        String validPassword = testData.get(rowNumber).get("password");

        loginPage.adminEnterInvalidUserNameValidPassword(invalidUsername,validPassword);

    }

    @When("Admin User enters valid username and invalid password credentials from given sheet name {string} and row number {int}")
    public void adminUserEntersValidUsernameAndInvalidPasswordCredentialsFromGivenSheetNameAndRowNumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {

        loginPage = new LoginPage();

        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src/test/java/ApachePOI/Resources/NewExcelLoginData.xlsx",sheetName);

        String validUsername = testData.get(rowNumber).get("username");
        String invalidPassword = testData.get(rowNumber).get("password");

        loginPage.adminEnterValidUserNameInvalidPassword(validUsername,invalidPassword);
    }

    @When("Admin User enters invalid username and invalid password credentials from given sheet name {string} and row number {int}")
    public void adminUserEntersInvalidUsernameAndInvalidPasswordCredentialsFromGivenSheetNameAndRowNumberRowNumber(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {

        loginPage = new LoginPage();

        ExcelReader reader = new ExcelReader();
        List<Map<String,String>> testData =
                reader.getData("src/test/java/ApachePOI/Resources/NewExcelLoginData.xlsx",sheetName);

        String invalidUsername = testData.get(rowNumber).get("username");
        String invalidPassword = testData.get(rowNumber).get("password");

        loginPage.adminEnterInvalidUserNameInvalidPassword(invalidUsername,invalidPassword);

    }

    @Then("Admin User should not be able to login successfully")
    public void adminUserShouldNotBeAbleToLoginSuccessfully() {

        loginPage = new LoginPage();
        loginPage.validateUserSuccessfullyNotLoggedIn();

    }
}
