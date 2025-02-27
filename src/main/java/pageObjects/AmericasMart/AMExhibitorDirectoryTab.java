package pageObjects.AmericasMart;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMExhibitorDirectoryTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By EDExhibitorDirectoryTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Exhibitor Directory')]/../..");
	By EDSearchExhibitor = By.xpath("//a[@href='/exhibitor/exhibitor-directory' and contains(text(),'Search Exhibitors')]");
	By EDAZBrandListing = By.xpath("//a[@href='/exhibitor/Directory' and contains(text(),'A-Z Brand Listing')]");
	By EDFloorPlans = By.xpath("(//a[@href='/Market-Map' and contains(text(),'Floor Plans')])[1]");
	By EDCategories = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Categories')]");
	
	public AMExhibitorDirectoryTab(WebDriver driver) {
		this.driver = driver; 	
	}
	
	public WebElement getEDExhibitorDirectoryTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EDExhibitorDirectoryTab));
		return driver.findElement(EDExhibitorDirectoryTab);
	}
	public WebElement getEDSearchExhibitor() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EDSearchExhibitor));
		return driver.findElement(EDSearchExhibitor);
	}
	public WebElement getEDAZBrandListing() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EDAZBrandListing));
		return driver.findElement(EDAZBrandListing);
	}
	public WebElement getEDFloorPlans() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EDFloorPlans));
		return driver.findElement(EDFloorPlans);
	}
	public WebElement getEDCategories() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EDCategories));
		return driver.findElement(EDCategories);
	}
	
	
}
