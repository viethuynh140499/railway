package test_cases;

import common.helpers.Constant;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.GeneralPage;
import page_objects.LoginPage;

public class TestCase01 extends BaseTest {
  GeneralPage generalPage = new GeneralPage();
  LoginPage loginPage = new LoginPage();

  @Test(description = "User can log into Railway with valid username and password")
  public void test() {
    User user = new User(Constant.USERNAME, Constant.PASSWORD);

    generalPage.clickLoginTab();
    loginPage.login(user);

    String actualResult = generalPage.getWelcomeMessage();
    String expectedResult = "Welcome " + Constant.USERNAME;

    Assert.assertEquals(actualResult, expectedResult, "Welcome" + Constant.USERNAME + " message is not displayed as expected");
  }
}
