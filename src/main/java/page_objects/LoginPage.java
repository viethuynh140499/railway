package page_objects;

import common.helpers.ElementHelper;
import common.helpers.element.Button;
import common.helpers.element.Label;
import common.helpers.element.Link;
import common.helpers.element.TextBox;
import org.openqa.selenium.By;

public class LoginPage extends General {


    private final TextBox txtEmail = new TextBox(By.cssSelector("[id$=username]"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("[id$=password]"));
    private final Button btnLogin = new Button(By.cssSelector("[title='Login']"));
    private final Label lblErrorMessage = new Label(By.cssSelector("p[class*='error']"));
    private final Label lblErrorUsername = new Label(By.cssSelector("[for$='username']"));
    private final Label lblErrorPassword = new Label(By.cssSelector("[for$='password']"));
    private final Link linkRegister = new Link(By.cssSelector("a[href$='Register.cshtml']"));
    private final Link linkForgotPassword = new Link(By.cssSelector("a[href$='ForgotPassword.cshtml']"));

    public String getLblErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public String getLblErrorUsername() {
        return this.lblErrorUsername.getText();
    }

    public String getLblErrorPassword() {
        return this.lblErrorPassword.getText();
    }

    public void clickLinkRegister() {
        this.linkRegister.click();
    }

    public void login(String username, String password) {
        this.txtEmail.enterText(username);
        this.txtPassword.enterText(password);
        ElementHelper.scrollToView(this.btnLogin.findElement());
        this.btnLogin.click();
    }
}

