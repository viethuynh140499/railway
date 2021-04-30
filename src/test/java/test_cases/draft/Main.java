package test_cases.draft;

import common.helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BrowserHelper.startBrowser(BrowserHelper.DriverType.CHROME);
        try {
            BrowserHelper.getDriver().get("https://example.com");
            // Get all the elements available with tag name 'p'
            List<WebElement> elements = BrowserHelper.getDriver().findElements(By.tagName("p"));
            for (WebElement element : elements) {
                System.out.println("Paragraph text:" + element.getText());
            }
        } finally {
            BrowserHelper.getDriver().quit();
        }
    }
}


