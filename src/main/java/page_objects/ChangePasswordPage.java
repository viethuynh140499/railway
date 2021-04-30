package page_objects;

import common.element.Button;
import common.element.Label;
import common.element.TextBox;
import org.openqa.selenium.By;

public class ChangePasswordPage extends GeneralPage {
    private final TextBox txtCurrentPassword = new TextBox(By.cssSelector("#currentPassword"));
    private final TextBox txtNewPassword = new TextBox(By.cssSelector("#newPassword"));
    private final TextBox txtConfirmPassword = new TextBox(By.cssSelector("#confirmPassword"));
    private final Button btnChangePassword = new Button(By.cssSelector("[title='Change password']"));
    private final Label lblChangePassword = new Label(By.cssSelector(".message"));
    private final Label lblConfirmPasswordErrorMessage = new Label(By.cssSelector(".confirm-password label:last-child"));
    private final Label lblNewPasswordErrorMessage = new Label(By.cssSelector(".new-password label:last-child"));

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
