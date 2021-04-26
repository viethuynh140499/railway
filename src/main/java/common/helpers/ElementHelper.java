package common.helpers;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitElementExist(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
