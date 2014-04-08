package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Util {
	public static Reporter reporter;
	public static WebDriver drivers;
	
	static {
		Reporter.log("<table border='1'><tr>");
		Reporter.log("<tr><th>MODULE</th><th>TIME</th><th>MODULE</th><th>TIME</th><th>TOTAL TIME</th></tr>");
	}
	
}
