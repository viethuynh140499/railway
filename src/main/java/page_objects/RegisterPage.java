package page_objects;

import common.helpers.element.Button;
import common.helpers.element.Link;
import common.helpers.element.TextBox;
import org.openqa.selenium.By;

public class RegisterPage {
  private final TextBox txtEmail = new TextBox(By.cssSelector("[id$=email]"));
  private final TextBox txtPassword = new TextBox(By.cssSelector("[id$=password]"));
  private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("[id$=confirmPassword]"));
  private final TextBox txtPid = new TextBox(By.cssSelector("[id$=pid]"));

  private final Button btnRegister = new Button(By.cssSelector("[title='Register']"));
  private final Link linkLogin = new Link(By.cssSelector("a[href$='Login.cshtml']"));
  private final Link linkForgotPassword = new Link(By.cssSelector("a[href$='Confirm.cshtml']"));

  /***
   *
   * @param username
   * @param password
   * @param confirmPassword
   * @param pid
   */

  public void register(String username, String password, String confirmPassword, String pid){
    this.txtEmail.enterText(username);
    this.txtPassword.enterText(password);
    this.txtConfirmPassword.enterText(confirmPassword);
    this.txtPid.enterText(pid);
    this.btnRegister.click();
  }
}
