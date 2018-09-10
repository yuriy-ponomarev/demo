import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class TestWait extends TestBase {

    private void waitUntil(){
        // ...
        WebDriverWait wait     = new WebDriverWait(driver, 10/*seconds*/);
        WebElement    element  = wait.until(presenceOfElementLocated(By.name("q")));
        WebElement    element2 = wait.until((WebDriver d) -> d.findElement(By.name("q")));
    }

     private void waitUntilNotExist(){
         // ...
         WebElement element = driver.findElement(By.name("q"));

         WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
         driver.navigate().refresh();
         wait.until(stalenessOf(element));

     }


}




