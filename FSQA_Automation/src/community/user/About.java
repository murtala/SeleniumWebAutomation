package community.user;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;

public class About {

	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);

	public About() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='About']")));
		BrowserUtil.driver.findElement(By.xpath("//a[text()='About']")).click();
	}

}
