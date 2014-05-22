package groups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;

public class Groups {

	WebDriver driver = BrowserUtil.driver;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public Groups() {
		driver.get("https://staging-community.fullscreen.net/groups");
	}
	
	/*create a group
	 * for visibility, only "Secret", "Open", and "closed" are available
	 * there should be no erro on page, or else won't create
	 */
	public void createGroup(String groupName, String groupDesc, String visibility, Boolean playlist, Boolean limit){
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[@ng-click='createGroup()']")));
		//create the group
		driver.findElement(By.xpath(".//button[@ng-click='createGroup()']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("groupEditForm")));
		//enter name and decription
		driver.findElement(By.id("group-edit-name")).sendKeys(groupName);
		driver.findElement(By.id("group-edit-description")).sendKeys(groupDesc);
		//visibility of the group
		switch (visibility) {
		case "Secret":
			driver.findElement(By.xpath(".//*[@class='radio'][3]//input")).click();
			break;
		case "Open":
			driver.findElement(By.xpath(".//*[@class='radio'][1]//input")).click();
			break;
		case "Closed":
			driver.findElement(By.xpath(".//*[@class='radio'][2]//input")).click();
			break;
		default:
			System.out.println("No supported option selected or wirtten");
			break;
		}
		//addd playlist or not
		if (!playlist){
			driver.findElement(By.xpath(".//input[@ng-checked='changes.create_playlists']")).click();
		}
		//limit membership to 100
		if (limit){
			driver.findElement(By.xpath(".//input[@ng-checked='changes.limit_by_reach']")).click();
		}
		//create the group
		driver.findElement(By.xpath(".//button[@ng-click='submit()']")).click();
	}
}


//.//*[@class='form-group'][3]