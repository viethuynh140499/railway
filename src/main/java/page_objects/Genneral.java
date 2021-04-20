package page_objects;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Genneral {
    public final By tabLogin = By.cssSelector("a[href$='Login.cshtml'] span");
    public final By tabRegister = By.cssSelector("a[href$='Register.cshtml'] span");
    public final By tabFAQ = By.cssSelector("a[href$='FAQ.cshtml'] span");
    public final By tabTimetable = By.cssSelector("a[href$='TrainTimeListPage.cshtml'] span");
    public final By tabContact = By.cssSelector("a[href$='Contact.cshtml'] span");
    public final By tabBookTicket = By.cssSelector("a[href$='BookTicketPage.cshtml'] span");
    public final By tabTicketPrice = By.cssSelector("a[href$='TrainPriceListPage.cshtml'] span");
    public final By tabHome = By.cssSelector(".selected a span");
    public final By linkRegister = By.cssSelector("#content a[href$='Register.cshtml'] ");
    public final By lblWelcomeMessage = By.cssSelector(".account strong");



    public WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    public WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    public WebElement getTabFAQ() {
        return Constant.WEBDRIVER.findElement(tabFAQ);
    }

    public WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    public WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    public WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    public WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    public WebElement getTabHome() {
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    public WebElement getLinkRegister() {
        return Constant.WEBDRIVER.findElement(linkRegister);
    }

    public WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }



    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void goToBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public LoginPage goToLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }
}
