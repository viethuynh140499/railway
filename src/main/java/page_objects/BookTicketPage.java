package page_objects;

import common.element.Button;
import common.element.DropDown;
import common.element.Label;
import common.helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage {
  private final DropDown sltDate = new DropDown(By.cssSelector("[name=Date]"));
  private final DropDown sltDepartFrom = new DropDown(By.cssSelector("[name=DepartStation]"));
  private final DropDown sltArriveAt = new DropDown(By.cssSelector("[name=ArriveStation]"));
  private final DropDown sltSeatType = new DropDown(By.cssSelector("[name=SeatType]"));
  private final DropDown sltTicketAmount = new DropDown(By.cssSelector("[name=TicketAmount]"));
  private final Button btnBookTicket = new Button(By.cssSelector("[type=submit]"));
  private final Label lblSuccessfullyMessage = new Label(By.cssSelector("[align='center']"));
  private final String dynamicTableCell = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";
  public String getSuccessfullyMessage() {
    return this.lblSuccessfullyMessage.getText();
  }

  public void bookTicket(String date, String departFrom, String seatType, int ticketAmount, String arriveAt) {
    this.sltDate.selectDropdownOptionByText(date);
    this.sltDepartFrom.selectDropdownOptionByText(departFrom);
    this.sltSeatType.selectDropdownOptionByText(seatType);
    this.sltTicketAmount.selectDropdownOptionByIndex(ticketAmount);
    this.sltArriveAt.selectDropdownOptionByText(arriveAt);
    this.btnBookTicket.submit();
  }

  public WebElement getTdTextByHeader(String header){
    return BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicTableCell, header)));
  }

  public String getTextByHead(String header){
    return getTdTextByHeader(header).getText();
  }
}
