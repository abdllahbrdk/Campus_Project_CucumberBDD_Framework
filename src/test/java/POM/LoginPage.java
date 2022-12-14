package POM;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePOM {

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="mat-input-0")
    private WebElement usernameInput;

    @FindBy(id="mat-input-1")
    private WebElement passwordInput;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboardText;

    @FindBy(xpath = "//div[text()='Invalid username or password']")
    private WebElement invalidLoginMessage;

    public void validateUserOnLoginPage(){

        Assert.assertTrue(usernameInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    public void userEnterValidCredentials(String username, String password){
        waitUntilVisibleAndClickableAndThenClick(acceptCookiesButton);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

    }

    public void AdminUserClickLoginButton(){
        waitUntilVisibleAndClickableAndThenClick(loginButton);

    }

    public void validateUserSuccessfullyLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(dashboardText));
        Assert.assertTrue(dashboardText.isDisplayed());
    }

    public void adminEnterInvalidCredentials(String invalidUserName, String password){
        waitUntilVisibleAndClickableAndThenClick(acceptCookiesButton);
        usernameInput.sendKeys(invalidUserName);
        passwordInput.sendKeys(password);

    }


    public void validateUserSuccessfullyNotLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(invalidLoginMessage));
        Assert.assertTrue(invalidLoginMessage.isDisplayed());
        Assert.assertTrue(invalidLoginMessage.getText().toLowerCase().contains("invalid".toLowerCase()));
    }
}
