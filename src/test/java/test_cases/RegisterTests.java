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
    registerPage.registerAccount(user.getUsername(), user.getPassword(), user.getPassword(), user.getPid());

    String actualSuccessMessage = registerPage.getErrorMessage();
    String expectedSuccessMessage = "You're here";

    Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message does not display");
  }

  @Test(description = "User can't create account with Confirm password is not the same with Password")
  public void TC10() {
    User user = new User();
    user.setUsername(DataHelper.getRandomValidEmail());
    user.setPid(DataHelper.getRandomValidPID());
    String password = "12345678";
    String confirmPassword = "123456789";

    homePage.clickRegisterTab();
    registerPage.registerAccount(user.getUsername(), password, confirmPassword, user.getPid());

    String actualErrorMessage = registerPage.getErrorMessage();
    String expectedErrorMessage = "There're errors in the form. Please correct the errors and try again.";

    Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not display");
  }

  @Test(description = "User can't create account while password and PID fields are empty")
  public void TC11() {
    User user = new User();
    user.setUsername(DataHelper.getRandomValidEmail());
    user.setPassword("");
    user.setPassword("");
    user.setPid("");

    homePage.clickLoginTab();
    registerPage.registerAccount(user.getUsername(), "", "", "");

    String actualErrorMessage = registerPage.getErrorMessage();
    String expectedErrorMessage = "There're errors in the form. Please correct the errors and try again.";
    String actualPasswordErrorMessage = registerPage.getPasswordErrorMessage();
    String expectedPasswordErrorMessaage = "Invalid Password length";
    String actualPIDErrorMessage = registerPage.getPIDErrorMessage();
    String expectedPIDErrorMessage = "Invalid ID length";

    Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not display");
    Assert.assertEquals(actualPasswordErrorMessage, expectedPasswordErrorMessaage, "Error message does not display");
    Assert.assertEquals(actualPIDErrorMessage, expectedPIDErrorMessage, "Error message does not display");
  }
}
