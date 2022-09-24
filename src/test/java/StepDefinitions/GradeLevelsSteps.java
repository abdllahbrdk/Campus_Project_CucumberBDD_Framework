package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.*;

public class GradeLevelsSteps {

    NavigationBarContents navigationBarContents;
    DialogContents dialogContents;

    @When("Admin User navigates to Grade Levels Bar")
    public void admin_user_navigates_to_grade_levels_bar() {

        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToGradeLevelsPage();
        navigationBarContents.validateGradeLevelsPresent();
    }

    @When("Admin User see the Grade Levels Under the Parameters")
    public void admin_user_see_the_grade_levels_under_the_parameters() {
      navigationBarContents = new NavigationBarContents();
      navigationBarContents.validateGradeLevelsPresent();
    }

    @When("Admin User can switch active on and off")
    public void admin_user_can_switch_active_on_and_off() {
        dialogContents = new DialogContents();
        dialogContents.switchActivateAndDeactivate();
    }

    @Then("Admin User add grade levels for students and employees name as {string} shortname as {string} and order as {string}")
    public void adminUserAddGradeLevelsForStudentsAndEmployeesNameAsShortnameAsAndOrderAs(String name, String shortName, String order) {
        dialogContents = new DialogContents();
        dialogContents.addGradeLevels(name, shortName, order);
    }

    @Then("Success message should be displayed")
    public void success_message_should_be_displayed() {
      dialogContents = new DialogContents();
      dialogContents.successMessageValidation();
    }


    @When("Admin user add grade levels with same data name as {string} shortname as {string} and order as {string}")
    public void adminUserAddGradeLevelsWithSameDataNameAsShortnameAsAndOrderAs(String name, String shortName, String order) {
        dialogContents = new DialogContents();
        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToGradeLevelsPage();
        navigationBarContents.validateGradeLevelsPresent();
        dialogContents.switchActivateAndDeactivate();
        dialogContents.addGradeLevels(name, shortName, order);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dialogContents = new DialogContents();
        dialogContents.validateAlreadyExistMessage();
    }

    @When("Admin user edit grade levels name as {string} shortname as {string} and order as {string}")
    public void adminUserEditGradeLevelsNameAsShortnameAsAndOrderAs(String name, String shortName, String order) {
     dialogContents = new DialogContents();
     navigationBarContents = new NavigationBarContents();
     navigationBarContents.navigateToGradeLevelsPage();
     navigationBarContents.validateGradeLevelsPresent();
     dialogContents.switchActivateAndDeactivate();
     dialogContents.editGradeLevels(name, shortName, order);
    }

    @When("Admin user delete grade levels")
    public void adminUserDeleteGradeLevels() {
        dialogContents = new DialogContents();
        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToGradeLevelsPage();
        dialogContents.deleteGradeLevels();
    }

}
