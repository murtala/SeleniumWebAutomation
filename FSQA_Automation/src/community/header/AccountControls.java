package community.header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;

public class AccountControls {

	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
	public void user() {
		CustomFinder.locateXpath("//div[@type='account']//a[@class='dropdown-toggle']//span", true, true);
		CustomFinder.locateXpath("//li[@ng-switch-when='account']//h4//a", true, true);
	}

	public void editProfile() {
		CustomFinder.locateXpath("//div[@type='account']//a[@class='dropdown-toggle']//span", true, true);
		CustomFinder.locateLinkText("Edit Profile", false, true);
	}

	public void help() {
		CustomFinder.locateXpath("//div[@type='account']//a[@class='dropdown-toggle']//span", true, true);
		CustomFinder.locateLinkText("Help", false, true);
		BrowserUtil.driver.navigate().back();
	}

	public void settings() {
		CustomFinder.locateXpath("//div[@type='account']//a[@class='dropdown-toggle']//span", true, true);
		CustomFinder.locateLinkText("Settings", false, true);
	}
	
	public void logOut() {
		CustomFinder.locateXpath("//div[@type='account']//a[@class='dropdown-toggle']//span", true, true);
		CustomFinder.locateLinkText("Log Out", false, true);
	}
	

}
