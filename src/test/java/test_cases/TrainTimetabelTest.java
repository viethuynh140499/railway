package test_cases;

import common.helpers.DataHelper;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.*;

public class TrainTimetabelTest extends BaseTest {
  HomePage homePage = new HomePage();
  RegisterPage registerPage = new RegisterPage();
  LoginPage loginPage = new LoginPage();
  TrainTimetablePage trainTimetablePage = new TrainTimetablePage();
  BookTicketPage bookTicketPage = new BookTicketPage();

  @Test(description = "User can open Book ticket page by clicking on Book ticket link in Train timetable page")
  public void TC15() {
    User user = new User();
    user.setUsername(DataHelper.getRandomValidEmail());
    user.setPassword(DataHelper.getRandomValidPassword());
    user.setPid(DataHelper.getRandomValidPID());

    homePage.clickRegisterTab();
    registerPage.registerAccount(user.getUsername(), user.getPassword(), user.getPassword(), user.getPid());
    loginPage.login(user);
    homePage.clickTrainTimetableTab();

    String departStation = "Huế";
    String arriveAt = "Sài Gòn";
    trainTimetablePage.clickBookTicket(departStation,arriveAt);

    homePage.clickBookTicket();
    String actualBookTicketPageHeader = homePage.getPageHeader();
    String expectedBookTicketPageHeader = "Book ticket";

    Assert.assertEquals(actualBookTicketPageHeader, expectedBookTicketPageHeader, "Success message does not display");
    Assert.assertTrue(bookTicketPage.isDepartStationSelected(departStation), "Depart Station is not correct");
    Assert.assertTrue(bookTicketPage.isArriveStationSelected(arriveAt) , "Arrive At is not display");
  }
}
