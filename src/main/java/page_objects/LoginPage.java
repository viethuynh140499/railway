package page_objects;

import common.element.Button;
import common.element.TextBox;
import model.User;
import org.openqa.selenium.By;

public class LoginPage extends GeneralPage {
  private final TextBox txtEmail = new TextBox(By.cssSelector("[id$=username]"));
  private final TextBox txtPassword = new TextBox(By.cssSelector("[id$=password]"));
  private final Button btnLogin = new Button(By.cssSelector("[title='Login']"));

  public void login(User user) {
    this.btnLogin.scrollToView();
    this.txtEmail.enterText(user.getUsername());
    this.txtPassword.enterText(user.getPassword());
    this.btnLogin.submit();
  }
}
