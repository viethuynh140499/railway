package test_cases;

import com.github.javafaker.Faker;
import common.constant.Constant;
import common.helpers.data.FakerDataHelper;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class BookTicketTest extends BaseTest{
  private HomePage homePage = new HomePage();
  private LoginPage loginPage = new LoginPage();
  private BookTicketPage bookTicketPage = new BookTicketPage();

  @Test(description = "Book ticket successfully with correct information")
  public void TC01(){

    homePage.clickTabBookTicket();
    loginPage.login(Constant.USERNAME,Constant.PASSWORD);
//    bookTicketPage.bookTicket();
  }
}
