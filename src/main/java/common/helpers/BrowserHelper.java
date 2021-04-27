package common.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {

  public enum DriverType {CHROME, FIREFOX, IE}
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
      default:
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        break;
    }
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  public static void quitBrowser() {
    if (getDriver() != null) {
      getDriver().quit();
      driver = null;
    }
  }

  public static WebDriver getDriver() {
    return driver;
  }
}
