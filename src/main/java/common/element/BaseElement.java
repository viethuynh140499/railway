package common.element;

import common.helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {

    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return BrowserHelper.getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return BrowserHelper.getDriver().findElements(locator);
    }

    public void click() {
        findElement().click();
    }

    public void submit() {
        findElement().submit();
    }

    public String getText() {
        return findElement().getText();
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void scrollToView() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserHelper.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public boolean isSelected() {
        return findElement().isSelected();
    }

    public static boolean doesElementExist(By locator) {
        try {
            return BrowserHelper.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }
}
