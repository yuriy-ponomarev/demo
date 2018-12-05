import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class FlightsPage extends PageBase {
    public FlightsPage( WebDriver driver ) {
        super( driver );
    }

    public List getFlights() {
        return new ArrayList(  );
    }
}
