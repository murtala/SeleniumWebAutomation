package community.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;

public class AccountControls {

	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
	CustomFinder find = new CustomFinder();
	public void user() {
		find.byXpath("//div[@type='account']//a[@class='dropdown-toggle']r//span");
		find.byXpath("//li[@ng-switch-when='account']//h4//a");
	}

	public void editProfile() {
		find.byXpath("//div[@type='account']//a[@class='dropdown-toggle']//span");
		//CustomFinder.locateLinkText("Edit Profile");
		find.byElement(BrowserUtil.driver.findElement(By.linkText("Edit Profile")));
	}

	public void help() {
		find.byXpath("//div[@type='account']//a[@class='dropdown-toggle']//span");
		//CustomFinder.locateLinkText("Help");
		find.byElement(BrowserUtil.driver.findElement(By.linkText("Help")));
		BrowserUtil.driver.navigate().back();
	}

	public void settings() {
		find.byXpath("//div[@type='account']//a[@class='dropdown-toggle']//span");
		//CustomFinder.locateLinkText("Settings");
		find.byElement(BrowserUtil.driver.findElement(By.linkText("Settings")));
	}
	
	public void logOut() {
		find.byXpath("//div[@type='account']//a[@class='dropdown-toggle']//span");
		find.byElement(BrowserUtil.driver.findElement(By.linkText("Log Out")));
	}
	

}
