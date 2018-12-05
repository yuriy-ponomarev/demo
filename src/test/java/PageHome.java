import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHome extends PageBase {

    public PageHome (WebDriver driver) {
        super(driver);
    }

    public static String baseUrl = "https://demoqa.com/";

    public static final String TAB_LOCATOR = "ui-id-%s";
    public static final String TAB_BOLD_TEXT_LOCATOR = "//div[@id='tabs-%s']//b";

    public static PageHome open( WebDriver driver) {
        driver.navigate().to( baseUrl );
        return new PageHome( driver );
    }

    public void waitUntilPageLoaded() {
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void openTab(Integer tabNumber){
        driver.findElement(By.id(String.format(TAB_LOCATOR, tabNumber))).click();
    }

    public boolean tabContentIsVisible (Integer tabNumber){
          return driver.findElement(By
                  .xpath(String.format(TAB_BOLD_TEXT_LOCATOR, tabNumber)))
                  .isDisplayed();
    }

    public String getTabContent(Integer tabNumber){
        return driver.findElement(By
                .xpath(String.format(TAB_BOLD_TEXT_LOCATOR, tabNumber)))
                .getText();
    }

    public FlightsPage findFlights( String cityFrom, String cityTo ) {
        return new FlightsPage( driver );
    }
}
