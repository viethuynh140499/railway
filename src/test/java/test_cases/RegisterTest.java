package test_cases;

import common.helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class RegisterTest extends BaseTest {
  HomePage homePage = new HomePage();
  RegisterPage registerPage = new RegisterPage();

  @Test(description = "User created an account successfully  with correct information")
  public void TC01() {
    String username = DataHelper.getRandomEmailValid();
    String password = DataHelper.getRandomPasswordValid();
    String pid = DataHelper.getRandomPIDValid();
    homePage.clickRegisterTab();
    registerPage.register(username, password, password, pid);

    Assert.assertEquals(registerPage.getSuccessfullyMessage(), "You'll here.");
  }

  @Test(description = "User creates an account unsuccessfully with incorrect information")
  public void TC02() {
    String username = DataHelper.getRandomEmailInvalid();
    String password = DataHelper.getRandomPasswordInvalid();
    String pid = DataHelper.getRandomPIDInvalid();
    homePage.clickRegisterTab();
    registerPage.register(username, password, password, pid);

    Assert.assertEquals(registerPage.getErrorMessage(), "There're errors in the form. Please correct the errors and try again.");
  }
}
