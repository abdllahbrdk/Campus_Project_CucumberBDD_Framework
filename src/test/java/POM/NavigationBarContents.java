package POM;

import Utils.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class NavigationBarContents extends BasePOM {

    public NavigationBarContents() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath="(//span[text()='Setup'])[1]")
    private WebElement setupButton;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parametersButton;

    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResourcesButton;

    @FindBy(xpath = "(//span[text()='Setup'])[3]")
    private WebElement setupBtnThree;

    @FindBy(xpath = "//span[text()='Positions']")
    private WebElement positionsButton;

    @FindBy(xpath = "//span[text()=' Positions ']")
    private WebElement validatePositions;

    @FindBy(xpath = "//div[@class='children ng-tns-c249-18 ng-trigger ng-trigger-slideInOut ng-star-inserted']//span[text()='Position Categories']")
    private WebElement positionsCategoriesBtn;

    @FindBy(xpath = "//div[@class='ng-star-inserted']//span")
    private WebElement validatePositionsCategories;

    @FindBy(xpath = "//span[text()='School Setup']")
    private WebElement schoolSetupBtn;

    @FindBy(xpath = "//span[text()='Locations']")
    private WebElement locationsButton;

    @FindBy(xpath = "//a[@class='nav-link ng-star-inserted active accent']")
    private WebElement nationalityButton;

    @FindBy(xpath = "//span[text()=' Nationalities ']")
    private WebElement validateNationalitiesPage;


    public void navigateToPositionsPage(){

      humanResourcesButton.click();
      setupBtnThree.click();
      positionsButton.click();
      wait.until(ExpectedConditions.visibilityOf(validatePositions));
      Assert.assertTrue(validatePositions.isDisplayed());
    }

    public void navigateToPositionsCategoriesPage(){

        waitUntilVisibleAndClickableAndThenClick(humanResourcesButton);
        waitUntilVisibleAndClickableAndThenClick(setupBtnThree);
        mouseAction(positionsCategoriesBtn);
        wait.until(ExpectedConditions.visibilityOf(validatePositionsCategories));
        Assert.assertTrue(validatePositionsCategories.isDisplayed());

    }

    public void navigateToSchoolLocationPage(){
        setupButton.click();
        schoolSetupBtn.click();
        locationsButton.click();

    }






}
