package test_cases.draft;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

  public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("http://www.google.com");
  }

}
