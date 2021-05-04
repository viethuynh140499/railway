package page_objects;

import common.element.Label;
import common.element.Tab;
import org.openqa.selenium.By;

public class GeneralPage {
  private final Tab tabLogin = new Tab(By.cssSelector("li a[href$='Login.cshtml']"));
  private final Label lblWelcomeMessage = new Label(By.cssSelector(".account"));
  private final Tab tabBookTicket = new Tab(By.cssSelector("li a[href$='BookTicketPage.cshtml'"));


  public void clickLoginTab() {
    this.tabLogin.click();
  }

  public void clickBookTicket() {
    this.tabBookTicket.click();
  }

  public String getWelcomeMessage() {
    return this.lblWelcomeMessage.getText();
  }
}
