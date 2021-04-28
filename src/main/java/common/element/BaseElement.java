package common.element;

import common.helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {
  private final By locator;

  public BaseElement(By locator) {
    this.locator = locator;
  }

  public WebElement findElement() {
    return BrowserHelper.getDriver().findElement(locator);
  }

  public List<WebElement> findElements() {
    return BrowserHelper.getDriver().findElements(locator);
  }

  public void click() {
    findElement().click();
  }

  public void submit() {
    findElement().submit();
  }

  public String getText() {
    return findElement().getText();
  }

}
