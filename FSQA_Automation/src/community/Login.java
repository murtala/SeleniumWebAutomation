package community;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtil;
import utils.Highlighter;
public class Login extends BrowserUtil {
	
	String baseUrl = "https://staging-community.fullscreen.net/";
	/* log in */
	public void authenticate(String email, String password) {
		//WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 60);
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("new_user")));
		
		driver.get(baseUrl);
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_email")).sendKeys(email);
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
	}
}
