package test_cases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.constant.Constant;
import common.helpers.DataHelper;
import common.helpers.DataProviderHelper;
import model.User;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.IOException;
import java.util.List;

public class LoginTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    public static ObjectMapper objectMapper;

    @Test(dataProvider = "valid-user", dataProviderClass = DataProviderHelper.class, description = "login successfully with valid email and password")
    public void TC01(User user) {

        loginPage.login(user.getUsername(), user.getPassword());

        String actualResult = homePage.getWelcomeMessage();
        String expectedResult = user.getWelcomeMessage();

        homePage.logout();

        Assert.assertEquals(actualResult, expectedResult, "Welcome message not match");
    }


    @Test(dataProvider = "invalid-user", dataProviderClass = DataProviderHelper.class, description = "login unsuccessfully with valid email and password")
    public void TC02(User user) {

        loginPage.login(user.getUsername(), user.getPassword());

        String actualResult = loginPage.getLblErrorMessage();
        String expectedResult = user.getWelcomeMessage();

        homePage.logout();

        Assert.assertEquals(actualResult, expectedResult, "Welcome message not match");
    }


    @DataProvider(name = "valid-user")
    public static Object[] getValidLoginData() throws IOException, ParseException {
        String json = DataHelper.getJsonData(DataHelper.getProjectPath() + Constant.DATA_PATH + "login_successfully.json").toString();
        List<User> users = objectMapper.readValue(json, new TypeReference<List<User>>() {
        });
        return users.toArray();
    }

    @DataProvider(name = "invalid-user")
    public Object[] getInvalidLoginData() throws IOException, ParseException {
        String json = DataHelper.getJsonData(Constant.DATA_PATH + "login_unsuccessfully.json").toString();
        List<User> users = objectMapper.readValue(json, new TypeReference<List<User>>() {
        });
        return users.toArray();
    }
}
