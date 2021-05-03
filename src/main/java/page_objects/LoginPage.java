package page_objects;

import common.element.Button;
import common.element.Label;
import common.element.Link;
import common.element.TextBox;
import model.User;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {
    private final TextBox txtEmail = new TextBox(By.cssSelector("[id$=username]"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("[id$=password]"));
    private final Button btnLogin = new Button(By.cssSelector("[title='Login']"));
    private final Label lblErrorMessage = new Label(By.cssSelector("p[class*='error']"));
    private final Label lblErrorUsername = new Label(By.cssSelector("[for$='username']"));
    private final Label lblErrorPassword = new Label(By.cssSelector("[for$='password']"));

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public String getUsernameErrorMessage() {
        return this.lblErrorUsername.getText();
    }

    public String getPasswordErrorMessage() {
        return this.lblErrorPassword.getText();
    }

    public void login(User user) {
        this.btnLogin.scrollToView();
        this.txtEmail.enterText(user.getUsername());
        this.txtPassword.scrollToView();
        this.txtPassword.enterText(user.getPassword());
        this.btnLogin.click();
    }
}

