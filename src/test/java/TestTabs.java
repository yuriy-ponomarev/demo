import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestTabs extends TestBase {

    static int numberOfTabs = 5;

    @Test
    public void testTabs() {
        String title = "Demoqa | Just another WordPress site";
        Assert.assertEquals( driver.getTitle(), title );

        /*
        driver.findElement(By.id("ui-id-1")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='tabs-1']/b")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='tabs-1']/b")).getText(), "Content 1 Title");

        driver.findElement(By.id("ui-id-2")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='tabs-2']/b")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='tabs-2']/b")).getText(), "Content 2 Title");
        */

        String TAB_LOCATOR = "ui-id-%s";
        String TAB_BOLD_TEXT_LOCATOR = "//div[@id='tabs-%s']//b";

        for ( Integer i = 1; i <= 5; i++ ) {
            String tabNumber = i.toString();
            String tabContent = String.format( "Content %s Title", tabNumber );

            driver.findElement( By.id( String.format( TAB_LOCATOR, tabNumber ) ) ).click();

            Assert.assertTrue( driver.findElement( By
                    .xpath( String.format( TAB_BOLD_TEXT_LOCATOR, tabNumber ) ) )
                    .isDisplayed() );

            Assert.assertEquals( driver.findElement( By
                    .xpath( String.format( TAB_BOLD_TEXT_LOCATOR, tabNumber ) ) )
                    .getText(), tabContent );
        }
    }

    @Test
    public void testTabsPageObject() {
        String expectedTitle = "Demoqa | Just another WordPress site";
        String tabsContent = "Content %s Title";

        PageHome pageHome = PageHome.open( driver );

        Assert.assertEquals( expectedTitle, pageHome.getTitle() );

        SoftAssert softAssert = new SoftAssert();

        for ( int i = 1; i <= numberOfTabs; i++ ) {
            String expectedText = String.format( tabsContent, i );

            pageHome.openTab( i );

            softAssert.assertTrue( pageHome.tabContentIsVisible( i ) );
            softAssert.assertEquals( expectedText, pageHome.getTabContent( i ) );
        }

        softAssert.assertAll();
    }
}
