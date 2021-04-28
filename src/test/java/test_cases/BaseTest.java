package test_cases;

import common.Constant;
import common.helpers.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import page_objects.HomePage;

public class BaseTest {
  @BeforeMethod
  public void setup(){
    BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
    BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
  }

  @AfterMethod
  public void afterTest() {
    System.out.println("Post-condition");
    BrowserHelper.quitBrowser();
  }
}