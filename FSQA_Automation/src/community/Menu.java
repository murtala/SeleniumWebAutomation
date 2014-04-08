package community;

import org.openqa.selenium.By;

import utils.BrowserUtil;

public class Menu extends BrowserUtil {

	public void user() {

		driver.findElement(By.id("fs-user")).click();
		
	}
	
}
