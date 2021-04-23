package driver_manager;

import common.constant.Constant;

public class DriverManagerFactory {
  public static DriverManager getDriverManager(DriverType type) {

    switch (type) {
      case CHROME:
        Constant.DRIVER_MANAGER = new ChromeDriverManager();
        break;
//      default:
//        Constant.DRIVERMANAGER = new ChromeDriverManager();
//        break;
    }
    return Constant.DRIVER_MANAGER;
  }
}

