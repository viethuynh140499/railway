package test_cases;

import common.helper.Helper;
import common.constant.Constant;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class LoginTest extends BaseTest {

//    @Test
//    public void TC01() throws InterruptedException {
//        System.out.println("TC01 - User can login to Railway with valid username and password");
//        HomePage homePage = new HomePage();
//        homePage.open();
//        LoginPage loginPage = homePage.goToLoginPage();
//        js.executeScript("window.scrollBy(0,500)");
//        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
//        String actualMsg = homePage.getWelcomeMessage();
//        String expectedMsg = "Welcome " + Constant.USERNAME;
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
//    }
    @Test
    public void TC01() throws InterruptedException, IOException, ParseException {
        readWriteJSON();
    }

    @SuppressWarnings("unchecked")
    public void readWriteJSON() throws InterruptedException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();

        try {
            FileReader reader = new FileReader("src/test/resources/datatest.json");
            Object obj = jsonParser.parse(reader);
            JSONArray usersList = (JSONArray) obj;
            System.out.println("Users List-> " + usersList); //This prints the entire json file
            for (int i = 0; i < usersList.size(); i++) {
                JSONObject users = (JSONObject) usersList.get(i);
                System.out.println("Users -> " + users);//This prints every block - one json object
                String username = (String) users.get("username");
                String password = (String) users.get("password");
                String result = loginPage.login(username, password);
                users.put("result", result);
                //Write JSON file
                try (FileWriter file = new FileWriter("src/test/resources/Testdata1.json")) {

                    file.append(usersList.toJSONString());
                    file.flush();


                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println(users);


            }
        } catch (FileNotFoundException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
