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

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement usernameInput;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    private WebElement dashboardText;

    @FindBy(xpath = "//div[text()='Invalid username or password']")
    private WebElement invalidLoginMessage;

    private String username = "richfield.edu";
    private String password = "Richfield2020!";

    private String invalidUserName = "richfield";

    private String invalidPassword = "Richfield2020";

    public void validateUserOnLoginPage(){
        Assert.assertTrue(usernameInput.isDisplayed());
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertTrue(loginButton.isDisplayed());
    }

    public void userEnterAdminCredentials(){
        acceptCookiesButton.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void validateUserSuccessfullyLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(dashboardText));
        Assert.assertTrue(dashboardText.isDisplayed());
    }

    public void adminEnterInvalidUserNameValidPassword(){
        acceptCookiesButton.click();
        usernameInput.sendKeys(invalidUserName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }


    public void validateUserSuccessfullyNotLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(invalidLoginMessage));
        Assert.assertTrue(invalidLoginMessage.isDisplayed());
        Assert.assertTrue(invalidLoginMessage.getText().toLowerCase().contains("invalid"));
    }

    public void adminEnterValidUserNameInvalidPassword(){
        acceptCookiesButton.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(invalidPassword);
        loginButton.click();
    }

    public void adminEnterInvalidUserNameInvalidPassword(){
        acceptCookiesButton.click();
        usernameInput.sendKeys(invalidUserName);
        passwordInput.sendKeys(invalidPassword);
        loginButton.click();
    }







}
