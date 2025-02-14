package pageObjects.AmericasMart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMVisitTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By amcMarketsAndEventsTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Visit')]/../.."); // Locator for Exhibit Tab
	By amcESearchExhibitor = By.xpath("(//a[@href='/exhibitor/exhibitor-directory' and contains(text(),'Search Exhibitors')])[2]");
	By amcEAZBrandListing = By.xpath("(//a[@href='/exhibitor/directory' and contains(text(),'A-Z Brand Listing')])[2]");
	By amcEFloorPlans = By.xpath("(//a[@href='/Market-Map' and contains(text(),'Floor Plans')])[2]");
	By amcETrave = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::span[contains(text(),'Travel')]");
	
	public AMVisitTab(WebDriver driver) {
		this.driver = driver; 			
	}
	
	public WebElement getamcMarketsAndEventsTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcMarketsAndEventsTab));
		return driver.findElement(amcMarketsAndEventsTab);
	}
	public WebElement getamcESearchExhibitor() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcESearchExhibitor));
		return driver.findElement(amcESearchExhibitor);
	}
	public WebElement getamcEAZBrandListing() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcEAZBrandListing));
		return driver.findElement(amcEAZBrandListing);
	}
	public WebElement getamcEFloorPlans() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcEFloorPlans));
		return driver.findElement(amcEFloorPlans);
	}
	public WebElement getamcETrave() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcETrave));
		return driver.findElement(amcETrave);
	}
	
	
}
