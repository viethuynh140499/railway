package page_objects;

import common.element.Label;
import common.element.Tab;
import org.openqa.selenium.By;

public class GeneralPage {
    private final Tab tabLogin = new Tab(By.cssSelector("li a[href$='Login.cshtml']"));
    private final Tab tabRegister = new Tab(By.cssSelector("li a[href$='Register.cshtml']"));
    private final Tab tabBookTicket = new Tab(By.cssSelector("li a[href$='BookTicketPage.cshtml'"));
    private final Tab tabMyTicket = new Tab(By.cssSelector("li a[href$='ManageTicket.cshtml']"));
    private final Tab tabChangePassword = new Tab(By.cssSelector("li a[href$='ChangePassword.cshtml']"));
    private final Tab tabTrainTimetable = new Tab(By.cssSelector("li a[href$='TrainTimeListPage.cshtml']"));
    private final Tab tabLogout = new Tab(By.cssSelector("li a[href*=Logout]"));
    private final Label lblWelcomeMessage = new Label(By.className("account"));
    private final Label lblPageName = new Label(By.cssSelector("#content h1"));

    public void clickTrainTimetableTab() {
        this.tabTrainTimetable.click();
    }

    public void clickLoginTab() {
        this.tabLogin.click();
    }

    public void clickBookTicket() {
        this.tabBookTicket.click();
    }

    public String getWelcomeMessage() {
        return this.lblWelcomeMessage.getText();
    }

    public void clickRegisterTab() {
        this.tabRegister.click();
    }

    public void clickMyTicketTab() {
        this.tabMyTicket.click();
    }

    public void clickLogoutTab() {
        this.tabLogout.click();
    }

    public void clickChangePasswordTab() {
        this.tabChangePassword.click();
    }

    public boolean isMyTicketTabDisplayed() {
        return tabMyTicket.isDisplayed();
    }

    public boolean isChangePasswordTabDisplayed() {
        return tabChangePassword.isDisplayed();
    }

    public boolean isLogOutTabDisplayed() {
        return tabLogout.isDisplayed();
    }

    public String getPageHeader() {
        return this.lblPageName.getText();
    }
}
