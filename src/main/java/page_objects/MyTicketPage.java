package page_objects;

import common.element.Button;
import common.element.DropDown;
import common.element.TextBox;
import common.helpers.AlertHelper;
import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {
  private final DropDown sltDepartStation = new DropDown(By.cssSelector("[name='FilterDpStation']"));
  private final DropDown sltArriveAt = new DropDown(By.cssSelector("[name='FilterArStation']"));
  private final TextBox txtDepartDate = new TextBox(By.cssSelector("[name='FilterDpDate']"));
  private final DropDown sltStatus = new DropDown(By.cssSelector("[name='FilterStatus']"));
  private final Button btnApplyFilter = new Button(By.cssSelector("div input[type=submit]"));
  private final Button btnCancelTicket = new Button(By.cssSelector("[value=Cancel]"));
  private final Button btnDeleteTicket = new Button(By.cssSelector("[value=Delete]"));

  public void cancelAllTicket() {
    int size = this.btnCancelTicket.findElements().size();
    for (int i = 0; i < size; i++) {
      this.btnCancelTicket.scrollToView();
      this.btnCancelTicket.click();
      AlertHelper.handleAlert(true);
    }
  }

  public void deleteAllTicket() {
    int size = this.btnDeleteTicket.findElements().size();
    for (int i = 0; i < size; i++) {
      this.btnDeleteTicket.scrollToView();
      this.btnDeleteTicket.click();
      AlertHelper.handleAlert(true);
    }
  }

//  public void findTicket(String departStation, String arriveAt, String departDate, String status) {
//    this.sltDepartStation.selectDropdownOptionByText(departStation);
//    this.sltArriveAt.selectDropdownOptionByText(arriveAt);
//    this.txtDepartDate.enterText(departDate);
//    this.sltStatus.selectDropdownOptionByText(status);
//    this.btnApplyFilter.submit();
//  }

  public void findTicket(String status) {
    this.sltStatus.selectDropdownOptionByText(status);
    this.btnApplyFilter.submit();
  }
}
