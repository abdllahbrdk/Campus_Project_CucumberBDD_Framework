package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.*;

public class FieldsSteps {


    NavigationBarContents navigationBarContents;
    DialogContents dialogContents;


    @Given("Admin User Navigates to Fields Bar")
    public void admin_user_navigates_to_fields_bar() {
     navigationBarContents = new NavigationBarContents();
     dialogContents = new DialogContents();
     navigationBarContents.navigateToFieldsPage();
    }

    @When("Admin User add fields as {string} when clicks on add button")
    public void adminUserAddFieldsAsWhenClicksOnAddButton(String name) {
        dialogContents = new DialogContents();
        dialogContents.addFields(name);
    }

    @When("Admin User add same fields as {string}")
    public void adminUserAddSameFieldsAs(String name) {
        navigationBarContents = new NavigationBarContents();
        dialogContents = new DialogContents();
        dialogContents.addFields(name);

    }

    @When("Admin User Edit {string}Fields as {string}")
    public void adminUserEditFieldsAs(String name, String updatedName) {
        navigationBarContents = new NavigationBarContents();
        dialogContents = new DialogContents();
        dialogContents.editFields(name,updatedName);
    }

    @When("Admin User Delete Fields as {string}")
    public void adminUserDeleteFieldsAs(String name) {
        dialogContents = new DialogContents();
        navigationBarContents = new NavigationBarContents();
        navigationBarContents.validateFieldsPresent();
        dialogContents.deleteFields(name);
    }

    @When("Admin User Delete Fields as {string} again")
    public void adminUserDeleteFieldsAsAgain(String name) {
        dialogContents = new DialogContents();
        navigationBarContents = new NavigationBarContents();
        navigationBarContents.validateFieldsPresent();
        dialogContents.deleteFieldsNegative(name);

    }
    @Then("There is no Data Display message should be displayed")
    public void thereIsNoDataDisplayMessageShouldBeDisplayed() {
        dialogContents = new DialogContents();
        dialogContents.validateNoDataMessage();
    }


}
