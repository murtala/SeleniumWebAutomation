package community;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;
import utils.Highlighter;
import utils.Randomizer;

public class NotificationsPage {
	CustomFinder find = new CustomFinder();
	Randomizer ran = new Randomizer();
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
	WebDriver driver = BrowserUtil.driver;
	public NotificationsPage() {
		driver.navigate().to("https://staging-accounts.fullscreen.net/notifications");
	}

	public void openRandomNotification() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
		WebElement Parent = BrowserUtil.driver.findElement(By.xpath(".//table/tbody"));
		List<WebElement> list = Parent.findElements(By.tagName("tr"));
		ran.randomClick(list);
	}
	
	public void paginationLinks(){	//click on  random number, then click next then click previous	
		driver.navigate().to("https://staging-accounts.fullscreen.net/notifications");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("fs-pagination")));	
		WebElement pagination = BrowserUtil.driver.findElement(By.className("fs-pagination"));
		List<WebElement> pages = pagination.findElement(By.tagName("ul")).findElements(By.tagName("li"));	
		ran.randomClick(pages);
		find.byXpath("//a[@class='next-page']");
		find.byXpath("//a[@class='previous-page']");
	}
}
