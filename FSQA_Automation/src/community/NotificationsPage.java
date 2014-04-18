package community;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;
import utils.Highlighter;

public class NotificationsPage {

	public void openRandomNotification() {
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
		BrowserUtil.driver.navigate().to("https://staging-accounts.fullscreen.net/notifications");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
		WebElement Parent = BrowserUtil.driver.findElement(By.tagName("tbody"));
		List<WebElement> list = Parent.findElements(By.tagName("tr"));
		Random r = new Random();
		int ran = r.nextInt(list.size());
		WebElement listItem = list.get(r.nextInt(ran));
		WebElement listedItem = listItem.findElement(By.xpath("//tr//td"));
		BrowserUtil.scrollToElement(listedItem);
		Highlighter.highlightElement(listedItem);
		listedItem.click();
	}
}
