import common.Utilities;
import constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    JavascriptExecutor js;
    ChromeOptions chromeOptions;

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("pre-condition");
        // chrome of linux
        //System.setProperty("webdriver.chrome.driver", Utilities.getProjectpath() + "/src/main/Executables/chromedriver");
        // chrome of windown
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectpath() + "/src/main/Executables/chromedriver.exe");
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


    @Test
    public void TC01() {
        System.out.println("TC01 - User can login to Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        js.executeScript("window.scrollBy(0,500)");
        loginPage.HomePage(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login to Railway with invalid username and password ");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        js.executeScript("window.scrollBy(0,500)");
        loginPage.LoginPage(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = homePage.getWelcomeMessage();
        String expectedMsg = Constant.ERRORMESSAGE;
        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("TC02 - User can't login to Railway with invalid username");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        js.executeScript("window.scrollBy(0,500)");
        String actualMsg = loginPage.usernameInvalid(Constant.USERNAMEINVALD).getErrorEnterUsername();
        String expectedMsg = Constant.USERNAMEINVALD;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("TC02 - User can't login to Railway with invalid password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        js.executeScript("window.scrollBy(0,500)");
        String actualMsg = loginPage.passwordInvalid(Constant.PASSWORDINVALD).getErrorEnterPassword();
        String expectedMsg = Constant.PASSWORDINVALD;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
