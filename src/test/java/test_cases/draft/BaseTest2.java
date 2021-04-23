package test_cases.draft;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import common.constant.Constant;
import common.helper.Helper;
import driver_manager.DriverManagerFactory;
import driver_manager.DriverType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest2 {
  private ExtentHtmlReporter htmlReporter;
  private ExtentReports extent;
  private ExtentTest logger;

  @BeforeTest
  public void startReport() {
    htmlReporter = new ExtentHtmlReporter(Helper.getProjectPath() + "/src/test/resources/test-output/STMExtentReport.html");
    // Create an object of Extent Reports
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Host Name", "SoftwareTestingMaterial");
    extent.setSystemInfo("Environment", "Production");
    extent.setSystemInfo("User Name", "Rajkumar SM");
    htmlReporter.config().setDocumentTitle("Title of the Report Comes here ");
    // Name of the report
    htmlReporter.config().setReportName("Name of the Report Comes here ");
    // Dark Theme
    htmlReporter.config().setTheme(Theme.STANDARD);
  }

  //This method is to capture the screenshot and return the path of the screenshot.
  public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
    String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    // after execution, you could see a folder "FailedTestsScreenshots" under src folder
    String destination = Helper.getProjectPath() + "/src/test/resources/screen_shot/" + screenshotName + dateName + ".png";
    File finalDestination = new File(destination);
    FileUtils.copyFile(source, finalDestination);
    return destination;
  }

  @BeforeMethod
  public void setup() {
    Constant.DRIVER_MANAGER = DriverManagerFactory.getDriverManager(DriverType.CHROME);
    Constant.WEB_DRIVER = Constant.DRIVER_MANAGER.getWebDriver();
  }

  @AfterMethod
  public void getResult(ITestResult result) throws Exception {
    if (result.getStatus() == ITestResult.FAILURE) {
      //MarkupHelper is used to display the output in different colors
      logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
      logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
      //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
      //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
      //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
      String screenshotPath = getScreenShot(Constant.WEB_DRIVER, result.getName());
      //To add it in the extent report
      logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
    } else if (result.getStatus() == ITestResult.SKIP) {
      logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
    } else if (result.getStatus() == ITestResult.SUCCESS) {
      logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
    }
  }

  @AfterTest
  public void endReport() {
    extent.flush();
  }
}
