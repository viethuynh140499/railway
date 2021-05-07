package page_objects;

import common.element.Button;
import common.element.Label;
import common.element.TextBox;
import model.User;
import org.openqa.selenium.By;

public class RegisterPage extends GeneralPage {
  private final TextBox txtEmail = new TextBox(By.id("email"));
  private final TextBox txtPassword = new TextBox(By.id("password"));
  private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
  private final TextBox txtPid = new TextBox(By.id("pid"));
  private final Label lblSuccessfullyMessage = new Label(By.cssSelector("#content p"));
  private final Label lblErrorMessage = new Label(By.cssSelector("#content .message"));
  private final Label lblPasswordErrorMessage = new Label(By.cssSelector(".password .validation-error"));
  private final Label lblPIPErrorMessage = new Label(By.cssSelector(".pid-number .validation-error"));
  private final Button btnRegister = new Button(By.cssSelector("#RegisterForm .form-actions input"));
  private final Label lblSuccessfully = new Label(By.id("content"));

  public String getErrorMessage() {
    return this.lblErrorMessage.getText();
  }

  public String getPasswordErrorMessage() {
    return this.lblPasswordErrorMessage.getText();
  }

  public String getPIDErrorMessage() {
    return this.lblPIPErrorMessage.getText();
  }

  public String getSuccessfullyMessage() {
    return this.lblSuccessfullyMessage.getText();
  }

  public void registerAccount(String username, String password, String confirmPassword, String pid) {
    this.btnRegister.scrollToView();
    this.txtEmail.enterText(username);
    this.txtPassword.enterText(password);
    this.txtConfirmPassword.enterText(confirmPassword);
    this.txtPid.enterText(pid);
    this.btnRegister.click();
  }
}
