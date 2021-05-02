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
    private final Button btnBookTicket = new Button(By.cssSelector("[type=submit]"));
    private final Label lblSuccessfullyMessage = new Label(By.cssSelector("[align='center']"));
    private final Label lblTicketAmountErrorMessage = new Label(By.cssSelector("li .validation-error"));
    private final String dynamicTableCell = "//table/tbody/tr/td[count(//table/tbody/tr/th[.='%s']/preceding-sibling::th)+1]";
    private final Label lblErrorMessage = new Label(By.cssSelector(".message"));

    public String getSuccessfullyMessage() {
        return this.lblSuccessfullyMessage.getText();
    }

    public String getTableCellValue(String header) {
        /*return BrowserHelper.getDriver().findElement(By.xpath(String.format(dynamicTableCell, header))).getText();*/
        return BrowserHelper.findElement(By.xpath(String.format(dynamicTableCell, header))).getText();
    }

    public String getTicketAmountErrorMessage() {
        return this.lblTicketAmountErrorMessage.getText();
    }

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public void bookTicket(Ticket ticket) {
        this.sltDate.scrollToView();
        this.sltDate.selectDropdownOptionByText(ticket.getDepartDate());
        this.sltDepartFrom.selectDropdownOptionByText(ticket.getDepartFrom());

        this.sltSeatType.selectDropdownOptionByText(ticket.getSeatType());
        this.sltTicketAmount.selectDropdownOptionByText(ticket.getTicketAmount());
        try {
            this.sltArriveAt.selectDropdownOptionByText(ticket.getArriveAt());
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            this.sltArriveAt.selectDropdownOptionByText(ticket.getArriveAt());
        }
        this.btnBookTicket.click();
    }
}
