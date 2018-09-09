import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDDT extends TestBase {

    @DataProvider( name = "DataProvider" )
    public static Object[][] DataProvider() {
        return new Object[][]{
                {"Welcome: Mercury Tours"}
        };
    }

    @Test( dataProvider = "DataProvider" )
    public void testTitle( String expectedTitle ) {
        String actualTitle = "";

        actualTitle = driver.getTitle();

        Assert.assertEquals( expectedTitle, actualTitle );
    }

    @DataProvider( name = "DataProviderNegative" )
    public static Object[][] DataProviderNegative() {
        return new Object[][]{
                {"Welcome: Not expected title"}
        };
    }

    @Test( dataProvider = "DataProviderNegative" )
    public void testTitleNegative( String expectedTitle ) {
        String actualTitle = "";

        actualTitle = driver.getTitle();

        Assert.assertNotEquals( expectedTitle, actualTitle );
    }

    @DataProvider( name = "DataProviderParametrized" )
    public static Object[][] DataProviderParametrized(ITestContext context) {
        String expectedTitle = context.getCurrentXmlTest().getParameter("expectedTitle");
        boolean positive = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("positive"));
        return new Object[][]{
                {expectedTitle, positive}
        };
    }

    @Test( dataProvider = "DataProviderParametrized" )
    public void testTitleParametrized( String expectedTitle, boolean positive ) {
        String actualTitle = "";

        actualTitle = driver.getTitle();

        if (positive){
            Assert.assertEquals( expectedTitle, actualTitle );
        } else {
            Assert.assertNotEquals( expectedTitle, actualTitle );
        }

    }
}
