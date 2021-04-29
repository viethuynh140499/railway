package test_cases;

import common.helpers.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.MyTicketPage;

public class MyTicketTest extends BaseTest {
  private final HomePage homePage = new HomePage();
  private final LoginPage loginPage = new LoginPage();
  private final MyTicketPage manageTicket = new MyTicketPage();

  @BeforeMethod
  public void beforeMethod(){
    homePage.clickLoginTab();
    loginPage.login(Constant.USERNAME, Constant.PASSWORD);
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
