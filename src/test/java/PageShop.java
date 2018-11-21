import org.openqa.selenium.WebDriver;

public class PageShop extends PageBase {
    public PageShop( WebDriver driver) {
        super(driver);
    }

    public static String baseUrl = "http://h902098v.beget.tech/index.php";

    public static PageShop open( WebDriver driver) {
        driver.navigate().to( baseUrl );
        return new PageShop( driver );
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
