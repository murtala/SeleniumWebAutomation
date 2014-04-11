package community;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.BrowserUtil;
import utils.CustomFinder;

public class NotificationsModal {

	public void openNotifications(){
		CustomFinder.locateXpath("//div[@collection='notifications']//span", true, true);
	}
	
	public void openRandomNotification(){
		CustomFinder.locateXpath("//div[@collection='notifications']//span", true, true);
		CustomFinder.locateXpath("//ul[@ng-switch-when='notifications']", true, true);
		WebElement Parent = BrowserUtil.driver.findElement(By.xpath("//ul[@ng-switch-when='notifications']"));
		List<WebElement> list = Parent.findElements(By.tagName("li"));
		Random r = new Random();
		int ran =r.nextInt(list.size());
	//	WebElement listItem = list.get(r.nextInt(ran));
		//listItem.click();
		System.out.println(ran);


		
	}
	
	public void seeAll(){
		CustomFinder.locateXpath("//ul[@ng-switch-when='notifications']", true, true);
	}
}
