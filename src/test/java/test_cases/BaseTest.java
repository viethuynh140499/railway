package test_cases;

import common.helpers.BrowserHelper;
import common.helpers.Constant;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
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