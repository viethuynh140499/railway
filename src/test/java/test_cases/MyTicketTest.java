package test_cases;

import common.helpers.Constant;
import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class MyTicketTest extends BaseTest {
    User user = new User(Constant.USERNAME, Constant.PASSWORD);

  @BeforeMethod
  public void beforeMethod(){
    homePage.clickLoginTab();
    loginPage.login(user);
    homePage.clickMyTicketTab();
  }

  @Test(description = "User can cancel ticket successfully")
  public void testCase01() {
    manageTicket.cancelAllTicket();
  }

//  @Test(description = "User can u ")
//  public void TC02(){
//    String status = "Expired";
//    manageTicket.findTicket(status);
//    manageTicket.deleteAllTicket();
//  }

}
