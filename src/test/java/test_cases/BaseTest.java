package test_cases;

import common.constant.Constant;
import driver_manager.DriverManagerFactory;
import driver_manager.DriverType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

  @BeforeTest
  public void beforeTest() throws IOException {
    Constant.DRIVER_MANAGER = DriverManagerFactory.getDriverManager(DriverType.CHROME);
    Constant.WEB_DRIVER = Constant.DRIVER_MANAGER.getWebDriver();
    Constant.WEB_DRIVER.manage().window().maximize();
    Constant.WEB_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() throws IOException {
    System.out.println("Post-condition");
    Constant.WEB_DRIVER.quit();
  }
}