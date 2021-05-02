package test_cases;

import common.helpers.BrowserHelper;
import common.helpers.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page_objects.*;

public class BaseTest {
    protected static HomePage homePage = new HomePage();
    protected static LoginPage loginPage = new LoginPage();
    protected static BookTicketPage bookTicketPage = new BookTicketPage();
    protected static RegisterPage registerPage = new RegisterPage();
    protected static ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    protected static MyTicketPage manageTicket = new MyTicketPage();

    @BeforeMethod
    public void setup() {
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        BrowserHelper.navigateToUrl(Constant.RAILWAY_URL);
    }

    @AfterMethod
    public void afterTest() {
        System.out.println("Post-condition");
        BrowserHelper.quitBrowser();
    }
}