package POM;

import Utils.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
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

    @FindBys({
            @FindBy(xpath = "//mat-option[contains(@id,'mat-option')]//span")
    })
    private  List<WebElement> stageDropDownList;

    @FindBy(xpath = "//ms-dialog-content//mat-select")
    private WebElement stageButton;


    public void addDocumentTypes(String name, String stage){

        addButton.click();
        nameInput.sendKeys(name);
        stageButton.click();

        List<WebElement> stageList = stageDropDownList;
        for (WebElement e : stageList){
            if (e.getText().equalsIgnoreCase(stage)){
                e.click();
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ESCAPE);
                    robot.keyRelease(KeyEvent.VK_ESCAPE);
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
        waitUntilClickable(saveButton);
        saveButton.click();

    }

    public void editDocumentTypes(String oldDocumentName, String newDocumentName, String stage) {
        searchInput.sendKeys(oldDocumentName);
        searchButton.click();
        waitUntilClickable(editButton);
        editButton.click();
        nameInput.clear();
        nameInput.sendKeys(newDocumentName);
        stageButton.click();
        List<WebElement> stageList = stageDropDownList;
        for (WebElement e : stageList){
            if (e.getText().equalsIgnoreCase(stage)){
                e.click();
                try {
                    Robot robot = new Robot();
                    robot.keyPress(KeyEvent.VK_ESCAPE);
                    robot.keyRelease(KeyEvent.VK_ESCAPE);
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
        waitUntilClickable(saveButton);
        saveButton.click();

    }

    public void deleteCountryType(String documentTypeNameToDelete){
        searchInput.sendKeys(documentTypeNameToDelete);
        searchButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
        waitUntilVisibleAndClickableAndThenClick(trashButton);
        waitUntilVisibleAndClickableAndThenClick(deleteButton);


    }
    public void validateUserSuccessfullyMessage(){
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
    }

}
