package test_cases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.helpers.Constant;
import common.helpers.DataHelper;
import model.User;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {
    @Test(description = "login successfully with valid email and password")
    public void TC01() {
        User user = new User(Constant.USERNAME, Constant.PASSWORD);
        homePage.clickLoginTab();
        loginPage.login(user);

        String actualResult = homePage.getWelcomeMessage();
        String expectedResult = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualResult, expectedResult, "Welcome message not match");

        homePage.clickLogoutTab();
    }

    @Test(dataProvider = "invalidUser", description = "login unsuccessfully with valid email and password")
    public void TC02(User user) {
        homePage.clickLoginTab();
        loginPage.login(user);

        String actualResult = loginPage.getErrorMessage();
        String expectedResult = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualResult, expectedResult, "Error message is not displayed");
    }


    @Test
    public void testCase03() {
        User user = new User();


    }

    @Test
    public void testCase04() {

    }

    @DataProvider(name = "invalidUser")
    public static Object[] getValidLoginData() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/data/invalidLogin.json");
        String json = DataHelper.getJsonData(file.getAbsolutePath()).toString();
        List<User> users = objectMapper.readValue(json, new TypeReference<List<User>>() {
        });
        return users.toArray();
    }
}
