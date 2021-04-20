package test_cases;

import common.helper.Helper;
import common.constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BookTicketTest {
    JavascriptExecutor js;
    ChromeOptions chromeOptions;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("pre-condition");
        //System.setProperty("webdriver.chrome.driver", Utilities.getProjectpath() + "/src/main/Executables/chromedriver");
        System.setProperty("webdriver.chrome.driver", Helper.getProjectPath() + "/src/main/Executables/chromedriver.exe");
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        Constant.WEBDRIVER = new ChromeDriver(chromeOptions);
        Constant.WEBDRIVER.manage().window().maximize();
        js = (JavascriptExecutor) Constant.WEBDRIVER;
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

//    @Test
//    public void TC01() {
//        System.out.println("TC01 - User can log into Railway with valid username and password");
//        HomePage homePage = new HomePage();
//        homePage.open();
//        LoginPage loginPage = homePage.goToLoginPage();
//        js.executeScript("window.scrollBy(0,250)");
//        loginPage.LoginPage(Constant.USERNAME, Constant.PASSWORD);
//        BookTicketPage bookTicketPage = homePage.goToBookTicketPage();
//        js.executeScript("window.scrollBy(0,500)");
//        bookTicketPage.SuccessPage(Constant.DEPART_DATE,Constant.DEPART_FROM,Constant.ARRIVE_AT,Constant.SEAT_TYPE,Constant.TICKET_AMOUNT,Constant.CURRENT_DATE);
//
//    }
}

