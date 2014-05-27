package utils;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Randomizer { // in works

	PageScroller scroller = new PageScroller();
	CustomFinder find = new CustomFinder();

	public void randomClick(List<WebElement> list) {
		Random r = new Random();
		int ran = r.nextInt(list.size()) + 1;
		WebElement listItem;
		System.out.println("ran: " + ran + " size: " + list.size());
		if (list.size() == 1 || list.size() == 0) {
			ran = 1;
			listItem = list.get((0));
		} else {

			listItem = list.get(r.nextInt(ran));
		}
		find.byElement(listItem);
		//listItem.click();
	}
	
	public void randomClickNS(List<WebElement> list) {
		Random r = new Random();
		int ran = r.nextInt(list.size()) + 1;
		WebElement listItem;
		System.out.println("ran: " + ran + " size: " + list.size());
		if (list.size() == 1 || list.size() == 0) {
			ran = 1;
			listItem = list.get((0));
		} else {

			listItem = list.get(r.nextInt(ran));
		}
		find.byElementNS(listItem);
		//listItem.click();
	}
	
	public WebElement getRandomClick(List<WebElement> list) { // with a return value
		Random r = new Random();
		int ran = r.nextInt(list.size()) + 1;
		WebElement listItem;
		System.out.println("ran: " + ran + " size: " + list.size());
		if (list.size() == 1 || list.size() == 0) {
			ran = 1;
			listItem = list.get((0));
		} else {

			listItem = list.get(r.nextInt(ran));
		}
		//find.byElement(listItem);
		//listItem.click();
		return listItem;
	}
}
