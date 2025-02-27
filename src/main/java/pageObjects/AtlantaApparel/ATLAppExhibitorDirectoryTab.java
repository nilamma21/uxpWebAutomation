package pageObjects.AtlantaApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppExhibitorDirectoryTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By ATLAppExhibitorDirectoryTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Exhibitor Directory')]/../..");
	By EDTExhibitorsAndProducts = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Exhibitors & Products')]");
	By EDTFloorPlans = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Floor Plans')]");
	By EDTListOfBrands = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'List of Brands')]");
	By EDTCategories = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Categories')]");
	
	
	public ATLAppExhibitorDirectoryTab(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getATLAppExhibitorDirectoryTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAppExhibitorDirectoryTab));
		return driver.findElement(ATLAppExhibitorDirectoryTab);
	}
	public WebElement getEDTExhibitorsAndProducts() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDTExhibitorsAndProducts));
		return driver.findElement(EDTExhibitorsAndProducts);
	}
	public WebElement getEDTFloorPlans() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDTFloorPlans));
		return driver.findElement(EDTFloorPlans);
	}
	public WebElement getEDTListOfBrands() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDTListOfBrands));
		return driver.findElement(EDTListOfBrands);
	}
	public WebElement getEDTCategories() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EDTCategories));
		return driver.findElement(EDTCategories);
	}
	
	
}
