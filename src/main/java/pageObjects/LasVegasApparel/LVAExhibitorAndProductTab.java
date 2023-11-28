package pageObjects.LasVegasApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVAExhibitorAndProductTab {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By LVAExhibitorAndProductTab = By.xpath("(//a[contains(text(),'Exhibitors & Products')])[1]");
	By LVAExhibitorDirectory = By.xpath("(//a[contains(text(),'Exhibitor Directory')])[1]");
	By LVAListOfBrands = By.xpath("(//a[contains(text(),'List of Brands')])[1]");
	By LVAOpenShowroom = By.xpath("(//a[contains(text(),'Open Showrooms')])[1]");
	By LVAFloorPlans = By.xpath("(//a[contains(text(),'Floor Plans')])[1]");
	
	public LVAExhibitorAndProductTab(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	public WebElement getLVAExhibitorAndProductTab() throws InterruptedException {
	  Thread.sleep(2000);
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(LVAExhibitorAndProductTab));
		return driver.findElement(LVAExhibitorAndProductTab);
	}
	public WebElement getLVAExhibitorDirectory() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(LVAExhibitorDirectory));
		return driver.findElement(LVAExhibitorDirectory);
	}
	public WebElement getLVAListOfBrands() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(LVAListOfBrands));
		return driver.findElement(LVAListOfBrands);
	}
	public WebElement getLVAOpenShowroom() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(LVAOpenShowroom));
		return driver.findElement(LVAOpenShowroom);
	}
	public WebElement getLVAFloorPlans() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(LVAFloorPlans));
		return driver.findElement(LVAFloorPlans);
	}
	
}
