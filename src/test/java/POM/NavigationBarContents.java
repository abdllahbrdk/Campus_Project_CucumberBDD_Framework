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

    @FindBy(xpath = "//span[text()='Document Types']")
    private WebElement documentTypesButton;

    public void navigateToDocumentTypesPage() {
        //moreOptionsButton.click();
        setupButton.click();
        parametersButton.click();
        documentTypesButton.click();
    }

}
