package test_cases;

import common.helpers.Constant;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class LoginTests extends BaseTest {
  HomePage homePage = new HomePage();
  LoginPage loginPage = new LoginPage();
  MyTicketPage myTicketPage = new MyTicketPage();

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

    Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not display");
  }

  @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
  public void TC04() {
    homePage.clickBookTicket();

    String actualPageHeader = homePage.getPageHeader();
    String expectedPageHeader = "Login Page";

    Assert.assertEquals(actualPageHeader, expectedPageHeader, "Login Page does not display");
  }

  @Test(description = "Additional pages display once user logged in")
  public void TC06() {
    User user = new User(Constant.USERNAME, Constant.PASSWORD);
    homePage.clickLoginTab();
    loginPage.login(user);

    homePage.clickChangePasswordTab();

    Assert.assertTrue(homePage.isMyTicketTabDisplayed(), "My ticket Tab does not display");
    Assert.assertTrue(homePage.isLogOutTabDisplayed(), "Log out Tab does not display");
    Assert.assertTrue(homePage.isChangePasswordTabDisplayed(), "Change Password does not display");

    homePage.clickMyTicketTab();
    String actualMyTicketPageHeader = homePage.getPageHeader();
    String expectedMyTicketPageHeader = "Manage Tickets";
    Assert.assertEquals(actualMyTicketPageHeader, expectedMyTicketPageHeader, "User is not directed to My ticket page!");

    homePage.clickChangePasswordTab();
    String actualChangePasswordPageHeader = homePage.getPageHeader();
    String expectedChangePasswordPageHeader = "Change password";

    Assert.assertEquals(actualChangePasswordPageHeader, expectedChangePasswordPageHeader, "User is not directed to Change password page!");
  }
}
