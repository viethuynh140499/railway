package page_objects;

import common.element.Button;
import common.element.Label;
import common.element.TextBox;
import model.User;
import org.openqa.selenium.By;

public class RegisterPage {
    private final TextBox txtEmail = new TextBox(By.cssSelector("[id$=email]"));
    private final TextBox txtPassword = new TextBox(By.cssSelector("[id$=password]"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("[id$=confirmPassword]"));
    private final TextBox txtPid = new TextBox(By.cssSelector("[id$=pid]"));

    private final Button btnRegister = new Button(By.cssSelector("[title='Register']"));

    private final Label lblErrorMessage = new Label(By.cssSelector("#content .message"));
    private final Label lblSuccessfully = new Label(By.cssSelector("#content p"));
    private final Label lblEmailErrorMessage = new Label(By.cssSelector(".email label:last-child"));
    private final Label lblPasswordErrorMessage = new Label(By.cssSelector(""));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.cssSelector(""));
    private final Label lblPIPErrorMessage = new Label(By.cssSelector(""));

    public String getSuccessfullyMessage() {
        return this.lblSuccessfully.getText();
    }

    public String getErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public String getEmailErrorMessage() {
        return this.lblEmailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return this.lblPasswordErrorMessage.getText();
    }

    public String getConfirmErrorMessage() {
        return this.lblConfirmPasswordErrorMessage.getText();
    }

    public String getPIDErrorMessage() {
        return this.lblPIPErrorMessage.getText();
    }

    public void register(User user) {
        this.btnRegister.scrollToView();
        this.txtEmail.enterText(user.getUsername());
        this.txtPassword.enterText(user.getPassword());
        this.txtConfirmPassword.enterText(user.getPassword());
        this.txtPid.enterText(user.getPid());
        this.btnRegister.submit();
    }
}
