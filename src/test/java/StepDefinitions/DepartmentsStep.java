package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DepartmentsStep {
    NavigationBarContents navigationBarContents;
    DialogContents dialogContents;

    @Then("Admin User navigates to School Setup under Departments")
    public void adminUserNavigatesToSchoolSetupUnderDepartments() {

        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToDepartmentsPage();
    }

    @When("Admin User add School Department as {string} and code {string}")
    public void adminUserAddSchoolDepartmentAsAndCode(String username, String code) {
        dialogContents = new DialogContents();
        dialogContents.adminUserAddDepartments(username, code);
    }

    @Then("Already Department message should be displayed")
    public void alreadyDepartmentMessageShouldBeDisplayed() {
        dialogContents = new DialogContents();
        dialogContents.departmentAlreadyMessage();
    }

    @When("Admin User edit School Department newName {string}")
    public void adminUserEditSchoolDepartmentNewName(String newName) {
    dialogContents = new DialogContents();
    dialogContents.adminUserEditDepartment(newName);

    }

    @When("Admin User Delete Department name")
    public void adminUserDeleteDepartmentName() {
        dialogContents = new DialogContents();

        dialogContents.adminUserDeleteDepartments();

    }

    @When("Admin User Delete again Department name")
    public void adminUserDeleteAgainDepartmentName() {
        dialogContents = new DialogContents();
        dialogContents.deleteNegativeDepartments();

    }




}
