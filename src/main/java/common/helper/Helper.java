package common.helper;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEB_DRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void waitElementExist(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Constant.WEB_DRIVER, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
