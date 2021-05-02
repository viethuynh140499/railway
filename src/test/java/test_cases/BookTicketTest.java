package test_cases;

import common.helpers.BrowserHelper;
import common.helpers.Constant;
import common.helpers.DataHelper;
import model.Ticket;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BookTicketTest extends BaseTest {
    private Ticket ticket;

    @BeforeMethod
    public void beforeMethod() {
        homePage.clickBookTicketTab();
    }

    @Test(description = "Book can book ticket successfully")
    public void testCase01() {
        User user = new User(Constant.USERNAME, Constant.PASSWORD);
        loginPage.login(user);
        Ticket ticket = new Ticket();
        ticket.setDepartDate(DataHelper.getRandomDepartDate());
        ticket.setDepartFrom("Đà Nẵng");
        ticket.setArriveAt("Huế");
        ticket.setSeatType("Soft bed");
        ticket.setTicketAmount("1");
        bookTicketPage.bookTicket(ticket);
        String actualResult = bookTicketPage.getSuccessfullyMessage();
        String expectedResult = "Ticket Booked Successfully!";

        Assert.assertEquals(actualResult, expectedResult, actualResult + " is not matched with " + expectedResult);

        Assert.assertEquals(bookTicketPage.getTableCellValue("Arrive Station"), ticket.getArriveAt(), "Arrive Station is not displayed as expected");
        Assert.assertEquals(bookTicketPage.getTableCellValue("Depart Station"), ticket.getDepartFrom(), "Depart Station is not displayed as expected");
    }

    @Test(description = "Error message is displayed when total number of booked tickets is more than 10")
    public void testCase02() {

        User user = new User();
        user.setUsername(DataHelper.getRandomValidEmail());
        user.setPassword(DataHelper.getRandomValidPassword());
        user.setConfirmPassword(user.getPassword());
        user.setPid(DataHelper.getRandomValidPID());

        Ticket ticket = new Ticket();
        ticket.setDepartDate(DataHelper.getRandomDepartDate());
        ticket.setDepartFrom("Đà Nẵng");
        ticket.setArriveAt("Huế");
        ticket.setSeatType("Soft bed");
        ticket.setTicketAmount("10");
        homePage.clickRegisterTab();
        registerPage.register(user);
        homePage.clickBookTicketTab();
        loginPage.login(user);
        bookTicketPage.bookTicket(ticket);
        BrowserHelper.returnPreviousPage();
        ticket.setDepartFrom("Sài Gòn");
        ticket.setArriveAt("Huế");
        ticket.setTicketAmount("10");
        bookTicketPage.bookTicket(ticket);

        Assert.assertEquals(bookTicketPage.getGeneralErrorMessage(), "There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(bookTicketPage.getTicketAmountErrorMessage(), "You have booked 10 tickets. You can book no more.");
    }

    @Test(description = "Error message is displayed when total number of booked tickets is more than 10")
    public void testCase03() {

        User user = new User();
        user.setUsername(DataHelper.getRandomValidEmail());
        user.setPassword(DataHelper.getRandomValidPassword());
        user.setConfirmPassword(user.getPassword());
        user.setPid(DataHelper.getRandomValidPID());

        Ticket ticket = new Ticket();

        ticket.setDepartDate(DataHelper.getRandomDepartDate());
        ticket.setDepartFrom("Đà Nẵng");
        ticket.setArriveAt("Quảng Ngãi");
        ticket.setSeatType("Soft bed");
        ticket.setTicketAmount("7");
        int beforeTicket =Integer.parseInt(ticket.getTicketAmount());
        int numberOfTicketRemain = 10 - Integer.parseInt(ticket.getTicketAmount());
        homePage.clickRegisterTab();
        registerPage.register(user);
        homePage.clickBookTicketTab();
        loginPage.login(user);
        bookTicketPage.bookTicket(ticket);
        BrowserHelper.returnPreviousPage();
        ticket.setArriveAt("Nha Trang");
        ticket.setTicketAmount("10");
        bookTicketPage.bookTicket(ticket);
        Assert.assertEquals(bookTicketPage.getErrorMessage(), "There're errors in the form. Please correct the errors and try again.");
        Assert.assertEquals(bookTicketPage.getTicketAmountErrorMessage(), "You have booked " + beforeTicket + " ticket(s). You can only book " + numberOfTicketRemain + " more.");
    }
}
