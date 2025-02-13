package pageObjects.AtlantaApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppDiscoverTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By ATLAppDiscoverTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Discover')]/../..");
	By DTExhibitorsAndProducts = By.xpath("(//a[@href='/exhibitor/exhibitor-directory' and contains(text(),'Exhibitors & Products')])[2]");
	By DTFloorPlans = By.xpath("(//a[@href='/Market-Map' and contains(text(),'Floor Plans')])[2]");
	By DTListOfBrands = By.xpath("(//a[@href='/exhibitor/directory' and contains(text(),'List of Brands')])[2]");
	By DTToolsAndInspirations = By.xpath("//a[@href='/The-Best-Of' and contains(text(),'Tools & Inspiration')]");
	By DTPlanYourMarket = By.xpath("//a[@href='/Attend/Plan-Your-Market' and contains(text(),'Plan Your Market')]");
	By DTExploreAtlanta = By.xpath("//a[@href='/Attend/Explore-Atlanta' and contains(text(),'Explore Atlanta')]");
	
	public ATLAppDiscoverTab(WebDriver driver) {
		this.driver = driver; 			
	}
	
	public WebElement getATLAppDiscoverTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAppDiscoverTab));
		return driver.findElement(ATLAppDiscoverTab);
	}
	public WebElement getDTExhibitorsAndProducts() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DTExhibitorsAndProducts));
		return driver.findElement(DTExhibitorsAndProducts);
	}
	public WebElement getDTFloorPlans() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DTFloorPlans));
		return driver.findElement(DTFloorPlans);
	}
	public WebElement getDTListOfBrands() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DTListOfBrands));
		return driver.findElement(DTListOfBrands);
	}
	public WebElement getDTToolsAndInspirations() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DTToolsAndInspirations));
		return driver.findElement(DTToolsAndInspirations);
	}
	public WebElement getDTPlanYourMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DTPlanYourMarket));
		return driver.findElement(DTPlanYourMarket);
	}
	public WebElement getDTExploreAtlanta() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DTExploreAtlanta));
		return driver.findElement(DTExploreAtlanta);
	}
	
}
