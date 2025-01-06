package pageObjects.AtlantaMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiscoverTab {

	public WebDriver driver;
	public WebDriverWait wait;
	
	By DiscoverTab = By.xpath("//div[@class='imc-breakpoint-display--hide-tablet']/descendant::span[contains(text(),'Discover')]/../..");
	By ExhibitorDirectory = By.xpath("(//a[@href='/exhibitor/exhibitor-directory' and contains(text(),'Exhibitor Directory')])[1]");
	By AZbrandlisting = By.xpath("//a[@href='/exhibitor' and contains(text(),'A-Z Brand Listing')]");
	By FloorPlans = By.xpath("(//a[@href='/Market-Map' and contains(text(),'Floor Plans')])[2]");
	By ExploreAtlantaMarket = By.xpath("//a[@href='/exhibitor/Categories' and contains(text(),'Explore Atlanta Market')]");
	By ToolsAndInspiration = By.xpath("//a[@href='/News-and-Trends' and contains(text(),'Tools & Inspiration')]");
	By PlanYourMarket = By.xpath("//a[@href='/Attend/Plan-Your-Market' and contains(text(),'Plan Your Market')]");
	By WhatsNew = By.xpath("//a[@href='/Market-Info/Whats-New' and contains(text(),'What')]");
	By Events = By.xpath("//a[@href='/Attend/Events' and contains(text(),'Events')]");

	public DiscoverTab(WebDriver driver) {
		this.driver = driver; 			
	}
	
	public WebElement getDiscoverTab() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DiscoverTab));
		return driver.findElement(DiscoverTab);		
	}
	public WebElement getExhibitorDirectory() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExhibitorDirectory));
		return driver.findElement(ExhibitorDirectory);		
	}
	public WebElement getAZbrandlisting() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AZbrandlisting));
		return driver.findElement(AZbrandlisting);		
	}
	public WebElement getFloorPlans() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FloorPlans));
		return driver.findElement(FloorPlans);		
	}
	public WebElement getExploreAtlantaMarket() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExploreAtlantaMarket));
		return driver.findElement(ExploreAtlantaMarket);		
	}
	public WebElement getToolsAndInspiration() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ToolsAndInspiration));
		return driver.findElement(ToolsAndInspiration);		
	}
	public WebElement getPlanYourMarket() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(PlanYourMarket));
		return driver.findElement(PlanYourMarket);		
	}
	public WebElement getWhatsNew() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(WhatsNew));
		return driver.findElement(WhatsNew);		
	}
	public WebElement getEvents() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Events));
		return driver.findElement(Events);		
	}
		
}
