package test_cases;

import common.constant.Constant;
import common.helper.Helper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    JavascriptExecutor js;
    ChromeOptions chromeOptions;

    @BeforeTest
    public void beforeTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", Helper.getProjectPath() + "/src/main/resources/Executables/chromedriver.exe");
        chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        Constant.WEBDRIVER = new ChromeDriver(chromeOptions);
        Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        js = (JavascriptExecutor) Constant.WEBDRIVER;
    }
    @AfterTest
    public void afterTest() throws  IOException{
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }


}