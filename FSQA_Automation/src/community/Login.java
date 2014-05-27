package community;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;
import utils.Highlighter;
public class Login extends BrowserUtil {
	
	String baseUrl = "https://staging-community.fullscreen.net/";
	CustomFinder find = new CustomFinder();
	/* log in */
	public void authenticate(String email, String password) {
		driver.get(baseUrl);
		find.byElementNS(driver.findElement(By.id("user_email")));
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_email")).sendKeys(email);
		find.byElementNS(driver.findElement(By.id("user_password")));
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(password);
		find.byElementNS(((driver.findElement(By.name("commit")))));
	}
}
