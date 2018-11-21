import org.openqa.selenium.WebDriver;

public class PageShopRegister extends PageShop {
    public PageShopRegister( WebDriver driver ) {
        super( driver );
    }

    public static String baseUrl = PageShop.baseUrl + "?route=account/register";

    public static PageShopRegister open( WebDriver driver) {
        driver.navigate().to( baseUrl );
        return new PageShopRegister( driver );
    }
}
