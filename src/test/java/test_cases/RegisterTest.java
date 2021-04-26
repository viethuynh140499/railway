package test_cases;

import common.helpers.DataProviderHelper;
import common.helpers.FakerHelper;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;
import page_objects.SuccessfullyRegister;

public class RegisterTest extends BaseTest {
  HomePage homePage = new HomePage();
  SuccessfullyRegister successfullyRegister = new SuccessfullyRegister();


  @Test(dataProvider = "valid-user", dataProviderClass = DataProviderHelper.class, description = "login successfully with valid email and password")
  public void TC01(User user) {

    String username = FakerHelper.randomEmail();
    String password = FakerHelper.randomPassword();
    String pid = FakerHelper.randomPID();

    homePage.goToRegisterPage();
    RegisterPage registerPage = new RegisterPage();
    registerPage.register(username,password, password, pid );

    Assert.assertEquals(successfullyRegister.getTxtSuccessfully(), "Registration Confirmed! You can now log in to the site.");
  }

}
