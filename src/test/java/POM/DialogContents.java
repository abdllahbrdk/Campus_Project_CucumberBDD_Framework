package POM;

import Utils.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DialogContents extends BasePOM {

    public DialogContents() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath="//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath="//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath="//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(xpath = "(//div[contains(@class,'mat-form-field-infix ng-tns-c74')]//input)[1]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-edit-button//button")
    private WebElement editButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement trashButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;

    @FindBy(xpath = "//div[text()=' There is no data to display ']")
    private WebElement thereIsNoDataDisplay;

    @FindBy(xpath = "//mat-slide-toggle[contains(@id,'mat-slide-toggle')]")
    private WebElement activateDeactivateSwitch;

    @FindBy(xpath = "//div[contains(text(),'already Department')]")
    private WebElement alreadyDepartmentMessage;


    public void adminUserAddDepartments(String username, String code) {

        waitUntilLoading();
        addButton.click();
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(username);
        codeInput.sendKeys(code);
        waitUntilVisibleAndClickableAndThenClick(saveButton);

    }

    public void validateSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));
    }


    public void adminUserEditDepartment(String newName) {

        waitUntilLoading();
        mouseAction(editButton);
        nameInput.clear();
        nameInput.sendKeys(newName);
        waitUntilVisibleAndClickableAndThenClick(saveButton);
    }

    public void adminUserDeleteDepartments() {

       waitUntilLoading();
        wait.until(ExpectedConditions.visibilityOf(trashButton));

       mouseAction(trashButton);
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();

    }
    public void deleteNegativeDepartments() {

        waitUntilLoading();
    }

    public void departmentAlreadyMessage() {
        wait.until(ExpectedConditions.visibilityOf(alreadyDepartmentMessage));
        Assert.assertTrue(alreadyDepartmentMessage.isDisplayed());
        Assert.assertTrue(alreadyDepartmentMessage.getText().contains("already".toLowerCase()));
    }
    public void validateNoDataDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(thereIsNoDataDisplay));
        Assert.assertTrue(thereIsNoDataDisplay.isDisplayed());
        String expectedResult = "There is no data to display";
        Assert.assertEquals(thereIsNoDataDisplay.getText(),expectedResult);
    }








}
