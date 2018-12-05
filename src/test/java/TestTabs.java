import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

    public static class Commands extends TestBase {

        @Test
        public void commandTest() {
            driver.get( "http://www.google.com" );

    /*

            Syntax:
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(Script,Arguments);

            Script – The JavaScript to execute
            Arguments –The arguments to the script(Optional). May be empty.
            Returns –One of Boolean, Long, String, List, WebElement, or null.

                    Let’s see some scenarios we could handle using this Interface:
    */
            // To type Text in Selenium WebDriver without using sendKeys() method
            WebElement loginButton = driver.findElement( By.id( "id" ) );
            WebElement element = driver.findElement( By.id( "id" ) );

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('some id').value='someValue';");
            js.executeScript("document.getElementById('Email').value='SoftwareTestingMaterial.com';");

            //To click a Button in Selenium WebDriver using JavaScript

            js.executeScript("document.getElementById('enter your element id').click();");
            //or
            js.executeScript("document.getElementById('enter your element id').click();");
            //or
            js.executeScript("arguments[0].click();", loginButton);

            //To handle Checkbox
            js.executeScript("document.getElementById('enter element id').checked=false;");

            //To generate Alert Pop window in selenium
            js.executeScript("alert('Welcome To SoftwareTestingMaterial');");

            //To refresh browser window using Javascript
            js.executeScript("history.go(0)");

            //To get innertext of the entire webpage in Selenium
            String sText =  js.executeScript("return document.documentElement.innerText;").toString();
            System.out.println(sText);

            //To get the Title of our webpage
            sText =  js.executeScript("return document.title;").toString();
            System.out.println(sText);

            //To get the domain
            sText =  js.executeScript("return document.domain;").toString();
            System.out.println(sText);


            //To get the URL of a webpage
            sText =  js.executeScript("return document.URL;").toString();
            System.out.println(sText);

            //To perform Scroll on application using  Selenium
            //Vertical scroll - down by 500  pixels
            js.executeScript("window.scrollBy(0,500)");
            // for scrolling till the bottom of the page we can use the code like
            //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            //Vertical scroll - down by 500  pixels
            js.executeScript("window.scrollBy(0,500)");
            // for scrolling till the bottom of the page we can use the code like
            //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

            //To click on a SubMenu which is only visible on mouse hover on Menu
            js.executeScript("$('ul.menus.menu-secondary.sf-js-enabled.sub-menu li').hover()");

            //To navigate to different page using Javascript
            js.executeScript("window.location = 'https://www.softwaretestingmaterial.com");

            //To find hidden element in selenium using JavaScriptExecutor
            js.executeScript("arguments[0].click();", element);

        }

    }
}
