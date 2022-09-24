package POM;
import Utils.BaseDriver;
import junit.framework.Assert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasePOM {
    WebDriver driver = BaseDriver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void waitUntilVisibleAndClickableAndThenClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element); // tıklanabilir olana kadar bekle
        scrollToElement(element); // elemente scroll yap
        element.click(); // click yap
    }

    public void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void verifyContainsText(WebElement element, String text)
    {
        waitUntilVisible(element); // gözükene kadar bekle
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void waitUntilLoading() {
        WebDriverWait wait=new WebDriverWait(BaseDriver.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
    }
    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
