package test_cases;

import common.helpers.data.FakerDataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;
import page_objects.SuccessfullyRegisterPage;

public class RegisterTest extends BaseTest {
  HomePage homePage = new HomePage();
  RegisterPage registerPage = new RegisterPage();
  SuccessfullyRegisterPage successfullyRegister = new SuccessfullyRegisterPage();


  @Test(description = "User created an account successfully  with correct information")
  public void TC01() {
    String username = FakerDataHelper.randomEmailValid();
    String password = FakerDataHelper.randomPasswordValid();
    String pid = FakerDataHelper.randomPIDValid();
    homePage.goToRegisterPage();
    registerPage.register(username,password, password, pid );
    Assert.assertEquals(successfullyRegister.getTxtSuccessfully(), "Registration Confirmed! You can now log in to the site.");
  }

  @Test(description = "User creates an account unsuccessfully with incorrect information")
  public void TC02(){
    String username = FakerDataHelper.randomEmailInvalid();
    String password = FakerDataHelper.randomPasswordInvalid();
    String pid = FakerDataHelper.randomPIDInvalid();
    homePage.goToRegisterPage();
    registerPage.register(username, password,password,pid);
    Assert.assertEquals(registerPage.getErrorMessage(),"There're errors in the form. Please correct the errors and try again.");
  }
}
