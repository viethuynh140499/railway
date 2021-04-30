package test_cases;

import common.helpers.Constant;
import common.helpers.DataHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class BookTicketTest extends BaseTest {
  private HomePage homePage = new HomePage();
  private LoginPage loginPage = new LoginPage();
  private BookTicketPage bookTicketPage = new BookTicketPage();

  /*@Test(description = "Book can book ticket successfully")
  public void testCase01() {

    String departDate = DataHelper.getRandomDepartDate();
    String departFrom = "Đà Nẵng";
    String arriveAt = "Huế";
    String seatType = "Soft bed";
    int ticketAmount = 1;

    homePage.clickBookTicketTab();
    loginPage.login(Constant.USERNAME, Constant.PASSWORD);
    bookTicketPage.bookTicket(departDate, departFrom, seatType, ticketAmount, arriveAt);

    String actualResult = bookTicketPage.getSuccessfullyMessage();
    String expectedResult = "Ticket Booked Successfully!";

    Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);

    Assert.assertEquals(bookTicketPage.getTableCellValue("Arrive Station"), arriveAt, "Arrive Station is not displayed as expected");
    Assert.assertEquals(bookTicketPage.getTableCellValue("Depart Station"), departFrom, "Depart Station is not displayed as expected");
  }*/
}
