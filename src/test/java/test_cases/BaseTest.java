package test_cases;

import common.constant.Constant;
import common.helpers.BrowserHelper.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

  private HomePage homePage = new HomePage();

  @BeforeTest
  public void setup(){
    BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
    BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);

  }

  @BeforeMethod
  public void beforeMethod(){
    homePage.goToLoginPage();
  }

  @AfterTest
  public void afterTest() {
    System.out.println("Post-condition");
    Constant.WEBDRIVER.quit();
  }
}