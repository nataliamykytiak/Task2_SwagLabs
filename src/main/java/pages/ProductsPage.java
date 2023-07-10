package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement appLogo;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getAppLogoText() {
        waitForPageLoadComplete();
        return appLogo.getText();
    }
}
