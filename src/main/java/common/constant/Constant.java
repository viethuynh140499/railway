package common.constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway.somee.com/";
    public static final String DATA_PATH = "/src/test/resources/data/";
    public static ChromeOptions CHROME_OPTIONS;
    public static InternetExplorerOptions INTERNET_OPTIONS;
    public static FirefoxOptions FIREFOX_OPTIONS;
}
