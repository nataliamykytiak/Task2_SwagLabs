import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.LoginPage;

public abstract class BaseTest {
    protected static final String LOGIN_URL = "https://www.saucedemo.com/";
    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeMethod
    public void testsSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOGIN_URL);
        basePage = new BasePage(driver);
    };

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
