package page_objects;

import common.constant.Constant;
import common.helper.Helper;
import common.helper.element.Button;
import common.helper.element.Label;
import common.helper.element.Link;
import common.helper.element.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends Genneral {


    public final TextBox txtEmail = new TextBox(By.cssSelector("[id$=username]"));
    public final TextBox txtPassword = new TextBox(By.cssSelector("[id$=password]"));
    public final Button btnLogin = new Button(By.cssSelector("[title='Login']"));
    public final Label lblErrorMessage = new Label(By.cssSelector("p[class*='error']"));
    public final Label lblErrorUsername = new Label(By.cssSelector("[for$='username']"));
    public final Label lblErrorPassword = new Label(By.cssSelector("[for$='password']"));
    public final Link linkRegister = new Link(By.cssSelector("a[href$='Register.cshtml']"));
    public final Link linkForgotPassword = new Link(By.cssSelector("a[href$='ForgotPassword.cshtml']"));
    public By tabLogout;



    public String getLblErrorMessage() {
        return this.lblErrorMessage.getText();
    }

    public void getLblErrorUsername() {
        this.lblErrorUsername.getText();
    }

    public void getLblErrorPassword() {
        this.lblErrorPassword.getText();
    }

    public void getLinkRegister() {
       this.linkRegister.click();
    }

    public void getLinkForgotPassword() {
        this.linkForgotPassword.click();
    }


    public void getErrorEnterUsername() {
         this.getLblErrorUsername();
    }

    public void getErrorEnterPassword() {
         this.getLblErrorPassword();
    }

    public void login(String username, String password) {
        this.txtEmail.enterText(username);
        this.txtPassword.enterText(password);
        Helper.scrollToView(this.btnLogin.findElement());
        this.btnLogin.click();
//        if (this.getWelcomeMessage().equals("Welcome guest!")) {
//            this.getTxtEmail().clear();
//            this.getTxtEmail().sendKeys(username);
//            this.getTxtPassword().sendKeys(password);
//            this.getBtnLogin().click();
//        }
    }


}

