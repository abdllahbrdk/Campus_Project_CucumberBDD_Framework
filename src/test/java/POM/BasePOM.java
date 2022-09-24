package POM;
import Utils.BaseDriver;
import org.openqa.selenium.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePOM {
    WebDriver driver = BaseDriver.getDriver();
    WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(),Duration.ofSeconds(30));

    public void waitUntilVisibleAndClickableAndThenClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
 
    public void waitUntilLoading(){
        wait = new WebDriverWait(BaseDriver.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"),0));
    }
    
   public void mouseAction(WebElement element){

        Actions actions = new Actions(BaseDriver.getDriver());
        wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(element).click().build().perform();

    }

    }
