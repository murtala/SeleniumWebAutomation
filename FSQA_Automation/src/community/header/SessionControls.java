package community.header;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;

public class SessionControls {
	BrowserUtil bu = new BrowserUtil();
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
	CustomFinder find = new CustomFinder();

	Header h = new Header();

	public void messages(String message, String user) {
		find.byElement(BrowserUtil.driver.findElement(By.xpath("//li/a/span")));
		// click compose button
		find.byXpathNS(".//*[@id='fs-application-wrapper']/div[3]/div/div[1]/button");
		// enter destination
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@type='text']")));
		BrowserUtil.driver.findElement(By.xpath(".//input[@type='text']")).sendKeys(user);
		find.byXpath(".//input[@type='text']");
		// auto complete
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//li//h5[@class='user-name ng-binding']")));
		BrowserUtil.driver.findElement(By.xpath(".//li//h5[@class='user-name ng-binding']")).click();
		find.byXpath(".//li//h5[@class='user-name ng-binding']");
		
		// enter the message
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//textarea[@name='postBody']")));
		BrowserUtil.driver.findElement(By.xpath(".//textarea[@name='postBody']")).sendKeys(message);
		BrowserUtil.driver.findElement(By.xpath(".//textarea[@name='postBody']")).sendKeys(Keys.ENTER);
	}

	public void notifications() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@collection='notifications']//span")));
		BrowserUtil.driver.findElement(By.xpath("//div[@collection='notifications']//span")).click();
	}

	public void accountControls() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@type='account']//a[@class='dropdown-toggle']//span")));
		BrowserUtil.driver.findElement(By.xpath("//div[@type='account']//a[@class='dropdown-toggle']//span")).click();
	}

}
