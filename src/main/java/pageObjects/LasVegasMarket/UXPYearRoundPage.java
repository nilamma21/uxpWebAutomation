package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPYearRoundPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By YearRoundTab = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[1]"); //Locator for Year Round tab in header
	By YearRound = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[1]/div[1]/a[1]"); //Locator for Year Round option under Year Round
	By LasVegasDesignCenter = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[2]/div[1]/a[1]"); //Locator for Las Vegas Design Center option under Year Round
	By Expo = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[3]/div[1]/a[1]"); //Locator for The Expo under Year Round
	By MarketEvents = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[4]/div[1]/a[1]"); //Locator for Off Market Events under Year Round
	By VenueRental = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[4]/div[2]/a[1]"); //Locator for Venue Rental under Year Round
	By Shopzio = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[4]/div[3]/a[1]"); //Locator for Shopzio Exhibitors under Year Round
	By VerifyShopzio = By.xpath("//div[@class ='imc-gallery__item imc-exhibitors__panel']"); //Locator for verify Shopzio Exhibitors under Year Round
	By VerifyYearRoundSection = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]"); //Locator for Year Round section
	
	
	public UXPYearRoundPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getYearRoundTab() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(YearRoundTab));
		return driver.findElement(YearRoundTab);
	}
	
	public WebElement getYearRound(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(YearRound));
		return driver.findElement(YearRound);
	}

	public WebElement getLasVegasDesignCenter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LasVegasDesignCenter));
		return driver.findElement(LasVegasDesignCenter);
	}
	
	public WebElement getExpo() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Expo));
		return driver.findElement(Expo);
	}
	
	public WebElement getMarketEvents() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketEvents));
		return driver.findElement(MarketEvents);
	}
	
	public WebElement getVenueRental() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VenueRental));
		return driver.findElement(VenueRental);
	}
	
	public WebElement getShopzio() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Shopzio));
		return driver.findElement(Shopzio);
	}
	
	public WebElement getVerifyShopzio() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyShopzio));
		return driver.findElement(VerifyShopzio);
	}
	
	public WebElement getVerifyYearRoundSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyYearRoundSection));
		return driver.findElement(VerifyYearRoundSection);
	}
	
}