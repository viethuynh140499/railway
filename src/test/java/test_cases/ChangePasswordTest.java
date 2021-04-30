package test_cases;

import common.helpers.DataHelper;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.RegisterPage;


public class ChangePasswordTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    RegisterPage registerPage = new RegisterPage();
    String newPassword = "viet123456";
    String randomPassword = DataHelper.getRandomValidPassword();

    @BeforeMethod
    public void beforeMethod() {
        homePage.clickRegisterTab();
    }

    @Test(description = "User can change password successfully")
    public void testCase01() {
        User user = new User();
        user.setUsername(DataHelper.getRandomValidEmail());
        user.setPassword(DataHelper.getRandomValidPassword());
        user.setConfirmPassword(user.getPassword());
        user.setPid(DataHelper.getRandomValidPID());
        registerPage.register(user);
        homePage.clickLoginTab();
        loginPage.login(user);
        homePage.clickChangePasswordTab();

        changePasswordPage.changePassword(user.getPassword(), newPassword, newPassword);
        String actualResult = changePasswordPage.getSuccessfullyMessage();
        String expectedResult = "Your password has been updated!";
        Assert.assertEquals(actualResult, expectedResult, "Change Password message not match");
    }

     @Test(description = "User can't change password unsuccessfully with invalid current password")
     public void testCase02() {
         changePasswordPage.changePassword(randomPassword, newPassword, newPassword);
         String actualResult = changePasswordPage.getErrorMessage();
         String expectedResult = "An error occurred when attempting to change the password. Maybe your current password is incorrect.";
         Assert.assertEquals(actualResult, expectedResult, "Error Message not match");
     }

     @Test(description = "User can't change password unsuccessfully with confirm password not match new password")
     public void testCase03() {
         changePasswordPage.changePassword(newPassword, randomPassword, randomPassword);
         String actualResult = changePasswordPage.getConfirmPasswordErrorMessage();
         String expectedResult = "The password confirmation does not match the new password.";
         Assert.assertEquals(actualResult, expectedResult, "Error Message not match");
     }
    @AfterMethod
    public void afterMethod() {
        homePage.clickLogoutTab();
    }

}
