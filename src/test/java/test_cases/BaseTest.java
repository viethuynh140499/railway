package test_cases;

import common.constant.Constant;
import common.helpers.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import page_objects.HomePage;

public class BaseTest {

  private HomePage homePage = new HomePage();
  private WebDriver webDriver;

  @BeforeTest
  public void setup(){
    BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
    BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
  }

  @AfterTest
  public void afterTest() {
    System.out.println("Post-condition");
    BrowserHelper.quitBrowser();
  }
}