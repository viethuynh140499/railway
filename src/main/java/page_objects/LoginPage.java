package page_objects;

import common.element.Button;
import common.element.Label;
import common.element.Link;
import common.element.TextBox;
import common.helpers.ElementHelper;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {
    private final TextBox txtEmail = new TextBox(By.cssSelector("[id$=username]"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("[id$=password]"));
    private final Button btnLogin = new Button(By.cssSelector("[title='Login']"));
    private final Label lblErrorMessage = new Label(By.cssSelector("p[class*='error']"));
    private final Label lblErrorUsername = new Label(By.cssSelector("[for$='username']"));
    private final Label lblErrorPassword = new Label(By.cssSelector("[for$='password']"));
    private final Link lnkRegister = new Link(By.cssSelector("a[href$='Register.cshtml']"));

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public String getUsernameErrorMessage() {
        return this.lblErrorUsername.getText();
    }

    public String getPasswordErrorMessage() {
        return this.lblErrorPassword.getText();
    }

    public void login(String username, String password) {
        this.txtEmail.enterText(username);
        this.txtPassword.enterText(password);
        this.btnLogin.scrollToView();
        this.btnLogin.submit();
    }
}

