package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PositionCategoriesSteps {

    NavigationBarContents navigationBarContents = new NavigationBarContents();
    DialogContents dialogContents = new DialogContents();
    @When("Navigate to Position Categories page")
    public void navigateToPositionCategoriesPage() {

        navigationBarContents.navigateToPositionsCategoriesPage();
    }

    @And("Admin User create Position Categories name as {string}")
    public void adminUserCreatePositionCategoriesNameAs(String name) {


        dialogContents.createPositionCategories(name);

    }
    @And("Admin User create again Position Categories name as {string}")
    public void adminUserCreateAgainPositionCategoriesNameAs(String name) {

        dialogContents.createPositionCategories(name);

    }

    @And("Admin User edit Position Categories existName as {string} to newName as {string}")
    public void adminUserEditPositionCategoriesNameAs(String existName,String newName) {

        dialogContents.editPositionCategories(existName,newName);

    }

    @And("Admin User delete Position Categories name as {string}")
    public void adminUserDeletePositionCategoriesNameAs(String name) {

        dialogContents.searchAndDelete(name);

    }

    @And("Admin User delete again Position Categories name as {string}")
    public void adminUserDeleteAgainPositionCategoriesNameAs(String name) {


        dialogContents.deleteNegativeTest(name);

    }

}
