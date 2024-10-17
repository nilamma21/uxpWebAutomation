package pageObjects.LasVegasMarket;

import java.time.Duration;

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
	By webnevnts = By.xpath("//a[contains(text(),'Events and Seminars')]"); //Locator for Webinars & Events sub-menu
	By showspecials = By.xpath("//a[contains(text(),'Show Specials')]"); //Locator for Show Specials sub-menu
	By virtualresources = By.xpath("//a[contains(text(),'Virtual Resources')]"); //Locator for Virtual Resources sub-menu
	By keydestn = By.xpath("//a[contains(text(),'Key Destinations')]");//Locator for Key Destinations sub-menu
	By newsntrends  =By.xpath("//a[contains(text(),'News & Trends')]"); //Locator for News & Trends sub-menu
	By mrktrecap = By.xpath("//a[contains(text(),'Market Recap')]"); //Locator for market Recap sub-menu
	By thingstodo = By.xpath("//a[contains(text(),'Things to Do')]");//Locator for things to do sub-menu
	By socialmedia = By.xpath("//a[contains(text(),'Social Media')]");//Locator for SocialMedia sub-menu
	
	public UXPExploreMarketPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getExploreMarketTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(exploremarkettab));
		return driver.findElement(exploremarkettab);		
	}
	public WebElement getExploreLVMMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(explorelvm));
		return driver.findElement(explorelvm);		
	}
	public WebElement getWebinarsnEventsMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(webnevnts));
		return driver.findElement(webnevnts);		
	}
	public WebElement getShowSpecialsMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(showspecials));
		return driver.findElement(showspecials);		
	}
	public WebElement getVirtualResourcesMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(virtualresources));
		return driver.findElement(virtualresources);		
	}
	public WebElement getKeyDestinationsMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(keydestn));
		return driver.findElement(keydestn);		
	}
	public WebElement getNewsnTrendsMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(newsntrends));
		return driver.findElement(newsntrends);		
	}
	public WebElement getMarketRecapMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(mrktrecap));
		return driver.findElement(mrktrecap);		
	}
	public WebElement getThingsToDoMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(thingstodo));
		return driver.findElement(thingstodo);		
	}
	public WebElement getSocialMediaMenu(){
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.elementToBeClickable(socialmedia));
		return driver.findElement(socialmedia);		
	}
}


