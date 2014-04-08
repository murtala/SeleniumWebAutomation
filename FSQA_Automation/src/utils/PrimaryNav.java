package utils;

public class PrimaryNav extends Header {

	ReportUtil ru = new ReportUtil();
	
	public void earnings() {
		
		
		/* start logs */
		ru.startLog("earnings");

		BrowserUtil.driver.navigate().to("https://fsearnings-staging.herokuapp.com/"); // go to ink

		/* end logs */
		ru.stopLog();
	}

	public void stats() {
		/* start logs */
		ru.startLog("stats");

		BrowserUtil.driver.navigate().to("https://fsanalytics-staging.herokuapp.com/"); // go to ink

		/* end logs */
		ru.stopLog();
	}

	public void explore() {
		/* start logs */
		ru.startLog("explore");

		BrowserUtil.driver.navigate().to("https://fsanalytics-staging.herokuapp.com/explore"); // go to ink

		/* end logs */
		ru.stopLog();
	}

	public void forums() {
		/* start logs */
		ru.startLog("forums");

		BrowserUtil.driver.navigate().to("https://fs-db-staging1.herokuapp.com/forums"); // go to ink

		/* end logs */
		ru.stopLog();
	}

	public void apps() {
		/* start logs */
		ru.startLog("apps");

		BrowserUtil.driver.navigate().to("https://fstools-staging.herokuapp.com/"); // go to ink

		/* end logs */
		ru.stopLog();
	} 
}
