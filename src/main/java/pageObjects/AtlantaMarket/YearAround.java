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
	By MarketsLink = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Markets')]");
	By YearRoundLink = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Year Round')]");
	By ExhibitorDirectoryLink = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Exhibitor Directory')]");
	By AZBrandListingLink = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'A-Z Brand Listing')]");
	By FloorPlansLink = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Floor Plans')]");
	By ContactUsLink = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Contact Us')]");
	
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
	public WebElement getMarketsLink() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketsLink));
		return driver.findElement(MarketsLink);		
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
