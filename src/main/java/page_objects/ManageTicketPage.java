package page_objects;

import common.element.Button;
import common.element.DropDown;
import common.element.TextBox;
import common.helpers.BrowserHelper;
import org.openqa.selenium.By;

public class ManageTicketPage {
  private final DropDown sltDepartStation = new DropDown(By.cssSelector("[name='FilterDpStation']"));
  private final DropDown sltArriveAt = new DropDown(By.cssSelector("[name='FilterArStation']"));
  private final TextBox txtDepartDate = new TextBox(By.cssSelector("[name='FilterDpDate']"));
  private final DropDown sltStatus = new DropDown(By.cssSelector("[name='FilterStatus']"));
  private final Button btnApplyFilter = new Button(By.cssSelector("div input[type=submit]"));
  private final Button btnCancelTicket = new Button(By.cssSelector("[value=Cancel]"));
  private final Button btnDeleteTicket = new Button(By.cssSelector("[value=Delete]"));

  public void cancelTicket() {
    this.btnCancelTicket.click();
    BrowserHelper.getDriver().switchTo().alert().accept();
  }

  public void deleteTicket() {
    this.btnDeleteTicket.click();
    BrowserHelper.getDriver().switchTo().alert().accept();
  }


  public void findTicket(String departStation, String arriveAt, String departDate, String status) {
    this.sltDepartStation.selectDropdownOptionByText(departStation);
    this.sltArriveAt.selectDropdownOptionByText(arriveAt);
    this.txtDepartDate.enterText(departDate);
    this.sltStatus.selectDropdownOptionByText(status);
    this.btnApplyFilter.submit();
  }
}
