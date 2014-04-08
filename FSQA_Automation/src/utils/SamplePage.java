package utils;

public class SamplePage {

	
	public void test1 ()  {
		BrowserUtil bu = new BrowserUtil();
		PageUtil pu = new PageUtil();
		bu.setBrowser("chrome");
		bu.navigateTo("https://fstools-staging.herokuapp.com/");
		pu.login("fsqaautomation2@gmail.com", "fstester");
		PrimaryNav  pn = new PrimaryNav();
		pn.apps();
		UserNav un = new UserNav();
		un.settings();
		un.logOut();
		bu.driver.quit();
		
	}
}
