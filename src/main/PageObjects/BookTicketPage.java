import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class BookTicketPage extends Genneral{

    public final By sltDepartDate = By.cssSelector("[name='Date']");
    public final By sltDepartFrom = By.cssSelector("[name='DepartStation']");
    public final By sltArriveAt = By.cssSelector("[name='ArriveStation']");
    public final By sltSeatType = By.cssSelector("[name='SeatType']");
    public final By sltTicketAmount = By.cssSelector("[name='TicketAmount']");
    public final By btnBookTicket = By.cssSelector("[value='Book ticket']");
    public final By lblErrorMessage = By.cssSelector("[align$='left'] p");
    public final By lblErrorMessageTicketAmount = By.cssSelector(".validation-error");


    public WebElement getSltDepartDate() {
        return Constant.WEBDRIVER.findElement(sltDepartDate);
    }

    public WebElement getSltDepartFrom() {
        return Constant.WEBDRIVER.findElement(sltDepartFrom);
    }

    public WebElement getSltArriveAt() {
        return Constant.WEBDRIVER.findElement(sltArriveAt);
    }

    public WebElement getSltSeatType() {
        return Constant.WEBDRIVER.findElement(sltSeatType);
    }

    public WebElement getSltTicketAmount() {
        return Constant.WEBDRIVER.findElement(sltTicketAmount);
    }

    public WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    public WebElement getLblErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblErrorMessage);
    }

    public WebElement getLblErrorMessageTicketAmount() {
        return Constant.WEBDRIVER.findElement(lblErrorMessageTicketAmount);
    }

    public SuccessPage bookTicket(String departDate, String departFrom, String arriveAt, String seatType, int ticketAmount){

        Select sltDepartDate = new Select(this.getSltDepartDate().findElement(By.name("ArriveStation")));
        Select sltDepartFrom = new Select(this.getSltDepartFrom().findElement(By.name("DepartStation")));
        Select sltArriveAt = new Select(this.getSltArriveAt().findElement(By.name("ArriveStation")));
        Select sltSeatType = new Select(this.getSltSeatType().findElement(By.name("SeatType")));
        Select sltTicketAmount = new Select(this.getSltTicketAmount().findElement(By.name("TicketAmount")));
        this.getBtnBookTicket().click();

        return new SuccessPage();
    }
}
