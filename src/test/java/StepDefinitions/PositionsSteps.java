package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class PositionsSteps {

    NavigationBarContents navigationBarContents = new NavigationBarContents();

    DialogContents dialogContents = new DialogContents();

    @When("Navigate to Positions page")
    public void navigateToPositionsPage() {

        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToPositionsPage();
    }
    @Then("Admin User should have search function for this page")
    public void adminUserShouldHaveSearchFunctionForThisPage() {


        dialogContents.validateSearchFunction();
    }

    @And("Admin User should have activate and deactivate function")
    public void adminUserShouldHaveActivateAndDeactivateFunction() {

        dialogContents.validateActivateAndDeactivateSwitchFunction();
    }
    @And("Admin User create Employee Positions name as {string} and short name as {string}")
    public void adminUserCreateEmployeePositionsNameAsAndShortNameAs(String name, String shortName) {

        dialogContents.createEmployeePositions(name,shortName);
    }


    @And("Admin User create again Employee Positions name as {string} and short name as {string}")
    public void adminUserCreateAgainEmployeePositionsNameAsAndShortNameAs(String name, String shortName) {

        dialogContents.createEmployeePositions(name,shortName);
    }


    @And("Admin User edit Employee Positions existName as {string} to newName as {string} and short name as {string}")
    public void adminUserEditEmployeePositionsNameAsAndShortNameAs(String existName,String newName, String shortName) {

        dialogContents.editEmployeePositions(existName,newName,shortName);
    }

    @And("Admin User delete Employee Positions name as {string}")
    public void adminUserDeleteEmployeePositionsNameAs(String name) {

        dialogContents.searchAndDelete(name);
    }

    @And("Admin User delete again Employee Positions name as {string}")
    public void adminUserDeleteAgainEmployeePositionsNameAs(String name) {

        dialogContents.deleteNegativeTest(name);
    }




}
