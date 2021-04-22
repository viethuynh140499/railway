package driver_manager;

import common.constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        Constant.WEBDRIVER = new ChromeDriver(options);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
    }
}
