package backOffice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.BrowserUtil;
import utils.PageUtil;

/**
 * Created with IntelliJ IDEA.
 * User: madamou
 * Date: 11/14/13
 * Time: 9:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainNavTest extends BrowserUtil {
    WebDriver driver = new FirefoxDriver();

    @Test
    public void testViewDetails() throws Exception {

        driver.get("https://fs-backoffice-staging.herokuapp.com/");
    }

    @Test
    public void testAddNewUser() throws Exception {

    }
}
