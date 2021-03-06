package page_objects;

import common.element.BaseElement;
import common.element.Button;
import common.element.Label;
import model.Ticket;
import org.openqa.selenium.By;


public class MyTicketPage extends GeneralPage {


    String dynamicButtonCancel = "//tr/td[text()='%s']/../td[text()='%s']/../td[text()='%s']";

    private final Label lblerrorMessage = new Label(By.className("error"));
    private Button btnCancel;


    private String getTicketValue(Ticket ticket) {
        return String.format(this.dynamicButtonCancel, ticket.getDepartFrom(),
                ticket.getArriveAt(), ticket.getStatus());
    }

    public void cancelTicket(Ticket ticket) {
        btnCancel = new Button(By.xpath(getTicketValue(ticket)));
        btnCancel.scrollToView();
        btnCancel.click();
    }

    public boolean doesTicketDisplay(Ticket ticket) {
        return BaseElement.doesElementExist(By.xpath(getTicketValue(ticket)));
    }

    public boolean isErrorMessageDisplayed() {
        return lblerrorMessage.isDisplayed();
    }

}
