import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome

public class TestClass {

    @Test
    public static void testOpenPage() {
        // declaration and instantiation of objects/variables
        //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch browser and direct it to the Base URL
        driver.navigate().to( baseUrl );

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if ( actualTitle.contentEquals( expectedTitle ) ) {
            System.out.println( "Test Passed!" );
        } else {
            System.out.println( "Test Failed" );
        }

        Assert.assertEquals(expectedTitle, actualTitle);

        //close browser
        driver.close();

    }

}