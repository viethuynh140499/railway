package common.element;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BaseElement {
  public DropDown(By locator) {
    super(locator);
  }

  public void selectDropdownOptionByText(String text) {
    Select dropdown = new Select(findElement());
    dropdown.selectByVisibleText(text);
  }

  public void selectDropdownOptionByIndex(int index) {
    Select dropdown = new Select(findElement());
    dropdown.selectByIndex(index);
  }
}
