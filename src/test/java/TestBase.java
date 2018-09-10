import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public WebDriver driver;

    @BeforeTest
    public void start() {
        System.setProperty( "webdriver.chrome.driver", "D:\\chromedriver.exe" );
        driver = new ChromeDriver();

    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

}