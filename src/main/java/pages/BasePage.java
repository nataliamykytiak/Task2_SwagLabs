package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    private static final long PAGE_LOAD_TIMEOUT = 5;
    private static final long ACTION_TIMEOUT = 3;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage getLogInPage() {
        return new LoginPage(driver);
    }

    public ProductsPage getProductsPage() {
        return new ProductsPage(driver);
    }

    public void waitForVisibilityOfElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageLoadComplete() {
        new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public void waitForActionToBeCompleted() {
        new WebDriverWait(driver, Duration.ofSeconds(ACTION_TIMEOUT)).ignoring(StaleElementReferenceException.class)
                .until(driver -> {
                    try {
                        TimeUnit.SECONDS.sleep(ACTION_TIMEOUT);
                        return true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return false;
                    }
                });
    }

    public void clearInput(WebElement inputField) {
        inputField.sendKeys(Keys.CONTROL + "A");
        inputField.sendKeys(Keys.BACK_SPACE);
    }


}
