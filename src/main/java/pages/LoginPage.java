package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInputField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3")
    private WebElement errorMessage;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        waitForVisibilityOfElement(usernameInputField);
        usernameInputField.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForVisibilityOfElement(passwordInputField);
        passwordInputField.sendKeys(password);
    }

    public void clearUsernameInput() {
        clearInput(usernameInputField);
        waitForActionToBeCompleted();
    }

    public void clearPasswordInput() {
        clearInput(passwordInputField);
        waitForActionToBeCompleted();
    }

    public void clickLoginButton() {
        loginButton.click();
        waitForActionToBeCompleted();
    }

    public String getErrorMessage() {
        waitForVisibilityOfElement(errorMessage);
        return errorMessage.getText();
    }



}
