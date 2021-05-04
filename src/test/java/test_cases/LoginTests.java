package test_cases;

import common.helpers.BrowserHelper;
import common.helpers.Constant;
import common.helpers.DataHelper;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class LoginTests extends BaseTest {
  HomePage homePage = new HomePage();
  LoginPage loginPage = new LoginPage();

  @Test(description = "User can log into Railway with valid username and password")
  public void TC01() {
    User user = new User(Constant.USERNAME, Constant.PASSWORD);

    homePage.clickLoginTab();
    loginPage.login(user);

    String actualResult = homePage.getWelcomeMessage();
    String expectedResult = "Welcome " + user.getUsername();

    Assert.assertEquals(actualResult, expectedResult);
  }

  @Test(description = "User can't login with blank Username textbox")
  public void TC02() {
    User user = new User("", Constant.PASSWORD);

    homePage.clickLoginTab();
    loginPage.login(user);

    String actualResult = loginPage.getErrorMessage();
    String expectedResult = "There was a problem with your login and/or errors exist in your form.";

    Assert.assertEquals(actualResult, expectedResult);
  }

  @Test(description = "User cannot log into Railway with invalid password ")
  public void TC03() {

    User user = new User(Constant.USERNAME, DataHelper.getRandomInvalidPassword());

    homePage.clickLoginTab();
    loginPage.login(user);

    String actualResult = loginPage.getErrorMessage();
    String expectedResult = "There was a problem with your login and/or errors exist in your form.";

    Assert.assertEquals(actualResult, expectedResult);
  }

  @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
  public void TC04() {
    homePage.clickBookTicket();
    String actualResult = BrowserHelper.getTitle();
    String expectedResult = "Safe Railway - Login";
    Assert.assertEquals(actualResult, expectedResult);
  }
}
