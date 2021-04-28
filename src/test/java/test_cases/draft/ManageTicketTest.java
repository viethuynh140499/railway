package test_cases.draft;

import common.Constant;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import page_objects.ManageTicketPage;
import test_cases.BaseTest;

public class ManageTicketTest extends BaseTest {
  private final HomePage homePage = new HomePage();
  private final LoginPage loginPage = new LoginPage();
  private final ManageTicketPage manageTicket = new ManageTicketPage();

  @Test(description = "User can cancel ticket successfully")
  public void TC01() {
    homePage.clickLoginTab();
    loginPage.login(Constant.USERNAME, Constant.PASSWORD);
    homePage.clickMyTicketTab();
    manageTicket.cancelTicket();

  }

}
