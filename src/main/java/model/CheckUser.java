package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class CheckUser {
  @SuppressWarnings("unchecked")
  public void checkuser() throws InterruptedException, IOException, ParseException {
    JSONParser jsonParser = new JSONParser();
    try {
      HomePage homePage = new HomePage();
      homePage.open();
      LoginPage loginPage = new LoginPage();
      homePage.goToLoginPage();
      FileReader reader = new FileReader("src/test/resources/datatest.json");
      //Read JSON file
      Object obj = jsonParser.parse(reader);
      JSONObject login = (JSONObject) obj;
      JSONArray usersList = (JSONArray) login.get("login");
      System.out.println("Users List-> " + usersList); //This prints the entire json file
      for (int i = 0; i < usersList.size(); i++) {
        JSONObject user = (JSONObject) usersList.get(i);
        /*System.out.println("Users -> " + users);//This prints every block - one json object*/
//                JSONObject user = (JSONObject) users.get("users");
        System.out.println("User -> " + user); //This prints each data in the block
        String username = (String) user.get("username");
        String password = (String) user.get("password");
        loginPage.login(username, password);
        if (!loginPage.getWelcomeMessage().equals("Welcome guest!")) {
          String actualMsg = homePage.getWelcomeMessage();
          String expectedMsg = "Welcome " + user.get("username");
          System.out.println("Actual Message:" + actualMsg);
          System.out.println("Expected Message:"+expectedMsg);
          Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
          loginPage.logout();
        }else{
          String actualMsg = loginPage.getLblErrorMessage();
          String expectedMsg = (String) user.get("invalid");
          Assert.assertEquals(actualMsg,expectedMsg, "Error message is not displayed as expected");
        }
      }
    } catch (FileNotFoundException | org.json.simple.parser.ParseException e) {
      e.printStackTrace();
    }
  }
}