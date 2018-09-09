import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class PageHome extends PageBase{

    public PageHome (WebDriver driver) {
        super(driver);
    }

    public static final String TAB_LOCATOR = "ui-id-%s";
    public static final String TAB_BOLD_TEXT_LOCATOR = "//div[@id='tabs-%s']//b";

    public String title = "Demoqa | Just another WordPress site";

    public boolean verifyTitle(){
        return driver.getTitle().equals(title);
    }

    public SoftAssert verifyTabsContent(int tabs, String tabsContent){
        SoftAssert softAssert = new SoftAssert();
        for (Integer i = 1; i <= tabs; i++){
            String tabNumber = i.toString();
            String tabContent = String.format(tabsContent, tabNumber);

            driver.findElement(By.id(String.format(TAB_LOCATOR, tabNumber))).click();

            softAssert.assertTrue(driver.findElement(By
                    .xpath(String.format(TAB_BOLD_TEXT_LOCATOR, tabNumber)))
                    .isDisplayed());

            System.out.println(driver.findElement(By
                    .xpath(String.format(TAB_BOLD_TEXT_LOCATOR, tabNumber)))
                    .getText());

            softAssert.assertEquals(driver.findElement(By
                    .xpath(String.format(TAB_BOLD_TEXT_LOCATOR, tabNumber)))
                    .getText(), tabContent);
        }
        return softAssert;
    }
}
