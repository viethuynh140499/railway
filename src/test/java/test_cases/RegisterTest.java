package test_cases;

import common.helpers.DataHelper;
import common.helpers.LogHelper;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;
import test_cases.BaseTest;

public class RegisterTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        LogHelper.info("> Go to Register Page.");
        homePage.clickRegisterTab();
    }

    @Test(description = "User can created an account successfully  with correct information")
    public void testCase01() {
        User user = new User();
        LogHelper.info("> Generate data for Register");
        user.setUsername(DataHelper.getRandomValidEmail());
        user.setPassword(DataHelper.getRandomValidPassword());
        user.setConfirmPassword(user.getPassword());
        user.setPid(DataHelper.getRandomValidPID());
        LogHelper.info("> Enter necessary info into Registration form then submit.");
        registerPage.register(user);
        LogHelper.info("> Verify the Successful Message.");
        Assert.assertEquals(registerPage.getSuccessfullyMessage(), "You're here");
    }

    @Test(description = "User can't created an account successfully  with incorrect information")
    public void testCase02() {
        User user = new User();

        user.setUsername(DataHelper.getRandomInvalidEmail());
        user.setPassword(DataHelper.getRandomInvalidPassword());
        user.setPid(DataHelper.getRandomInvalidPID());

        registerPage.register(user);

        Assert.assertEquals(registerPage.getErrorMessage(), "There're errors in the form. Please correct the errors and try again.");
    }

    @Test(description = "User can't created an account successfully with email less than 8 character")
    public void testCase03() {
        User user = new User();

        user.setUsername(DataHelper.getRandomLessThan8EmailCharacter());
        user.setPassword(DataHelper.getRandomValidPassword());
        user.setPid(DataHelper.getRandomValidPID());

        registerPage.register(user);

        Assert.assertEquals(registerPage.getEmailErrorMessage(),"Invalid email length");
    }

    @Test(description = "Register unsuccessfully if the email already has a user")
    public void testCase04(){
        User user = new User();
        user.setUsername(DataHelper.getRandomValidEmail());
        user.setPassword(DataHelper.getRandomValidPassword());
        user.setConfirmPassword(user.getPassword());
        user.setPid(DataHelper.getRandomValidPID());
        registerPage.register(user);
        homePage.clickRegisterTab();
        registerPage.register(user);
        Assert.assertEquals(registerPage.getErrorMessage(),"This email address is already in use.");
    }

    @Test(description = "Re")
    public void testCase05(){

    }

}
