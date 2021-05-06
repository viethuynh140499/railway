package page_objects;

import common.element.Button;
import common.element.Label;
import common.element.TextBox;
import model.User;
import org.openqa.selenium.By;

public class ChangePasswordPage extends GeneralPage{

  private final TextBox txtCurrentPassword = new TextBox(By.id("currentPassword"));
  private final TextBox txtNewPassword = new TextBox(By.id("newPassword"));
  private final TextBox txtConfirmPassword = new TextBox(By.id("confirmPassword"));
  private final Button btnChangePassword = new Button(By.cssSelector(".form-actions input"));
  private final Label lblChangePassword = new Label(By.className("message"));
  private final Label lblConfirmPasswordErrorMessage = new Label(By.cssSelector(".confirm-password>.validation-error"));
  private final Label lblNewPasswordErrorMessage = new Label(By.cssSelector(".new-password>.validation-error"));

  public String getSuccessfullyMessage() {
    return this.lblChangePassword.getText();
  }

  public String getErrorMessage() {
    return this.lblChangePassword.getText();
  }

  public String getConfirmPasswordErrorMessage() {
    return this.lblConfirmPasswordErrorMessage.getText();
  }

  public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
    this.btnChangePassword.scrollToView();
    this.txtCurrentPassword.enterText(currentPassword);
    this.txtNewPassword.enterText(newPassword);
    this.txtConfirmPassword.enterText(confirmPassword);
    this.btnChangePassword.submit();
  }
}
