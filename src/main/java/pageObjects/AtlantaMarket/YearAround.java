package pageObjects.AtlantaMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YearAround {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By YearRoundTab = By.xpath("//div[@class='imc-breakpoint-display--hide-tablet']/descendant::span[contains(text(),'Year Round')]/../..");
	By YearRoundLink = By.xpath("//a[@href='/Open-Year-Round' and contains(text(),'Year Round')]");
	By ExhibitorDirectoryLink = By.xpath("(//a[@href='/exhibitor/exhibitor-directory' and contains(text(),'Exhibitor Directory')])[2]");
	By AZBrandListingLink = By.xpath("(//a[@href='/exhibitor' and contains(text(),'A-Z Brand Listing')])[2]");
	By FloorPlansLink = By.xpath("(//a[@href='/Market-Map' and contains(text(),'Floor Plans')])[3]");
	By ContactUsLink = By.xpath("(//a[contains(text(),'Contact Us')])[1]");
	
	public YearAround(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getYearRoundTab() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(YearRoundTab));
		return driver.findElement(YearRoundTab);		
	}
	public WebElement getYearRoundLink() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(YearRoundLink));
		return driver.findElement(YearRoundLink);		
	}
	public WebElement getExhibitorDirectoryLink() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExhibitorDirectoryLink));
		return driver.findElement(ExhibitorDirectoryLink);		
	}
	public WebElement getAZBrandListingLink() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AZBrandListingLink));
		return driver.findElement(AZBrandListingLink);		
	}
	public WebElement getFloorPlansLink() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FloorPlansLink));
		return driver.findElement(FloorPlansLink);		
	}
	public WebElement getContactUsLink() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactUsLink));
		return driver.findElement(ContactUsLink);		
	}
	
}
