package page_objects;

import common.element.Button;
import common.element.DropDown;
import common.element.Label;
import common.element.TextBox;
import common.helpers.AlertHelper;
import model.Ticket;
import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {
    private final DropDown sltDepartStation = new DropDown(By.cssSelector("[name='FilterDpStation']"));
    private final DropDown sltArriveAt = new DropDown(By.cssSelector("[name='FilterArStation']"));
    private final TextBox txtDepartDate = new TextBox(By.cssSelector("[name='FilterDpDate']"));
    private final DropDown sltStatus = new DropDown(By.cssSelector("[name='FilterStatus']"));
    private final Button btnApplyFilter = new Button(By.cssSelector("div input[type=submit]"));
    private final Button btnCancelTicket = new Button(By.cssSelector("[value=Cancel]"));
    private final Button btnDeleteTicket = new Button(By.cssSelector("[type=button]"));
    private final Label lblFilterErrorMessage = new Label(By.cssSelector(".Filter span:first-child"));
    private final Label lblErrorMessage = new Label(By.cssSelector(".error"));
    private final Label lblNoteMessage = new Label(By.cssSelector(".message li"));
    private final Label tblFilter = new Label(By.cssSelector(".Filter table"));

    public String filterErrorMessage() {
        return this.lblFilterErrorMessage.getText();
    }

    public String errorMessage() {
        return this.lblErrorMessage.getText();
    }

    public String noteMessage() {
        return this.lblNoteMessage.getText();
    }

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


    public void findTicket(Ticket ticket) {
        if (!this.tblFilter.findElement().isDisplayed())
        this.sltDepartStation.selectDropdownOptionByText(ticket.getDepartFrom());
        this.sltArriveAt.selectDropdownOptionByText(ticket.getArriveAt());
        this.txtDepartDate.enterText(ticket.getDepartDate());
        this.sltStatus.selectDropdownOptionByText(ticket.getStatus());
        this.btnApplyFilter.submit();
    }
}

