package driver_manager;

import common.constant.Constant;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected abstract void createWebDriver();

    public void quitWebDriver() {
        if (null != Constant.WEB_DRIVER) {
            Constant.WEB_DRIVER.quit();
            Constant.WEB_DRIVER = null;
        }
    }

    public WebDriver getWebDriver() {
        if (null == Constant.WEB_DRIVER) {
            createWebDriver();
        }
        return Constant.WEB_DRIVER;
    }
}
