package POM;

import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DialogContents extends BasePOM {

    public DialogContents() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'ADD')]//button")
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
    private WebElement shortNameInput;

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







    public void validateSearchFunction(){
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        Assert.assertTrue(searchButton.isDisplayed());
    }
    public void validateActivateAndDeactivateSwitchFunction(){
        wait.until(ExpectedConditions.visibilityOf(activateDeactivateSwitch));
        activateDeactivateSwitch.click();
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));

    }

    public void createEmployeePositions(String name, String shortName){

        waitUntilVisibleAndClickableAndThenClick(addButton);
        nameInput.sendKeys(name);
        shortNameInput.sendKeys(shortName);
        waitUntilVisibleAndClickableAndThenClick(saveButton);
    }

    public void validateSuccessfullyMessage() {

        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));
    }

    public void validateAlreadyExistsMessage(){

        wait.until(ExpectedConditions.visibilityOf(alreadyExist));
        Assert.assertTrue(alreadyExist.getText().contains("Already exists".toLowerCase()));
    }

    public void editEmployeePositions(String existName,String newName, String shortName){

        searchInput.sendKeys(existName);
        searchButton.click();
        waitUntilLoading();
        mouseAction(editButton);
        nameInput.clear();
        nameInput.sendKeys(newName);
        shortNameInput.clear();
        shortNameInput.sendKeys(shortName);
        waitUntilVisibleAndClickableAndThenClick(saveButton);
    }

    public void searchAndDelete(String name){

        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(name);
        searchButton.click();

        waitUntilLoading();
        mouseAction(trashButton);
        waitUntilVisibleAndClickableAndThenClick(deleteButton);

    }

    public void deleteNegativeTest(String name){
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(name);
        searchButton.click();
        waitUntilLoading();

    }

    public void validateNoDataMessage(){

        wait.until(ExpectedConditions.visibilityOf(thereIsNoDataDisplay));
        Assert.assertTrue(thereIsNoDataDisplay.isDisplayed());
        String expectedResult = "There is no data to display";
        Assert.assertEquals(thereIsNoDataDisplay.getText(),expectedResult);
    }

    public void createPositionCategories(String name){
        waitUntilLoading();
        addButton.click();
        //waitUntilVisibleAndClickableAndThenClick(addButton);
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(name);
        waitUntilVisibleAndClickableAndThenClick(saveButton);
    }

    public void editPositionCategories(String existName,String newName ){
        searchInput.sendKeys(existName);
        searchButton.click();
        waitUntilLoading();
        mouseAction(editButton);
        nameInput.clear();
        nameInput.sendKeys(newName);
        waitUntilVisibleAndClickableAndThenClick(saveButton);
    }













}
