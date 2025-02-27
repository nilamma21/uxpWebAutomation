package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPExhibitorDirectoryPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ExhibitorDirectory = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Exhibitor Directory')]/../.."); // Locator for Exhibitor Directory on Home Page
	By EDSearchExhibitors = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Search Exhibitors')]");
	By EDAZBrandListing = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'A-Z Brand Listing')]");
	By EDFloorPlans = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Floor Plans')]");
	By EDPopularFilters = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Popular Filters')]");
	
	public UXPExhibitorDirectoryPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getExhibitorDirectory() throws InterruptedException {
		//Wait till Sign In page is displayed
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ExhibitorDirectory));
		return driver.findElement(ExhibitorDirectory);
	}
	public WebElement getEDSearchExhibitors() throws InterruptedException {
		//Wait till Sign In page is displayed
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EDSearchExhibitors));
		return driver.findElement(EDSearchExhibitors);
	}
	public WebElement getEDAZBrandListing() throws InterruptedException {
		//Wait till Sign In page is displayed
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EDAZBrandListing));
		return driver.findElement(EDAZBrandListing);
	}
	public WebElement getEDFloorPlans() throws InterruptedException {
		//Wait till Sign In page is displayed
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EDFloorPlans));
		return driver.findElement(EDFloorPlans);
	}
	public WebElement getEDPopularFilters() throws InterruptedException {
		//Wait till Sign In page is displayed
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(EDPopularFilters));
		return driver.findElement(EDPopularFilters);
	}
	
	
}


