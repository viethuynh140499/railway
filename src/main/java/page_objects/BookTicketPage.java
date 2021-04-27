package page_objects;

import common.helpers.element.Button;
import common.helpers.element.DropDown;
import org.openqa.selenium.By;

public class BookTicketPage {
  private final DropDown sltDate = new DropDown(By.cssSelector("[name=Date]"));
  private final DropDown sltDepartFrom = new DropDown(By.cssSelector("[name=DepartStation]"));
  private final DropDown sltArriveAt = new DropDown(By.cssSelector("[name=ArriveStation]"));
  private final DropDown sltSeatType = new DropDown(By.cssSelector("[name=SeatType]"));
  private final DropDown sltTicketAmount = new DropDown(By.cssSelector("[name=TicketAmount]"));
  private final Button btnBookTicket = new Button(By.cssSelector("[type=submit]"));

  public void bookTicket(String date, String departFrom, String arriveAt, String seatType, int ticketAmount){
    this.sltDate.selectDropdownOptionByText(date);
    this.sltDepartFrom.selectDropdownOptionByText(departFrom);
    this.sltArriveAt.selectDropdownOptionByText(arriveAt);
    this.sltSeatType.selectDropdownOptionByText(seatType);
    this.sltTicketAmount.selectDropdownOptionByIndex(ticketAmount);
    this.btnBookTicket.submit();
  }
}
