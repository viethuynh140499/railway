package test_cases;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.constant.Constant;
import common.helpers.data.DataHelper;
import common.helpers.data.FakerDataHelper;
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

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Test( description = "login successfully with valid email and password")
    public void TC01() {
        homePage.clickTabLogin();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualResult = homePage.getWelcomeMessage();
        String expectedResult = "Welcome" + Constant.USERNAME;

        homePage.logout();

        Assert.assertEquals(actualResult, expectedResult, "Welcome message not match");
    }


    @Test(dataProvider = "InvalidUser", description = "login unsuccessfully with valid email and password")
    public void TC02(User user) {
        homePage.clickTabLogin();
        loginPage.login(user.getUsername(), user.getPassword());

        String actualResult = homePage.getWelcomeMessage();
        String expectedResult = user.getWelcomeMessage();

        homePage.logout();

        Assert.assertEquals(actualResult, expectedResult, "Welcome message not match");
    }

    @DataProvider(name = "InvalidUser")
    public static Object[] getValidLoginData() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/data/login_successfully.json");
//        String json = DataHelper.getJsonData(DataHelper.getProjectPath() + Constant.DATA_PATH + "login_successfully.json").toString();
        String json = DataHelper.getJsonData(file.getAbsolutePath()).toString();
//        String json = file.getAbsoluteFile().toString();
        List<User> users = objectMapper.readValue(json, new TypeReference<List<User>>() {
        });
        return users.toArray();
    }
}
