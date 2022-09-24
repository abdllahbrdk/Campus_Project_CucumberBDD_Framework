package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AttestationsSteps {

    NavigationBarContents navigationBarContents;
    DialogContents dialogContents;


    @Then("Admin User Navigates to Attestations Bar")
    public void adminUserNavigatesToAttestationsBar() {
       navigationBarContents = new NavigationBarContents();
       navigationBarContents.navigateToAttestationsPage();
       navigationBarContents.validateAttestationPresent();
    }

    @When("Admin User add Attestation as {string} when clicks on add button")
    public void adminUserAddAttestationAsWhenClicksOnAddButton(String name) {
       dialogContents = new DialogContents();
       dialogContents.addAttestation(name);
    }

    @When("Admin User add same Attestation as {string}")
    public void adminUserAddSameAttestationAs(String name) {
        dialogContents = new DialogContents();
        dialogContents.addFields(name);
    }

    @When("Admin User Edit {string} Attestation  as {string}")
    public void adminUserEditAttestationAs(String name, String updatedName) {
        dialogContents = new DialogContents();
        dialogContents.editAttestation(name, updatedName);
    }

    @When("Admin User Delete Attestation  as {string}")
    public void adminUserDeleteAttestationAs(String name) {
        dialogContents = new DialogContents();
        dialogContents.deleteAttestation(name);
    }

    @When("Admin User Delete Attestation  as {string} again")
    public void adminUserDeleteAttestationAsAgain(String name) {
        dialogContents = new DialogContents();
        dialogContents.deleteAttestation(name);
    }


}
