import org.openqa.selenium.By;

public class SuccessPage extends Genneral {
    private final By rowDepartStation = By.xpath("//tbody/tr/td[" + goToBookTicketPage().getSltDepartFrom() + "]");
    private final By rowArriveAt = By.xpath("//tbody/tr/td[" + goToBookTicketPage().getSltArriveAt() + "]");
    private final By rowSeatType = By.xpath("//tbody/tr/td[" + goToBookTicketPage().getSltSeatType() + "]");
    private final By rowDepartDate = By.xpath("//tbody/tr/td[" + goToBookTicketPage().getCurrentBookingDate() + "]");

}
