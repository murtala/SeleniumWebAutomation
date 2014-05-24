package community.header;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;
import utils.Highlighter;
import utils.Randomizer;

public class NotificationsModal {
	CustomFinder find = new CustomFinder();
	Randomizer ran = new Randomizer();
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);

	public void openNotifications() {
		find.byXpath("//div[@collection='notifications']//span");
	}

	public void openRandomNotification() {
		find.byXpath("//div[@collection='notifications']//span");
		WebElement Parent = BrowserUtil.driver.findElement(By.xpath("//ul[@ng-switch-when='notifications']"));
		List<WebElement> list = Parent.findElements(By.tagName("li"));
		ran.randomClick(list);
	}

	public void seeAll() {
		find.byXpath("//div[@collection='notifications']//span");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='fs-session-controls']/li[2]/div/ul")));	
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@role='menu']")));
		//find.byXpath(".//h4[@class='text-center']/a");  // does not work ??? WHYYYY
		BrowserUtil.driver.navigate().to("https://staging-accounts.fullscreen.net/notifications");
	}
}
