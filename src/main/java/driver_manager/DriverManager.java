package driver_manager;

import common.constant.Constant;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected abstract void createWebDriver();

    public void quitWebDriver() {
        if (null != Constant.WEBDRIVER) {
            Constant.WEBDRIVER.quit();
            Constant.WEBDRIVER = null;
        }
    }

    public WebDriver getWebDriver() {
        if (null == Constant.WEBDRIVER) {
            createWebDriver();
        }
        return Constant.WEBDRIVER;
    }
}
