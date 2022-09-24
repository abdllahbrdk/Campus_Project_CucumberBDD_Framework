package POM;

import Utils.BaseDriver;
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

    // School Setup
    @FindBy(xpath = "//span[text()='School Setup']")
    private WebElement schoolSetup;

    // departments link
    @FindBy (xpath = "//span[text()='Departments']")
    private WebElement departmentsButton;

    public void navigateToDepartmentsPage() {
        setupButton.click();
        schoolSetup.click();
        waitUntilVisibleAndClickableAndThenClick(departmentsButton);
    }

}
