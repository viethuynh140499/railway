package common.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    public enum DriverType {CHROME, FIREFOX, OPERA}

    private static WebDriver driver;

    public static void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public static void startBrowser(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Constant.IMPLICITLY_WAIT_TIME_OUT, TimeUnit.SECONDS);
        maximizeBrowser();
    }

    public static void quitBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
            driver = null;
        }
    }

    public static WebElement findElement(By locator) {
        return BrowserHelper.getDriver().findElement(locator);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void maximizeBrowser() {
        getDriver().manage().window().maximize();
    }

    public static void acceptAlert() {
        getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        getDriver().switchTo().alert().dismiss();
    }
}
