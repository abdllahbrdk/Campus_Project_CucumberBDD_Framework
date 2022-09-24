package POM;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

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

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupButton;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parametersButton;

    @FindBy(xpath = "//span[text()='Discounts']")
    private WebElement discountsButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement addIntegrationCode;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='description']//input")
    private WebElement addDescription;

    @FindBy(xpath = "//ms-text-field[contains(@placeholder,'TITLE.DESCRIPTION')]//input")
    private WebElement searchDescription;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement addPriorityCode;

    @FindBy(xpath = "//ms-search-button/div/button/span[1]/mat-spinner")
    private WebElement searchLoading;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement firstDeleteButton;

    public void navigateToDiscounts() {
        waitUntilVisibleAndClickableAndThenClick(setupButton);
        waitUntilVisibleAndClickableAndThenClick(parametersButton);
        waitUntilVisibleAndClickableAndThenClick(discountsButton);
    }

    public void searchFuncAssertion() {
        waitUntilVisibleAndClickableAndThenClick(searchButton);
        Assert.assertTrue(searchButton.isDisplayed());
    }

    public void addDiscount(String description,String integration,String priority) {
        waitUntilVisibleAndClickableAndThenClick(addButton);
        waitUntilVisibleAndClickableAndThenClick(addDescription);
        addDescription.sendKeys(description);
        waitUntilVisibleAndClickableAndThenClick(addIntegrationCode);
        addIntegrationCode.sendKeys(integration);
        waitUntilVisibleAndClickableAndThenClick(addPriorityCode);
        addPriorityCode.sendKeys(priority);
        waitUntilVisibleAndClickableAndThenClick(saveButton);

    }

    public void successMessageAssertion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
        //closeDialog.click();
    }

    public void alreadyExistsMessageAssertion() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(alreadyExist));
        Assert.assertTrue(alreadyExist.isDisplayed());
        closeDialog.click();

    }

    public void editDiscount(String description) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitUntilVisibleAndClickableAndThenClick(searchDescription);
        searchDescription.clear();
        searchDescription.sendKeys(description);
        waitUntilVisibleAndClickableAndThenClick(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//ms-search-button/div/button/span[1]/mat-spinner"), 0));
        waitUntilVisibleAndClickableAndThenClick(editButton);
        waitUntilVisibleAndClickableAndThenClick(saveButton);
    }

    public void deleteDiscount(String description) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitUntilVisibleAndClickableAndThenClick(searchDescription);
        searchDescription.clear();
        searchDescription.sendKeys(description);
        waitUntilVisibleAndClickableAndThenClick(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//ms-search-button/div/button/span[1]/mat-spinner"), 0));
        waitUntilVisibleAndClickableAndThenClick(firstDeleteButton);
        waitUntilVisibleAndClickableAndThenClick(deleteButton);
    }
    public void thereIsNoDataAssertion(String description){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitUntilVisibleAndClickableAndThenClick(searchDescription);
        searchDescription.clear();
        searchDescription.sendKeys(description);
        waitUntilVisibleAndClickableAndThenClick(searchButton);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//ms-search-button/div/button/span[1]/mat-spinner"), 0));
        wait.until(ExpectedConditions.visibilityOf(thereIsNoDataDisplay));
        Assert.assertTrue(thereIsNoDataDisplay.isDisplayed());

            }



}
