import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public WebDriver driver;

    @BeforeTest
    public void start() {
        System.setProperty( "webdriver.chrome.driver", "D:\\chromedriver.exe" );
        driver = new ChromeDriver();
        /*driver = new InternetExplorerDriver();
        driver = new EdgeDriver(  );
*/
        driver.getCurrentUrl();

        //Or can be written as

        String CurrentUrl = driver.getCurrentUrl();

        driver.getPageSource();

        //Or can be written as

        String PageSource = driver.getPageSource();

    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

}