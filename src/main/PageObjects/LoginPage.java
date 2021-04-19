import constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends Genneral {
    public final By txtEmail = By.cssSelector("[id$=username]");
    public final By txtPassword = By.cssSelector("[id$=password]");
    public final By btnLogin = By.cssSelector("[title='Login']");
    public final By lblErrorMessage = By.cssSelector("[class*='error']");
    public final By lblErrorUsername = By.cssSelector("[for$='username']");
    public final By lblErrorPassword = By.cssSelector("[for$='password']");
    public final By linkRegister = By.cssSelector("a[href$='Register.cshtml']");
    public final By linkForgotPassword = By.cssSelector("a[href$='ForgotPassword.cshtml']");

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

    public String getLoginErrorMessage() {
        return this.getLblErrorMessage().getText();

    }

    public String getErrorEnterUsername() {
        return this.getLblErrorUsername().getText();
    }

    public String getErrorEnterPassword() {
        return this.getLblErrorPassword().getText();
    }

    public void HomePage(String username, String password) {
        this.getTxtEmail().sendKeys("asas4@gmail.com");
        this.getTxtPassword().sendKeys("viet123456");
        this.getBtnLogin().click();
    }

    public void LoginPage(String username, String password) {
        this.getTxtEmail().sendKeys("asas4@gmail.com");
        this.getTxtPassword().sendKeys("viet1234567");
        this.getBtnLogin().click();
    }

    public LoginPage usernameInvalid(String username) {
        this.getTxtEmail().sendKeys("");
        this.getTxtPassword().sendKeys("viet123456");
        this.getBtnLogin().click();

        return new LoginPage();
    }

    public LoginPage passwordInvalid(String password) {
        this.getTxtEmail().sendKeys("asas5@gmai.com");
        this.getTxtPassword().sendKeys("");
        this.getBtnLogin().click();

        return new LoginPage();
    }

}
