package page_objects;

import common.element.Button;
import common.element.Label;
import common.element.TextBox;
import model.User;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {
  private final TextBox txtEmail = new TextBox(By.id("username"));
  private final TextBox txtPassword = new TextBox(By.id("password"));
  private final Button btnLogin = new Button(By.cssSelector(".form-actions input"));
  private final Label lblErrorMessage = new Label(By.cssSelector("#content .message"));

  public void login(User user) {
    this.btnLogin.scrollToView();
    this.txtEmail.enterText(user.getUsername());
    this.txtPassword.enterText(user.getPassword());
    this.btnLogin.submit();
  }

  public String getErrorMessage() {
    return this.lblErrorMessage.getText();
  }

}
