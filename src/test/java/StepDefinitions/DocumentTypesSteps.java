package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocumentTypesSteps {

    NavigationBarContents navigationBarContents;
    DialogContents dialogContents;
    @When("Admin User Add Document Type with a Name as {string} and Select Stage {string}")
    public void adminUserAddDocumentTypeWithANameAsAndSelectStage(String name, String stage) {
        navigationBarContents = new NavigationBarContents();
        dialogContents = new DialogContents();

        navigationBarContents.navigateToDocumentTypesPage();

        dialogContents.addDocumentTypes(name,stage);


    }

    @When("Admin User Edit Document Type {string} to update {string} and Select Stage {string}")
    public void adminUserEditDocumentTypeAndSelectStage(String oldName, String updatedName, String stage) {
        navigationBarContents = new NavigationBarContents();
        dialogContents = new DialogContents();
        navigationBarContents.navigateToDocumentTypesPage();
        dialogContents.editDocumentTypes(oldName, updatedName, stage);
    }

    @When("Admin User Click Delete Document Type {string}")
    public void adminUserClickDeleteDocumentType(String documentTypeNameToDelete) {
        navigationBarContents = new NavigationBarContents();
        dialogContents = new DialogContents();
        navigationBarContents.navigateToDocumentTypesPage();
        dialogContents.deleteCountryType(documentTypeNameToDelete);
    }

    @Then("Successfully message should be displayed deneme")
    public void successfullyMessageShouldBeDisplayed() {

        dialogContents = new DialogContents();
        dialogContents.validateUserSuccessfullyMessage();


    }
}
