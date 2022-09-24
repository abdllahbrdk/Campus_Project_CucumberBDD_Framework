package POM;

import Utils.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DialogContents extends BasePOM {

    public DialogContents() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-save-button//button")
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

    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.INTEGRATION_CODE']>input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;

    @FindBy(xpath = "//div[text()=' There is no data to display ']")
    private WebElement thereIsNoDataDisplay;

    @FindBy(xpath = "// mat-slide-toggle[contains(@id,'mat-slide-toggle')]")
    private WebElement activateDeactivateSwitch;

    @FindBy(xpath = "//ms-masked-text-field[@formcontrolname='iban']//input")
    private WebElement ibanInput;

    @FindBy(xpath = "//mat-select[@formcontrolname='currency']")
    private WebElement currencyInput;

    @FindBy(xpath = "//mat-option[@role='option']//span[text()=' USD ']")
    private WebElement currency;



    public void validateSearchFunction() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        Assert.assertTrue(searchButton.isDisplayed());

    }

    public void adminUserAddBankAccounts(String name, String iban, String intCode) {
        mouseAction(addButton);
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(name);
        ibanInput.sendKeys(iban);
        waitUntilVisibleAndClickableAndThenClick(currencyInput);
        mouseAction(currency);
        integrationCode.sendKeys(intCode);
        waitUntilVisibleAndClickableAndThenClick(saveButton);
}

    public void validateAlreadyExistMessage() {
        wait.until(ExpectedConditions.visibilityOf(alreadyExist));
        Assert.assertTrue(alreadyExist.isDisplayed());
        Assert.assertTrue(alreadyExist.getText().contains("exist".toLowerCase()));

    }

    public void validateSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));

    }

    public void adminUserEditBankAccounts(String name, String newName) {
        searchInput.sendKeys(name);
        waitUntilVisibleAndClickableAndThenClick(searchButton);
        mouseAction(editButton);
        nameInput.clear();
        nameInput.sendKeys(newName);
        waitUntilVisibleAndClickableAndThenClick(saveButton);

    }

    public void adminUserDeleteBankAccounts(String newName) {

        searchInput.sendKeys(newName);
        searchButton.click();
        mouseAction(trashButton);
        waitUntilVisibleAndClickableAndThenClick(deleteButton);

    }

    public void deleteNegativeTest(String newName) {
        searchInput.sendKeys(newName);
        searchButton.click();
    }

    public void validateNoDataMessage() {
        wait.until(ExpectedConditions.visibilityOf(thereIsNoDataDisplay));
        Assert.assertTrue(thereIsNoDataDisplay.isDisplayed());
        Assert.assertTrue(thereIsNoDataDisplay.getText().contains("display".toLowerCase()));

    }

}
