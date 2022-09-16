package StepDefinitions;

import ApachePOI.Resources.ExcelReader;
import POM.BasePOM;
import POM.LoginPage;
import io.cucumber.datatable.DataTable;
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

    @When("Admin User enters valid credentials from excel sheet name {string} and row number {string}")
    public void adminUserEntersValidCredentialsFromExcelSheetNameAndRowNumber(String sheetName, String rowNumber) {


        loginPage = new LoginPage();

        List<String> testData = ExcelReader.loginCredentials(sheetName, Integer.parseInt(rowNumber));

        loginPage.userEnterValidCredentials(testData.get(0), testData.get(1));


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

    @When("Admin User enters invalid credentials from excel {string} and {int}")
    public void adminUserEntersInvalidCredentialsFromExcelSheetNameAndRowNumber(String sheetName, Integer rowNumber) {

        loginPage = new LoginPage();

        List<String> testData = ExcelReader.loginCredentials(sheetName, rowNumber);

        loginPage.adminEnterInvalidCredentials(testData.get(0), testData.get(1));

    }


    @Then("Admin User should not be able to login successfully")
    public void adminUserShouldNotBeAbleToLoginSuccessfully() {

        loginPage = new LoginPage();
        loginPage.validateUserSuccessfullyNotLoggedIn();

    }




}
