package test_cases;

import common.helpers.Constant;
import common.helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.ChangePasswordPage;
import page_objects.HomePage;
import page_objects.LoginPage;


public class ChangePasswordTest extends BaseTest{
  HomePage homePage = new HomePage();
  LoginPage loginPage = new LoginPage();
  ChangePasswordPage changePasswordPage = new ChangePasswordPage();
  String newPassword = "viet123456";
  String randomPassword = DataHelper.getRandomValidPassword();

  @BeforeMethod
  public void beforeMethod() {
    homePage.clickLoginTab();
    loginPage.login(Constant.USERNAME, Constant.PASSWORD);
    homePage.clickChangePasswordTab();
  }

  @Test(description = "User can change password successfully")
  public void testCase01() {
    changePasswordPage.changePassword(Constant.PASSWORD, newPassword, newPassword);
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
  public void testCase03(){
    changePasswordPage.changePassword(newPassword,randomPassword, randomPassword);
    String actualResult = changePasswordPage.getConfirmPasswordErrorMessage();
    String expectedResult = "The password confirmation does not match the new password.";
    Assert.assertEquals(actualResult, expectedResult, "Error Message not match");
  }

  @AfterMethod
  public void afterMethod(){
    homePage.clickLogoutTab();
  }

}
