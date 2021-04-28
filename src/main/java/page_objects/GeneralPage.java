package page_objects;

import common.element.Label;
import common.element.Tab;
import org.openqa.selenium.By;

public class GeneralPage {
    private final Tab tabLogin = new Tab(By.cssSelector("a[href$='Login.cshtml'] span"));
    private final Tab tabRegister = new Tab(By.cssSelector("a[href$='Register.cshtml'] span"));
    private final Tab tabBookTicket = new Tab(By.cssSelector("a[href$='BookTicketPage.cshtml'] span"));
    private final Label lblWelcomeMessage = new Label(By.cssSelector(".account strong"));
    private final Tab tabLogout = new Tab(By.cssSelector("a[href*=Logout]"));
    private final Tab tabMyTicket = new Tab(By.cssSelector("a[href$='ManageTicket.cshtml'] span"));

    public void clickLoginTab() {
        this.tabLogin.click();
    }

    public void clickRegisterTab() {
        this.tabRegister.click();
    }

    public void clickBookTicketTab() {
        this.tabBookTicket.click();
    }

    public String getWelcomeMessage() {
        return this.lblWelcomeMessage.getText();
    }

    public void clickMyTicketTab() {
        this.tabMyTicket.click();
    }

    public void clickLogoutTab() {
        this.tabLogout.click();
    }

}
