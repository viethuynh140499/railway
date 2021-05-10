package test_cases;

import common.helpers.DataHelper;
import model.Ticket;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class MyTicketTest extends BaseTest {
  HomePage homePage = new HomePage();
  RegisterPage registerPage = new RegisterPage();
  LoginPage loginPage = new LoginPage();
  MyTicketPage myTicketPage = new MyTicketPage();
  BookTicketPage bookTicketPage = new BookTicketPage();

  @Test(description = "User can cancel a ticket")
  public void TC16() {
    User user = new User();
    user.setUsername(DataHelper.getRandomValidEmail());
    user.setPassword(DataHelper.getRandomValidPassword());
    user.setPid(DataHelper.getRandomValidPID());

    Ticket ticket = new Ticket();
    ticket.setDepartDate(DataHelper.getRandomDepartDate());
    ticket.setDepartFrom("Sài Gòn");
    ticket.setArriveAt("Nha Trang");
    ticket.setSeatType("Soft bed");
    ticket.setTicketAmount("1");
    ticket.setStatus("New");

    homePage.clickRegisterTab();
    registerPage.registerAccount(user.getUsername(), user.getPassword(), user.getPassword(), user.getPid());
    homePage.clickLoginTab();
    loginPage.login(user);
    bookTicketPage.bookTicket(ticket);
    homePage.clickMyTicketTab();

    myTicketPage.cancelTicket(ticket);

    Assert.assertFalse(myTicketPage.doesTicketDisplay(ticket));

    Assert.assertTrue(myTicketPage.isErrorMessageDisplayed(),"Error Message does not display");
  }
}
