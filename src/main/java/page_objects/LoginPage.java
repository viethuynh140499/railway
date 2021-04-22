package page_objects;

import common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends Genneral {
    public final By txtEmail = By.cssSelector("[id$=username]");
    public final By txtPassword = By.cssSelector("[id$=password]");
    public final By btnLogin = By.cssSelector("[title='Login']");
    public final By lblErrorMessage = By.cssSelector("p[class*='error']");
    public final By lblErrorUsername = By.cssSelector("[for$='username']");
    public final By lblErrorPassword = By.cssSelector("[for$='password']");
    public final By linkRegister = By.cssSelector("a[href$='Register.cshtml']");
    public final By linkForgotPassword = By.cssSelector("a[href$='ForgotPassword.cshtml']");
    public By tabLogout;

    public WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getLblErrorMessage() {
        return Constant.WEBDRIVER.findElement(lblErrorMessage);
    }

    public WebElement getLblErrorUsername() {
        return Constant.WEBDRIVER.findElement(lblErrorUsername);
    }

    public WebElement getLblErrorPassword() {
        return Constant.WEBDRIVER.findElement(lblErrorPassword);
    }

    public WebElement getLinkRegister() {
        return Constant.WEBDRIVER.findElement(linkRegister);
    }

    public WebElement getLinkForgotPassword() {
        return Constant.WEBDRIVER.findElement(linkForgotPassword);
    }

    public WebElement getTabLogout() {
        tabLogout = By.cssSelector("a[href*=Logout]");
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    public String getLoginErrorMessage() {
        return this.getLblErrorMessage().getText();

    }

    public String getErrorEnterUsername() {
        return this.getLblErrorUsername().getText();
    }

    public String getErrorEnterPassword() {
        return this.getLblErrorPassword().getText();
    }

    public void login(String username, String password) {
        this.getTxtEmail().clear();
        this.getTxtEmail().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
//        if (this.getWelcomeMessage().equals("Welcome guest!")) {
//            this.getTxtEmail().clear();
//            this.getTxtEmail().sendKeys(username);
//            this.getTxtPassword().sendKeys(password);
//            this.getBtnLogin().click();
//        }
    }

    public void logout() {
        this.getTabLogout().click();
        this.getTabLogin().click();
    }
}

