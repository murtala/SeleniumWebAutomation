package community.footer;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.CustomFinder;

public class Footer {
	WebDriverWait wait = new WebDriverWait(BrowserUtil.driver, 30);
	Actions action = new Actions(BrowserUtil.driver);
	CustomFinder find = new CustomFinder();

	public void mobileLink() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='global-footer-mobile ng-binding']")));
		String linkText = "Mobile";
		find.byElement(BrowserUtil.driver.findElement(By.linkText("linkText")));
		//CustomFinder.locateLinkText(linkText, false, true);
		BrowserUtil.driver.navigate().back();
	}

	public void helpCenterLink() {
		BrowserUtil.driver.navigate().refresh();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Fullscreen Help Center']")));

		String linkText = " help center! ";
	//	CustomFinder.locateLinkText(linkText, false, true);
		find.byElement(BrowserUtil.driver.findElement(By.linkText("linkText")));
		// CustomFinder.locateXpath("//*[@title='Fullscreen Help Center']",
		// true, true);
		BrowserUtil.driver.navigate().back();
	}

	public void moreLinks() {
		String xpath = "//*[@class='dropdown popover global-footer-links']//* [@data-toggle='dropdown']";
		//CustomFinder.locateXpath(xpath, false, true);
		find.byXpath(xpath);

		// click links in 1st section
		String xpathExpression = "//div[@class='dropdown-menu top tick-left']/dl[1]";
		WebElement lsect1 = BrowserUtil.driver.findElement(By.xpath(xpathExpression));
		List<WebElement> lsect1ele = lsect1.findElements(By.tagName("a"));

		for (int i = 0; i < lsect1ele.size(); i++) {
			lsect1ele.get(i).click();
			BrowserUtil.driver.navigate().back();
			find.byXpath(xpath);
			//CustomFinder.locateXpath(xpath, false, true);
			lsect1 = BrowserUtil.driver.findElement(By.xpath(xpathExpression));
			lsect1ele = lsect1.findElements(By.tagName("a"));
		}

		// click links in 2nd section
		String xpathExpression2 = "//div[@class='dropdown-menu top tick-left']/dl[2]";
		WebElement lsect2 = BrowserUtil.driver.findElement(By.xpath(xpathExpression2));
		List<WebElement> lsect2ele = lsect2.findElements(By.tagName("a"));

		for (int j = 0; j < lsect2ele.size(); j++) {
			lsect2ele.get(j).click();
			BrowserUtil.driver.navigate().back();
			find.byXpath(xpath);
			//CustomFinder.locateXpath(xpath, false, true);
			lsect2 = BrowserUtil.driver.findElement(By.xpath(xpathExpression2));
			lsect2ele = lsect2.findElements(By.tagName("a"));
		}
	}

	public void selectLanguages() {
		String xpath = "//div[@class='dropdown language-picker popover']//a[@class='dropdown-toggle ng-binding']";
		find.byXpath(xpath);
	//	CustomFinder.locateXpath(xpath, false, true);

		// click links lang window
		String xpathExpression = "//div[@class='dropdown language-picker popover open']";

		WebElement langsList = BrowserUtil.driver.findElement(By.xpath(xpathExpression));
		List<WebElement> langs = langsList.findElements(By.tagName("ul"));

		for (int i = 0; i < langs.size(); i++) {
			langs.get(i).click();
			xpath = "//div[@class='dropdown language-picker popover']//a[@class='dropdown-toggle ng-binding']";
			find.byXpath(xpath);
			//CustomFinder.locateXpath(xpath, false, true);
			xpathExpression = "//div[@class='dropdown language-picker popover open']";

			langsList = BrowserUtil.driver.findElement(By.xpath(xpathExpression));
			langs = langsList.findElements(By.tagName("ul"));
			System.out.println(langs.get(i).getText());
		}
	}
}
