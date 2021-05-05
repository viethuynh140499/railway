package common.helpers;

import org.openqa.selenium.Alert;

public class AlertHelper {
    public static void handleAlert(boolean action) {
        Alert alert = BrowserHelper.getDriver().switchTo().alert();
        if (action)
            alert.accept();
        else
            alert.dismiss();
    }
}
