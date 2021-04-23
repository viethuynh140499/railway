package page_objects;

import common.helpers.element.Label;
import org.openqa.selenium.By;

public class SuccessfullyRegister {

  private final Label lblSuccessfully = new Label(By.cssSelector("#content p"));

  public String  getTxtSuccessfully(){
    return this.lblSuccessfully.getText();
  }
}
