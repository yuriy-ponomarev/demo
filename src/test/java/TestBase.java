import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public static WebDriver driver;

    @BeforeTest
    public void start() {
        System.setProperty( "webdriver.chrome.driver", "D:\\chromedriver.exe" );
        driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        driver.navigate().to( baseUrl );
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

}