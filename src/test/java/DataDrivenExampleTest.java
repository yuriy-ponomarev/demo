import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenExampleTest extends TestBase {

    @DataProvider( name = "verifySearchBetweenDifferentLocationsDP" )
    public static Object[][] verifySearchBetweenDifferentLocationsDP(){
        return new Object[][]{
                {"Boston", "NewYork"},
                {"Boston", "Berlin"},
                {"Portland", "Rome"},
                {"Paris", "Berlin"}
        };
    }

    @Test( dataProvider = "verifySearchBetweenDifferentLocationsDP" )
    public void verifySearchBetweenDifferentLocations(String cityFrom, String cityTo){
        PageHome pageHome = PageFactory.initElements( driver, PageHome.class );
        pageHome.waitUntilPageLoaded();

        FlightsPage flightsPage = pageHome.findFlights(cityFrom, cityTo);
        Assert.assertTrue(flightsPage.getFlights().size() > 0);

    }
}


