package earnings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: madamou
 * Date: 11/9/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Test
public class EarningsTest {


    WebDriver driver = new FirefoxDriver();

    public void home() {
        driver.get("http://www.yahoo.com");

    }


}



