package pageObjects.LasVegasMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPExploreMarketPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By exploremarkettab = By.xpath("//a[contains(text(),'Explore Market')]"); //Locator for Explore Market tab
	By explorelvm = By.xpath("//a[contains(text(),'Explore Las Vegas Market')]"); //Locator for Explore LVM Sub-menu
	By webnevnts = By.xpath("//a[contains(text(),'Webinars & Events')]"); //Locator for Webinars & Events sub-menu
	By showspecials = By.xpath("//a[contains(text(),'Show Specials')]"); //Locator for Show Specials sub-menu
	By virtualresources = By.xpath("//a[contains(text(),'Virtual Resources')]"); //Locator for Virtual Resources sub-menu
	By keydestn = By.xpath("//a[contains(text(),'Key Destinations')]");//Locator for Key Destinations sub-menu
	By newsntrends  =By.xpath("//a[contains(text(),'News & Trends')]"); //Locator for News & Trends sub-menu
	By mrktrecap = By.xpath("//a[contains(text(),'Market Recap')]"); //Locator for market Recap sub-menu
	By thingstodo = By.xpath("//a[contains(text(),'Things to Do')]");//Locator for things to do sub-menu
	By socialmedia = By.xpath("//a[contains(text(),'Social Media')]");//Locator for SocialMedia sub-menu
	
	public UXPExploreMarketPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getExploreMarketTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(exploremarkettab));
		return driver.findElement(exploremarkettab);		
	}
	public WebElement getExploreLVMMenu(){
		return driver.findElement(explorelvm);		
	}
	public WebElement getWebinarsnEventsMenu(){
		return driver.findElement(webnevnts);		
	}
	public WebElement getShowSpecialsMenu(){
		return driver.findElement(showspecials);		
	}
	public WebElement getVirtualResourcesMenu(){
		return driver.findElement(virtualresources);		
	}
	public WebElement getKeyDestinationsMenu(){
		return driver.findElement(keydestn);		
	}
	public WebElement getNewsnTrendsMenu(){
		return driver.findElement(newsntrends);		
	}
	public WebElement getMarketRecapMenu(){
		return driver.findElement(mrktrecap);		
	}
	public WebElement getThingsToDoMenu(){
		return driver.findElement(thingstodo);		
	}
	public WebElement getSocialMediaMenu(){
		return driver.findElement(socialmedia);		
	}
}


