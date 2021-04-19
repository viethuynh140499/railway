import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;

public class BookTicketPage extends Genneral {

    private final By sltDepartDate = By.cssSelector("[name='Date']");
    private final By sltDepartFrom = By.cssSelector("[name='DepartStation']");
    private final By sltArriveAt = By.cssSelector("[name='ArriveStation']");
    private final By sltSeatType = By.cssSelector("[name='SeatType']");
    private final By sltTicketAmount = By.cssSelector("[name='TicketAmount']");
    private final By btnBookTicket = By.cssSelector("[value='Book ticket']");
    private final By lblErrorMessage = By.cssSelector("[align$='left'] p");
    private final By lblErrorMessageTicketAmount = By.cssSelector(".validation-error");


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

    public LocalDate getCurrentBookingDate() {
        return LocalDate.now();
    }


    public void SuccessPage(String departDate, String departFrom, String arriveAt, String seatType, int ticketAmount, LocalDate currentBookingDate) {
        Select sltDepartDate = new Select(this.getSltDepartDate());
        sltDepartDate.selectByVisibleText("4/25/2021");
        Select sltDepartFrom = new Select(this.getSltDepartFrom());
        sltDepartFrom.selectByVisibleText("Đà Nẵng");
        Select sltArriveAt = new Select(this.getSltArriveAt());
        sltArriveAt.selectByVisibleText("Quảng Ngãi");
        Select sltSeatType = new Select(this.getSltSeatType());
        sltSeatType.selectByVisibleText("Soft seat");
        Select sltTicketAmount = new Select(this.getSltTicketAmount());
        sltTicketAmount.selectByValue(String.valueOf(2));


        this.getBtnBookTicket().click();

//        return new SuccessPage();
    }
}
