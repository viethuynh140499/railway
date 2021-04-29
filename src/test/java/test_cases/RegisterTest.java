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
  public void testCase01() {
    String username = DataHelper.getRandomValidEmail();
    String password = DataHelper.getRandomValidPassword();
    String pid = DataHelper.getRandomValidPID();
    homePage.clickRegisterTab();
    registerPage.register(username, password, password, pid);

    Assert.assertEquals(registerPage.getSuccessfullyMessage(), "You'll here.");
  }

  @Test(description = "User creates an account unsuccessfully with incorrect information")
  public void testCase02() {
    String username = DataHelper.getRandomInvalidEmail();
    String password = DataHelper.getRandomInvalidPassword();
    String pid = DataHelper.getRandomInvalidPID();
    homePage.clickRegisterTab();
    registerPage.register(username, password, password, pid);

    Assert.assertEquals(registerPage.getErrorMessage(), "There're errors in the form. Please correct the errors and try again.");
  }
}
