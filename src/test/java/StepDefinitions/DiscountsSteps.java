package StepDefinitions;

import POM.DialogContents;
import io.cucumber.java.en.*;

public class DiscountsSteps {


    DialogContents dialogContents = new DialogContents();
/*
    @Then("Admin user should be able to edit a discount")
    public void admin_user_should_be_able_to_edit_a_discount() {
        dialogContents.editDiscount();
    }

    @And("Admin user should not be able to delete a discount")
    public void adminUserShouldNotBeAbleToDeleteADiscount() {
        dialogContents.thereIsNoDataAssertion();
    }

    @Then("Admin user should not be able to add a discount")
    public void admin_user_should_not_be_able_to_add_a_discount() {
        dialogContents.addDiscount();
    }

    @Then("Admin user should be able to add a discount")
    public void admin_user_should_be_able_to_add_a_discount() {
        dialogContents.addDiscount();
    }

    @Then("Admin user should be able to delete a discount")
    public void admin_user_should_be_able_to_delete_a_discount() {
        dialogContents.deleteDiscount();
    }*/

    @Given("Admin User navigates to discounts")
    public void admin_user_navigates_to_discounts() {
        dialogContents.navigateToDiscounts();
    }

    @Then("Search Functionality should be present")
    public void search_functionality_should_be_present() {
        dialogContents.searchFuncAssertion();
    }

    @Then("Already exists message should be displayed")
    public void already_exists_message_should_be_displayed() {
        dialogContents.alreadyExistsMessageAssertion();
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialogContents.successMessageAssertion();
    }

    @And("Admin user should be able to delete a discount named with {string}")
    public void adminUserShouldBeAbleToDeleteADiscountNamedWith(String description) {
        dialogContents.deleteDiscount(description);

    }

    @And("Admin user should be able to add a discount with {string},{string} and {string}")
    public void adminUserShouldBeAbleToAddADiscountWithAnd(String description, String integration, String priority) {
        dialogContents.addDiscount(description,integration,priority);
    }


    @And("Admin user should not be able to add a discount with {string},{string} and {string}")
    public void adminUserShouldNotBeAbleToAddADiscountWithAnd(String description, String integration, String priority) {
        dialogContents.addDiscount(description,integration,priority);

    }

    @And("Admin user should not be able to delete a discount named with {string}")
    public void adminUserShouldNotBeAbleToDeleteADiscountNamedWith(String description) {
        dialogContents.thereIsNoDataAssertion(description);


    }

    @And("Admin user should be able to edit a discount named with {string}")
    public void adminUserShouldBeAbleToEditADiscountNamedWith(String description) {
        dialogContents.editDiscount(description);
    }
}
