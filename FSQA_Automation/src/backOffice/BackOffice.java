package backOffice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.BrowserUtil;

import static utils.BrowserUtil.*;
import accounts.Login;
import accounts.UserInfo;
import utils.BrowserUtil;
/**
 * Created with Intellimport accounts.Login;
import accounts.UserInfo;
iJ IDEA.
 * User: madamou
 * Date: 11/15/13
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class BackOffice extends BrowserUtil {

static WebDriver driver = BrowserUtil.driver;
//WebDriver driver = new FirefoxDriver();
	public void openPage(){
		BrowserUtil.setBrowser("ch");
		String url ="";
		url="http://fs-backoffice-staging.herokuapp.com/";
		BrowserUtil.driver.get(url);
	}   
	
	public void authenticate(String email, String password) {
		UserInfo ui = new UserInfo();
		ui.setEmail(email);
		ui.setPassword(password);
		Login l = new Login();
		l.submit(email, password);
	}
	
  

}
