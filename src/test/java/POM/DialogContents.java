package POM;

import Utils.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.xml.xpath.XPath;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
    private WebElement shortNameInput;

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

    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.INTEGRATION_CODE']>input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityCode;

    @FindBy(xpath = "//div[text()=' There is no data to display ']")
    private WebElement thereIsNoDataDisplay;

    @FindBy(xpath = "// mat-slide-toggle[contains(@id,'mat-slide-toggle')]")
    private WebElement activateDeactivateSwitch;
    
    @FindBy(xpath = "//div[contains(text(),'already Department')]")
    private WebElement alreadyDepartmentMessage;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='order']//input")
    private WebElement orderInput;

    @FindBy(css = "div[class='mat-form-field-infix ng-tns-c74-103']>mat-select")
    private WebElement nextGradeDropDown;
    
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

    @FindBy(xpath = "//ms-masked-text-field[@formcontrolname='iban']//input")
    private WebElement ibanInput;

    @FindBy(xpath = "//mat-select[@formcontrolname='currency']")
    private WebElement currencyInput;

    @FindBy(xpath = "//mat-option[@role='option']//span[text()=' USD ']")
    private WebElement currency;
       @FindBys({
            @FindBy(xpath = "//mat-option[contains(@id,'mat-option')]//span")
    })
    private  List<WebElement> stageDropDownList;

    @FindBy(xpath = "//ms-dialog-content//mat-select")
    private WebElement stageButton;

    @FindBy(xpath = "//mat-slide-toggle[@formcontrolname='active']")
    private WebElement activateDeactivateSwitchSchoolLocation;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='capacity']//input")
    private WebElement capacityInput;

    public void addSubjectCategories(String name, String code){
        waitUntilLoading();
        Assert.assertTrue(searchButton.isDisplayed());
        waitUntilVisibleAndClickableAndThenClick(addButton);
        nameInput.sendKeys(name);
        codeInput.sendKeys(code);
        saveButton.click();
    }

    public void editSubjectCategories(String name,String code) {
        waitUntilLoading();
        editButton.click();
        nameInput.clear();
        nameInput.sendKeys(name);
        codeInput.clear();
        codeInput.sendKeys(code);
        activateDeactivateSwitchSchoolLocation.click();
        saveButton.click();
    }

    public void deleteSubjectCategories(){
        waitUntilLoading();
        Assert.assertTrue(searchButton.isDisplayed());
        waitUntilVisibleAndClickableAndThenClick(trashButton);
        waitUntilVisibleAndClickableAndThenClick(deleteButton);
    }

    public void addSchoolLocation(String name,String shortName,String capacity) {
        waitUntilLoading();
        Assert.assertTrue(addButton.isDisplayed());
        waitUntilVisibleAndClickableAndThenClick(addButton);
        nameInput.sendKeys(name);
        shortNameInput.sendKeys(shortName);
        capacityInput.sendKeys(capacity);
        saveButton.click();
    }

    public void editSchoolLocation(String name,String shortName){
        waitUntilVisibleAndClickableAndThenClick(editButton);
        nameInput.clear();
        nameInput.sendKeys(name);
        shortNameInput.clear();
        shortNameInput.sendKeys(shortName);
        activateDeactivateSwitchSchoolLocation.click();
        saveButton.click();
    }

    public void deleteSchoolLocation() {
        waitUntilVisibleAndClickableAndThenClick(trashButton);
        waitUntilVisibleAndClickableAndThenClick(deleteButton);
    }

    public void switchActivateAndDeactivate(){
        waitUntilVisibleAndClickableAndThenClick(activateDeactivateSwitch);
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("successfully".toLowerCase()));
    }

    public void addGradeLevels(String name,String shortName1,String order){
        waitUntilVisibleAndClickableAndThenClick(addButton);
        wait.until(ExpectedConditions.visibilityOf(nameInput)).sendKeys(name);
        shortNameInput.sendKeys(shortName1);
        orderInput.sendKeys(order);
        saveButton.click();
    }

    public void successMessageValidation(){

        wait.until(ExpectedConditions.visibilityOf(successMessage));
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(successMessage.getText().contains("success".toLowerCase()));
    }

    public void adminUserAddDepartments(String username, String code) {

        waitUntilLoading();
        addButton.click();
        wait.until(ExpectedConditions.visibilityOf(nameInput));
        nameInput.sendKeys(username);
        codeInput.sendKeys(code);
        waitUntilVisibleAndClickableAndThenClick(saveButton);

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
    

   public void editGradeLevels(String name,String shortName2,String order){
        waitUntilVisibleAndClickableAndThenClick(editButton);
        nameInput.clear();
        nameInput.sendKeys(name);
        shortNameInput.clear();
        shortNameInput.sendKeys(shortName2);
        orderInput.clear();
        orderInput.sendKeys(order);
        waitUntilVisibleAndClickableAndThenClick(saveButton);
   }

   public void deleteGradeLevels(){
        waitUntilVisibleAndClickableAndThenClick(trashButton);
        waitUntilVisibleAndClickableAndThenClick(deleteButton);
   }

   public void validateSearchPresent(){
        Assert.assertTrue(searchButton.isDisplayed());
   }

   public void addFields(String name){
       wait.until(ExpectedConditions.visibilityOf(searchButton));
       validateSearchPresent();
       addButton.click();
       nameInput.sendKeys(name);
       waitUntilVisibleAndClickableAndThenClick(saveButton);
   }

   public void editFields(String name,String updatedName){
        validateSearchPresent();
        searchInput.sendKeys(name);
        searchButton.click();
       waitUntilVisibleAndClickableAndThenClick(editButton);
       nameInput.clear();
       nameInput.sendKeys(updatedName);
       waitUntilVisibleAndClickableAndThenClick(saveButton);
   }

   public void deleteFields(String name){
        validateSearchPresent();
        searchInput.sendKeys(name);
        searchButton.click();
       waitUntilVisibleAndClickableAndThenClick(trashButton);
       waitUntilVisibleAndClickableAndThenClick(deleteButton);
   }

   public void deleteFieldsNegative(String name){
       validateSearchPresent();
       searchInput.sendKeys(name);
       searchButton.click();
       waitUntilVisibleAndClickableAndThenClick(trashButton);
       waitUntilVisibleAndClickableAndThenClick(deleteButton);
   }

   public void addAttestation(String name){
       waitUntilLoading();
       addButton.click();
       nameInput.sendKeys(name);
       waitUntilVisibleAndClickableAndThenClick(saveButton);
   }

   public void editAttestation(String name,String updatedName){
         validateSearchPresent();
         searchInput.sendKeys(name);
         searchButton.click();
         waitUntilVisibleAndClickableAndThenClick(editButton);
         nameInput.clear();
         nameInput.sendKeys(updatedName);
         waitUntilVisibleAndClickableAndThenClick(saveButton);
   }

   public void deleteAttestation(String name){
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(name);
        waitUntilVisibleAndClickableAndThenClick(searchButton);
        waitUntilLoading();
        wait.until(ExpectedConditions.elementToBeClickable(trashButton)).click();
        waitUntilVisibleAndClickableAndThenClick(deleteButton);
   }

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

    public void adminUserAddNationality(String name) {

        waitUntilVisibleAndClickableAndThenClick(addButton);
        nameInput.sendKeys(name);
        waitUntilVisibleAndClickableAndThenClick(saveButton);

    }

    public void adminUserEditNationality(String name, String newName) {

        searchInput.sendKeys(name);
        waitUntilVisibleAndClickableAndThenClick(searchButton);
        mouseAction(editButton);
        nameInput.clear();
        nameInput.sendKeys(newName);
        waitUntilVisibleAndClickableAndThenClick(saveButton);

    }

    public void adminUserDeleteNationality(String newName) {

        searchInput.sendKeys(newName);
        searchButton.click();
        mouseAction(trashButton);
        waitUntilVisibleAndClickableAndThenClick(deleteButton);

    }

    public void adminUserDeleteAgainNationality(String newName) {

        searchInput.sendKeys(newName);
        searchButton.click();

    }



}
