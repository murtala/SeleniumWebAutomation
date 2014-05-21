package community.user;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;

public class Followers {
	
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);

	public Followers() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")));
		// h.highlightElement(driver.findElement(By.cssSelector(".avatar.sm.circle")));
		BrowserUtil.driver.findElement(By.xpath(".//*[@id='fs-application-wrapper']/nav/div/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Followers']")));
		BrowserUtil.driver.findElement(By.xpath("//a[text()='Followers']")).click();
	}
	
	public void message(){
		BrowserUtil.scrollToElement(BrowserUtil.driver.findElement(By.xpath("//message-button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//message-button")));
		BrowserUtil.driver.findElement(By.xpath("//message-button")).click();
		BrowserUtil.driver.navigate().back();;	
	}
	
	public void followUnfollow(){ // can't. ppl not being followed will not appear in that list
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//follow-button")));
			BrowserUtil.driver.findElement(By.xpath("//follow-button")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No followers ... ");
		}	
	}
	public void userList(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='user-list ng-scope']")));
		WebElement allUsers = BrowserUtil.driver.findElement(By.xpath(".//*[@class='user-list ng-scope']"));
		List<WebElement> users = allUsers.findElements(By.xpath(".//h5[@class='user-name zero-baseline']/a"));
								
		Random r = new Random();
		int ran;
		WebElement listItem;
		if(users.size() == 1){
			 ran = 1;
			  listItem = users.get((0));
		}else{
		 ran = r.nextInt(users.size());
		  listItem = users.get(r.nextInt(ran));
			
		}
		
		BrowserUtil.scrollToElement(listItem);
		listItem.click();
		

	}
	
}