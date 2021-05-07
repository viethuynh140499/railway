package test_cases;

import common.helpers.DataHelper;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class ChangePasswordTest extends BaseTest {
  HomePage homePage = new HomePage();
  RegisterPage registerPage = new RegisterPage();
  LoginPage loginPage = new LoginPage();
  ChangePasswordPage changePasswordPage = new ChangePasswordPage();

  @Test(description = "User can change password")
  public void TC09() {
    User user = new User();
    user.setUsername(DataHelper.getRandomValidEmail());
    String oldPassword = DataHelper.getRandomValidPassword();

    homePage.clickLoginTab();
    loginPage.login(user);
    homePage.clickChangePasswordTab();

    String newPassword = DataHelper.getRandomValidPassword();
    user.setPassword(newPassword);

    changePasswordPage.changePassword(oldPassword, newPassword, newPassword);
    String actualSuccessMessage = changePasswordPage.getSuccessfullyMessage();
    String expectedSuccessMessage = "Your password has been updated!";

    Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Change password unsuccessfully");

    homePage.clickLogoutTab();
    homePage.clickLoginTab();
    loginPage.login(user);

    String actualWelcomeMessage = homePage.getWelcomeMessage();
    String expectedWelcomeMessage = "Welcome " + user.getUsername();

    Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Welcome Message is not displayed");
  }
}
