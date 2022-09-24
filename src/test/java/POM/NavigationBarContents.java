package POM;

import Utils.BaseDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBarContents extends BasePOM {

    public NavigationBarContents() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath="(//span[text()='Setup'])[1]")
    private WebElement setupButton;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parametersButton;

    @FindBy(xpath = "//span[text()='Grade Levels']")
    private WebElement gradeLevelsButton;

    @FindBy(xpath = "(//span[text()='Fields'])[1]")
    private WebElement fieldsButton;

    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResourcesButton;

    @FindBy(xpath = "(//span[text()='Attestations'])[1]")
    private WebElement attestationsButton;

    @FindBy(xpath = "(//span[text()='Setup'])[3]")
    private WebElement setUpButtonForAttestations;

    public void navigateToGradeLevelsPage(){
        setupButton.click();
        parametersButton.click();
        waitUntilVisibleAndClickableAndThenClick(gradeLevelsButton);
    }

    public void validateGradeLevelsPresent(){
        Assert.assertTrue(gradeLevelsButton.isDisplayed());
    }

    public void navigateToFieldsPage(){
        setupButton.click();
        parametersButton.click();
        waitUntilVisibleAndClickableAndThenClick(fieldsButton);
        validateFieldsPresent();
    }

    public void validateFieldsPresent(){
        Assert.assertTrue(fieldsButton.isDisplayed());
    }

    public void navigateToAttestationsPage(){
        humanResourcesButton.click();
        waitUntilVisibleAndClickableAndThenClick(setUpButtonForAttestations);
        waitUntilVisibleAndClickableAndThenClick(attestationsButton);
    }

    public void validateAttestationPresent(){
        Assert.assertTrue(attestationsButton.isDisplayed());
    }


}
