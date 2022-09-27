package StepDefinitions;

import POM.DialogContents;
import POM.NavigationBarContents;
import io.cucumber.java.en.*;


public class SubjectCategories {

    NavigationBarContents navigationBarContents;
    DialogContents dialogContents;

    @Then("Admin User navigates to Subject Categories under Education Setup")
    public void admin_user_navigates_to_subject_categories_under_education_setup() {
        navigationBarContents = new NavigationBarContents();
        navigationBarContents.navigateToSubjectCategoriesUnderEducation();
    }

    @Given("Admin User add Subject Category name as {string} and code as {string}")
    public void admin_user_add_subject_category_name_as_and_code_as(String name, String code) {
        dialogContents = new DialogContents();
        dialogContents.addSubjectCategories(name,code);
    }

    @Given("Admin User edit Subject Category name as {string} and short name as {string} and switch active button")
    public void admin_user_edit_subject_category_name_as_and_short_name_as_and_switch_active_button(String name, String code) {
        dialogContents = new DialogContents();
        dialogContents.editSubjectCategories(name,code);
    }

    @Given("Admin User Delete Subject Category")
    public void admin_user_delete_subject_category() {
        dialogContents = new DialogContents();
        dialogContents.deleteSubjectCategories();
    }

}
