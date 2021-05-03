package test_cases;

import common.helpers.Constant;
import model.Ticket;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyTicketTest extends BaseTest {
    User user = new User(Constant.USERNAME, Constant.PASSWORD);

    @BeforeMethod
    public void beforeMethod() {
        homePage.clickLoginTab();
        loginPage.login(user);
        homePage.clickMyTicketTab();
    }

    @Test(description = "User can cancel all ticket successfully")
    public void testCase01() {
        manageTicket.cancelAllTicket();
        Assert.assertEquals(manageTicket.filterErrorMessage(), "No result found!");
        Assert.assertEquals(manageTicket.errorMessage(), "Sorry, can't find any results that match your filters.\nPlease change the filters and try again.");
        Assert.assertEquals(manageTicket.noteMessage(), "You currently book 0 ticket, you can book 10 more.");
    }

    @Test(description = "User can delete all ticket successfully")
    public void testCase02() {
        manageTicket.deleteAllTicket();
        Assert.assertEquals(manageTicket.filterErrorMessage(), "No result found!");
        Assert.assertEquals(manageTicket.errorMessage(), "Sorry, can't find any results that match your filters.\nPlease change the filters and try again.");
        Assert.assertEquals(manageTicket.noteMessage(), "You currently book 0 ticket, you can book 10 more.");
    }

    @Test(description = "User can delete by filter ")
    public void TC02() {
        Ticket ticket = new Ticket();
        ticket.setDepartFrom("Sài Gòn");
        ticket.setArriveAt("Phan Thiết");
        ticket.setDepartDate("5/7/2021");
        ticket.setStatus("New");
        manageTicket.findTicket(ticket);
        manageTicket.cancelAllTicket();
    }

}
