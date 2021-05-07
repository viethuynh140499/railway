package page_objects;

import common.element.Button;
import common.element.Label;
import common.element.TextBox;
import model.User;
import org.openqa.selenium.By;

public class RegisterPage extends GeneralPage{
  private final TextBox txtEmail = new TextBox(By.id("email"));
  private final TextBox txtPassword = new TextBox(By.id("password"));
  private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
  private final TextBox txtPid = new TextBox(By.id("pid"));

  private final Button btnRegister = new Button(By.cssSelector("#RegisterForm .form-actions input"));
  private final Label lblSuccessfully = new Label(By.id("content"));

  public String getSuccessfullyMessage() {
    return this.lblSuccessfully.getText();
  }

  public void registerAccount(User user) {
    this.btnRegister.scrollToView();
    this.txtEmail.enterText(user.getUsername());
    this.txtPassword.enterText(user.getPassword());
    this.txtConfirmPassword.enterText(user.getPassword());
    this.txtPid.enterText(user.getPid());
    this.btnRegister.submit();
  }
}
