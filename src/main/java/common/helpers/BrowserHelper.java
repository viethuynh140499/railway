package common.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {

  public enum DriverType {CHROME, FIREFOX, EDGE}

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
      case EDGE:
        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();
        break;
    }
    driver.manage().timeouts().implicitlyWait(Constant.TIME_OUT_IMPLICITLY_WAIT, TimeUnit.SECONDS);
    maximizeBrowser();
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

  public static void maximizeBrowser() {
    getDriver().manage().window().maximize();
  }
}
