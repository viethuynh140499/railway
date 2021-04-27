package common.helpers.element;

import common.helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserHelper.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitElementExist(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
