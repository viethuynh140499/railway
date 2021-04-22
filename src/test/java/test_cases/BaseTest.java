package test_cases;

import common.constant.Constant;
import common.helper.Helper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    JavascriptExecutor js;
    ChromeOptions chromeOptions;

    @BeforeMethod
    public void beforeTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", Helper.getProjectPath() + "/src/main/resources/Executables/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", Helper.getProjectPath() + "/src/main/resources/Executables/chromedriver");
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        Constant.WEBDRIVER = new ChromeDriver(chromeOptions);
        Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = (JavascriptExecutor) Constant.WEBDRIVER;

    }

    @AfterMethod
    public void afterTest() throws IOException {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }


}