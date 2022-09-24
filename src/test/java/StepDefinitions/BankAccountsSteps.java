package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankAccountsSteps {

    NavigationBarContents navigationBarContents;
    DialogContents dialogContents;


    @Then("Admin User navigates to Bank Accounts page")
    public void adminUserNavigatesToBankAccountsPage() {
        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToBankAccountsPage();

    }

   @And("Admin User should have search function in Bank Accounts page")
    public void adminUserShouldHaveSearchFunctionInBankAccountsPage() {
        dialogContents = new DialogContents();
        dialogContents.validateSearchFunction();

    }

    @When("Admin User add Bank Accounts name as {string} and iban {string} and intCode {string}")
    public void adminUserAddBankAccountsNameAsAndIbanAndIntCode(String name, String iban, String intCode) {
        dialogContents = new DialogContents();
        dialogContents.adminUserAddBankAccounts(name, iban, intCode);

    }


    @When("Admin User add Bank Accounts same name as {string} and iban {string} and intCode {string}")
    public void adminUserAddBankAccountsSameNameAsAndIbanAndIntCode(String name, String iban, String intCode) {
        dialogContents = new DialogContents();
        dialogContents.adminUserAddBankAccounts(name, iban, intCode);

    }

    @Then("Already exists message should be displayed")
    public void alreadyExistsMessageShouldBeDisplayed() {
        dialogContents = new DialogContents();
        dialogContents.validateAlreadyExistMessage();

    }

    @When("Admin User edit Bank Accounts name {string} to newName {string}")
    public void adminUserEditBankAccountsNameTo(String name, String newName) {
        dialogContents = new DialogContents();
        dialogContents.adminUserEditBankAccounts(name, newName);

    }

    @When("Admin User delete Bank Accounts newName as {string}")
    public void adminUserDeleteBankAccountsNewNameAs(String newName) {
        dialogContents = new DialogContents();
        dialogContents.adminUserDeleteBankAccounts(newName);

    }

    @When("Admin User delete again Bank Accounts name as {string}")
    public void adminUserDeleteAgainBankAccountsNameAs(String newName) {
        dialogContents = new DialogContents();
        dialogContents.deleteNegativeTest(newName);

    }

    @Then("There is no data to display message should be displayed")
    public void thereIsNoDataToDisplayMessageShouldBeDisplayed() {
        dialogContents = new DialogContents();
        dialogContents.validateNoDataMessage();

    }


    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dialogContents = new DialogContents();
        dialogContents.validateSuccessMessage();

    }

}
