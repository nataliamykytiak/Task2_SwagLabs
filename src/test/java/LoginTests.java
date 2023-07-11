import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private final String INVALID_USERNAME = "user";
    private final String INVALID_PASSWORD = "1234567";
    private final String VALID_USERNAME = "standard_user";
    private final String VALID_PASSWORD = "secret_sauce";

    @Override
    @BeforeMethod
    public void testsSetUp() {
        super.testsSetUp();
        loginPage = basePage.getLogInPage();
        productsPage = basePage.getProductsPage();
    }

    @Test(description = "UC -1 - Test Login form with empty credentials")
    public void loginFormWithEmptyCredentialsTest() {
        loginPage.enterUsername(INVALID_USERNAME);
        loginPage.enterPassword(INVALID_PASSWORD);
        loginPage.clearUsernameInput();
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"));
    }

    @Test(description = "UC -2 - Test Login form with credentials by passing Username.")
    public void loginFormWithCredentialsByPassingUsernameTest() {
        loginPage.enterUsername(INVALID_USERNAME);
        loginPage.enterPassword(INVALID_PASSWORD);
        loginPage.clearPasswordInput();
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"));
    }

    @Test(description = "UC -3 - Test Login form with credentials by passing Username & Password ")
    public void loginFormWithCredentialsByPassingUsernameAndPasswordTest() {
        loginPage.enterUsername(VALID_USERNAME);
        loginPage.enterPassword(VALID_PASSWORD);
        loginPage.clickLoginButton();
        Assert.assertEquals(productsPage.getAppLogoText(), "Swag Labs");
    }

}