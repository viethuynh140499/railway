package page_objects;

import common.element.Button;
import common.element.DropDown;
import common.element.Label;
import common.helpers.BrowserHelper;
import model.Ticket;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {

  private final DropDown sltDate = new DropDown(By.name("Date"));
  private final DropDown sltDepartFrom = new DropDown(By.name("DepartStation"));
  private final DropDown sltArriveAt = new DropDown(By.name("ArriveStation"));
  private final DropDown sltSeatType = new DropDown(By.name("SeatType"));
  private final DropDown sltTicketAmount = new DropDown(By.name("TicketAmount"));
  private final Button btnBookTicket = new Button(By.cssSelector("form input"));
  private final Label lblPageHeader = new Label(By.cssSelector("form input"));
  private final String dynamicTableCell = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";

  public String getPageHeader() {
    return this.lblPageHeader.getText();
  }

  public String getTableCellValue(String header) {
    return BrowserHelper.findElement(By.xpath(String.format(dynamicTableCell, header))).getText();
  }

  public void bookTicket(Ticket ticket) {
    this.sltDate.scrollToView();
    this.sltDate.selectDropdownOptionByText(ticket.getDepartDate());
    this.sltDepartFrom.selectDropdownOptionByText(ticket.getDepartFrom());
    this.sltSeatType.selectDropdownOptionByText(ticket.getSeatType());
    this.sltTicketAmount.selectDropdownOptionByText(ticket.getTicketAmount());
    this.sltArriveAt.selectDropdownOptionByText(ticket.getArriveAt());
    this.btnBookTicket.click();
  }
}
