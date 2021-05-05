package test_cases;

import common.helpers.Constant;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

public class TestCase01 extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "User can log into Railway with valid username and password")
    public void test() {
        User user = new User(Constant.USERNAME, Constant.PASSWORD);

        homePage.clickLoginTab();
        loginPage.login(user);

        String actualResult = homePage.getWelcomeMessage();
        String expectedResult = "Welcome " + user.getUsername();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
