package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.*;


public class SchoolLocationsSteps {

    NavigationBarContents navigationBarContents;
    DialogContents dialogContents;

    @Then("Admin User navigates to School Locations under School Setup")
    public void admin_user_navigates_to_school_locations_under_school_setup() {
        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToSchoolLocationsPage();
    }
    @Given("Admin User add School Location name as {string} and short name {string} and Capacity {string}")
    public void admin_user_add_school_location_name_as_and_short_name_and_capacity(String name, String shortName, String capacity) throws InterruptedException {
        dialogContents = new DialogContents();
        dialogContents.addSchoolLocation(name,shortName,capacity);
    }

    @Given("Admin User edit School Location name as {string} and short name as {string} and deactive the switch")
    public void admin_user_edit_school_location_name_as_and_short_name_as_and_deactive_the_switch(String name, String shortName) {
        dialogContents = new DialogContents();
        dialogContents.editSchoolLocation(name,shortName);
    }

    @Given("Admin User delete School Location")
    public void admin_user_delete_school_location() {
        dialogContents = new DialogContents();
        dialogContents.deleteSchoolLocation();
    }

}
