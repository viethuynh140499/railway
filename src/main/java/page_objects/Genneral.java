package page_objects;

import common.constant.Constant;
import common.helper.element.Label;
import common.helper.element.Link;
import common.helper.element.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Genneral {
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

    public void getTabLogin() {
        this.tabLogin.click();
    }

    public void getTabRegister() {
        this.tabRegister.click();
    }

    public void getTabFAQ() {
        this.tabFAQ.click();
    }

    public void getTabTimetable() {
        this.tabTimetable.click();
    }

    public void getTabContact() {
        this.tabContact.click();
    }

    public void getTabBookTicket() {
        this.tabBookTicket.click();
    }

    public void getTabTicketPrice() {
        this.tabTicketPrice.click();
    }

    public void getTabHome() {
        this.tabHome.click();
    }

    public void getLinkRegister() {
        this.linkRegister.click();
    }

    public void getTabLogout(){
        this.tabLogout.click();
    }


    public String getWelcomeMessage() {
       return this.lblWelcomeMessage.getText();
    }

    public void goToBookTicketPage() {
        getTabBookTicket();
    }

    public void goToLoginPage() {
        getTabLogin();
    }

    public void logout() {
        this.getTabLogout();
        this.getTabLogin();
    }

}
