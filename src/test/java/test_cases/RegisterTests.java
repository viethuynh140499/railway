package test_cases;

import common.helpers.DataHelper;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;

public class RegisterTests extends BaseTest {
  HomePage homePage = new HomePage();
  RegisterPage registerPage = new RegisterPage();
  LoginPage loginPage = new LoginPage();

  @Test(description = "User can create new account")
  public void TC07(){
    User user = new User();
    user.setUsername(DataHelper.getRandomValidEmail());
    user.setPassword(DataHelper.getRandomValidPassword());
    user.setPid(DataHelper.getRandomValidPID());

    homePage.clickRegisterTab();
    registerPage.registerAccount(user);

    String actualSuccessMessage = registerPage.getSuccessfullyMessage();
    String expectedSuccessMessage = "You're here";

    Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message does not display");

    loginPage.login(user);

    String actualWelcomeMessage = homePage.getWelcomeMessage();
    String expectedWelcomeMessage = "Welcome " + user.getUsername();

    Assert.assertEquals(actualWelcomeMessage, expectedWelcomeMessage, "Welcome Message is not displayed");
  }
}
