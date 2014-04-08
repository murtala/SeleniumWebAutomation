package backOffice;

import java.io.File;

import org.testng.annotations.Test;

import utils.BrowserUtil;

public class UsersTest extends BrowserUtil {  
	
	@Test
  public void addNewUser() {
	  BrowserUtil.setBrowser("ff");
  BrowserUtil.driver.get("https://fs-backoffice-staging.herokuapp.com/");
  
  }
}
