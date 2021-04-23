package page_objects;

import common.helpers.element.Label;
import common.helpers.element.Link;
import common.helpers.element.Tab;
import org.openqa.selenium.By;

public class General {
    private final Tab tabLogin = new Tab(By.cssSelector("a[href$='Login.cshtml'] span"));
    private final Tab tabRegister = new Tab(By.cssSelector("a[href$='Register.cshtml'] span"));
    private final Tab tabFAQ = new Tab(By.cssSelector("a[href$='FAQ.cshtml'] span"));
    private final Tab tabTimetable = new Tab(By.cssSelector("a[href$='TrainTimeListPage.cshtml'] span"));
    private final Tab tabContact = new Tab(By.cssSelector("a[href$='Contact.cshtml'] span"));
    private final Tab tabBookTicket = new Tab(By.cssSelector("a[href$='BookTicketPage.cshtml'] span"));
    private final Tab tabTicketPrice = new Tab(By.cssSelector("a[href$='TrainPriceListPage.cshtml'] span"));
    private final Tab tabHome = new Tab(By.cssSelector(".selected a span"));
    private final Link linkRegister = new Link(By.cssSelector("#content a[href$='Register.cshtml']"));
    public final Label lblWelcomeMessage = new Label(By.cssSelector(".account strong"));
    public final Tab tabLogout = new Tab(By.cssSelector("a[href*=Logout]"));

    public void clickTabLogin() {
        this.tabLogin.click();
    }

    public void clickTabRegister() {
        this.tabRegister.click();
    }

    public void clickTabFAQ() {
        this.tabFAQ.click();
    }

    public void clickTabTimetable() {
        this.tabTimetable.click();
    }

    public void clickTabContact() {
        this.tabContact.click();
    }

    public void clickTabBookTicket() {
        this.tabBookTicket.click();
    }

    public void clickTabTicketPrice() {
        this.tabTicketPrice.click();
    }

    public void clickTabHome() {
        this.tabHome.click();
    }

    public void clickLinkRegister() {
        this.linkRegister.click();
    }

    public void clickTabLogout(){
        this.tabLogout.click();
    }


    public String getWelcomeMessage() {
       return this.lblWelcomeMessage.getText();
    }

    public void goToBookTicketPage() {
        clickTabBookTicket();
    }

    public void goToLoginPage() {
        clickTabLogin();
    }

    public void goToRegisterPage(){
        clickTabRegister();
    }

    public void logout() {
        this.clickTabLogout();
        this.clickTabLogin();
    }

}
