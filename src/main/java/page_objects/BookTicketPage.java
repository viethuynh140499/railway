package page_objects;

import common.element.Button;
import common.element.DropDown;
import common.element.Label;
import common.helpers.BrowserHelper;
import model.Ticket;
import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {

    private final DropDown sltDate = new DropDown(By.cssSelector("[name=Date]"));
    private final DropDown sltDepartFrom = new DropDown(By.cssSelector("[name=DepartStation]"));
    private final DropDown sltArriveAt = new DropDown(By.cssSelector("[name=ArriveStation]"));
    private final DropDown sltSeatType = new DropDown(By.cssSelector("[name=SeatType]"));
    private final DropDown sltTicketAmount = new DropDown(By.cssSelector("[name=TicketAmount]"));
    private final Button btnBookTicket = new Button(By.cssSelector("form input"));
    private final Label lblPageHeader = new Label(By.cssSelector("#content>h1"));
    private final String dynamicTableCell = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";


    public void bookTicket(Ticket ticket) {
        this.sltDate.scrollToView();
        this.sltDate.selectDropdownOptionByText(ticket.getDepartDate());
        this.sltDepartFrom.selectDropdownOptionByText(ticket.getDepartFrom());
        this.sltSeatType.selectDropdownOptionByText(ticket.getSeatType());
        this.sltTicketAmount.selectDropdownOptionByText(ticket.getTicketAmount());
        this.sltArriveAt.selectDropdownOptionByText(ticket.getArriveAt());
        this.btnBookTicket.click();
    }

    public String getPageHeader() {
        return this.lblPageHeader.getText();
    }

    public String getTableCellValue(String header) {
        return BrowserHelper.findElement(By.xpath(String.format(dynamicTableCell, header))).getText();
    }

    public boolean isDepartStationSelected(String departStation) {
        return sltDepartFrom.getSelectedOptionAsText().equals(departStation);
    }

    public boolean isArriveStationSelected(String arriveStation) {
        return sltArriveAt.getSelectedOptionAsText().equals(arriveStation);
    }
}
