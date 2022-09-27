package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NationalitiesSteps {

    NavigationBarContents navigationBarContents;

    DialogContents dialogContents;



    @Then("Admin User navigates to Nationalities page")
    public void adminUserNavigatesToNationalitiesPage() {
        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToNationalitiesPage();

    }

    @And("Admin User should have search function in Nationalities page")
    public void adminUserShouldHaveSearchFunctionInNationalitiesPage() {
        dialogContents = new DialogContents();
        dialogContents.validateSearchFunction();

    }

    @When("Admin User add Nationality name as {string}")
    public void adminUserAddNationalityNameAs(String name) {
        dialogContents = new DialogContents();
        dialogContents.adminUserAddNationality(name);

    }

    @When("Admin User add again Nationality name as {string}")
    public void adminUserAddAgainNationalityNameAs(String name) {
        dialogContents = new DialogContents();
        dialogContents.adminUserAddNationality(name);

    }

    @When("Admin User edit Nationality name {string} to newName as {string}")
    public void adminUserEditNationalityNameToNewNameAs(String name, String newName) {
        dialogContents = new DialogContents();
        dialogContents.adminUserEditNationality(name, newName);

    }

    @When("Admin User delete Nationality newName as {string}")
    public void adminUserDeleteNationalityNewNameAs(String newName) {
        dialogContents = new DialogContents();
        dialogContents.adminUserDeleteNationality(newName);

    }

    @When("Admin User delete again Nationality newName as {string}")
    public void adminUserDeleteAgainNationalityNewNameAs(String newName) {
        dialogContents = new DialogContents();
        dialogContents.adminUserDeleteAgainNationality(newName);

    }

}
