package common.helpers.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown extends BaseElement {
  public SelectDropdown(By locator) {
    super(locator);
  }

  public void selectDropdowOptionByText(String text) {
    Select dropdown = new Select(findElement());
    dropdown.selectByVisibleText(text);
  }

  public void selectDropdowOptionByIndex(int index) {
    Select dropdown = new Select(findElement());
    dropdown.selectByIndex(index);
  }
}
