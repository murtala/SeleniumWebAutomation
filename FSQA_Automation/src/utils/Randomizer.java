package utils;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Randomizer {  // in works

	public void randomClick(List<WebElement> list){
		//WebElement Parent = BrowserUtil.driver.findElement(By.tagName("tbody"));
		//List<WebElement> list = Parent.findElements(By.tagName("tr"));
		Random r = new Random();
		int  ran = r.nextInt(list.size())+1;
		WebElement listItem;
		System.out.println("ran: " +ran + " size: "+list.size());
		if(list.size() == 1 || list.size() == 0){
			 ran = 1;
			  listItem = list.get((0));
		}else{
		 
		  listItem = list.get(r.nextInt(ran));
		}
		
		//BrowserUtil.scrollToElement(listItem);
		listItem.click();
	}
}
