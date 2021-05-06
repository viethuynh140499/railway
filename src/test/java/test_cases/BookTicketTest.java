package test_cases;

import common.helpers.Constant;
import common.helpers.DataHelper;
import model.Ticket;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BookTicketPage;
import page_objects.HomePage;
import page_objects.LoginPage;

public class BookTicketTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "User can book 1 ticket at a time")
    public void TC14() {
        User user = new User(Constant.USERNAME, Constant.PASSWORD);
        Ticket ticket = new Ticket();
        ticket.setDepartDate(DataHelper.getRandomDepartDate());
        ticket.setDepartFrom("Huế");
        ticket.setArriveAt("Sài Gòn");
        ticket.setSeatType("Soft bed");
        ticket.setTicketAmount("1");

        homePage.clickLoginTab();
        loginPage.login(user);
        homePage.clickBookTicket();
        bookTicketPage.bookTicket(ticket);

        String actualResult = bookTicketPage.getPageHeader();
        String expectedResult = "Ticket Booked Successfully!";

        Assert.assertEquals(actualResult, expectedResult, "Message 'Ticket booked successfully' does not display");

        Assert.assertEquals(bookTicketPage.getTableCellValue("Depart Date"), ticket.getArriveAt(), "Depart Date is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Arrive Station"), ticket.getArriveAt(), "Arrive Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Depart Station"), ticket.getDepartFrom(), "Depart Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Seat Type"), ticket.getSeatType(), "Seat Type is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Amount"), ticket.getTicketAmount(), "Amount is not displayed as expected");
    }
}
