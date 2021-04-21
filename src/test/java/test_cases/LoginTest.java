package test_cases;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class LoginTest extends BaseTest {

    @Test
    public void TC01() throws InterruptedException, IOException, ParseException {
        System.out.println("TC01 - User can login to Railway with valid username and password");
        uservalid();
    }

    @Test
    public void TC02() throws InterruptedException, ParseException, IOException {
        System.out.println("TC01 - User can login to Railway with Invalid username and password");
        uservalid();
    }


    @SuppressWarnings("unchecked")
    public void uservalid() throws InterruptedException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        js.executeScript("window.scrollBy(0,1000)");
        try {
            HomePage homePage = new HomePage();
            homePage.open();
            LoginPage loginPage = homePage.goToLoginPage();
            FileReader reader = new FileReader("src/test/resources/datatest.json");
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray usersList = (JSONArray) obj;
            System.out.println("Users List-> " + usersList); //This prints the entire json file
            for (int i = 0; i < usersList.size(); i++) {
                JSONObject users = (JSONObject) usersList.get(i);
                /*System.out.println("Users -> " + users);//This prints every block - one json object*/
                JSONObject user = (JSONObject) users.get("users");
                System.out.println("User -> " + user); //This prints each data in the block
                String username = (String) user.get("username");
                String password = (String) user.get("password");
                loginPage.login(username, password);
                /*String actualMsg = homePage.getWelcomeMessage();
                String expectedMsg = "Welcome " + user.get("username");
                Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");*/
            }
        } catch (FileNotFoundException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
