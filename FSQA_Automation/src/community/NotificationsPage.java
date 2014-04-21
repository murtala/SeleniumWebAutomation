package community;

import java.util.Iterator;
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
	
	public void paginationLinks(){	//click on  random number, then click next then click previous	
		WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);	
		BrowserUtil.driver.navigate().to("https://staging-accounts.fullscreen.net/notifications");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("fs-pagination")));	
		WebElement pagination = BrowserUtil.driver.findElement(By.className("fs-pagination"));
		List<WebElement> pages = pagination.findElement(By.tagName("ul")).findElements(By.tagName("li"));
		Random r = new Random();
		int ran = r.nextInt(pages.size());
		
		while (ran ==1) {  //make sure not 1st page so to be able click previous
			ran = r.nextInt(pages.size());
		}    
		WebElement pagesNum = pages.get(ran);
		WebElement numPage = pagesNum.findElement(By.xpath("//a"));
		System.out.println(numPage.getTagName());
		BrowserUtil.scrollToElement(pagesNum);
		Highlighter.highlightElement(pagesNum);
		pagesNum.click();
		
		CustomFinder.locateXpath("//a[@class='next-page']", true, true); //click next
		CustomFinder.locateXpath("//a[@class='previous-page']", true, true); //click previous
	}
}
