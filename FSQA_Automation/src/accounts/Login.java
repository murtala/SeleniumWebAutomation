package accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.BrowserUtil;


/**
 * Created with IntelliJ IDEA.
 * User: madamou
 * Date: 11/14/13
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login {

	String emailId = "user_email";
	String passwordId = "user_password";
	String buttonName = "commit";

	WebDriver driver = BrowserUtil.driver;

	public void submit(String email, String password) {
		driver.findElement(By.id(emailId)).sendKeys(email);	//enter user email
		driver.findElement(By.id(passwordId)).sendKeys(password);	//enter password
		driver.findElement(By.name(buttonName)).click(); // click the button
	}
	
	public void submit(WebDriver drivers ,String email, String password) {
		drivers= driver;
		driver.findElement(By.id(emailId)).sendKeys(email);	//enter user email
		driver.findElement(By.id(passwordId)).sendKeys(password);	//enter password
		driver.findElement(By.name(buttonName)).click(); // click the button
	}
	
	

}




