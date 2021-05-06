package test_cases;

import common.helpers.Constant;
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

    String actualWelcomeMessage = homePage.getWelcomeMessage();
    String expectedWelcomeMessage = "Welcome " + user.getUsername();

    Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Welcome Message is not displayed");
  }

  @Test(description = "User can't login with blank Username textbox")
  public void TC02() {
    User user = new User("", Constant.PASSWORD);

    homePage.clickLoginTab();
    loginPage.login(user);

    String actualErrorMessage = loginPage.getErrorMessage();
    String expectedErrorMessage = "There was a problem with your login and/or errors exist in your form.";

    Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not displayed");
  }

  @Test(description = "User cannot log into Railway with invalid password ")
  public void TC03() {
    User user = new User(Constant.USERNAME, Constant.INVALID_PASSWORD);

    homePage.clickLoginTab();
    loginPage.login(user);

    String actualErrorMessage = loginPage.getErrorMessage();
    String expectedErrorMessage = "There was a problem with your login and/or errors exist in your form.";

    Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not displayed");
  }

  @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
  public void TC04() {
    homePage.clickBookTicket();
    String actualPageHeader = homePage.getPageHeader();
    String expectedPageHeader = "Login Page";

    Assert.assertEquals(actualPageHeader, expectedPageHeader, "Error Message is not displayed");
  }
}
