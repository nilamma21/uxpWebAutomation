package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPYearRoundPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By YearRoundTab = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[1]/a[1]"); //Locator for Year Round tab in header
	By YearRound = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[1]/div[1]/a[1]"); //Locator for Year Round option under Year Round
	By LasVegasDesignCenter = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[2]/div[1]/a[1]"); //Locator for Las Vegas Design Center option under Year Round
	By Expo = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[3]/div[1]/a[1]"); //Locator for The Expo under Year Round
	By MarketEvents = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[4]/div[1]/a[1]"); //Locator for Off Market Events under Year Round
	By VenueRental = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[4]/div[2]/a[1]"); //Locator for Venue Rental under Year Round
	By Shopzio = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]/div[4]/div[3]/a[1]"); //Locator for Shopzio Exhibitors under Year Round
	By VerifyShopzio = By.xpath("//div[@class ='imc-gallery__item imc-exhibitors__panel']"); //Locator for verify Shopzio Exhibitors under Year Round
	By VerifyYearRoundSection = By.xpath("//div[@class ='imc-section']/div[1]/div[6]/div[2]"); //Locator for Year Round section
	
	
	public UXPYearRoundPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getYearRoundTab() throws InterruptedException{
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(YearRoundTab));
		return driver.findElement(YearRoundTab);

	}
	
	public WebElement getYearRound(){
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(YearRound));
		return driver.findElement(YearRound);

	}

	public WebElement getLasVegasDesignCenter() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LasVegasDesignCenter));
		return driver.findElement(LasVegasDesignCenter);

	}
	
	public WebElement getExpo() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Expo));
		return driver.findElement(Expo);

	}
	
	public WebElement getMarketEvents() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketEvents));
		return driver.findElement(MarketEvents);

	}
	
	public WebElement getVenueRental() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VenueRental));
		return driver.findElement(VenueRental);

	}
	
	public WebElement getShopzio() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Shopzio));
		return driver.findElement(Shopzio);

	}
	
	public WebElement getVerifyShopzio() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyShopzio));
		return driver.findElement(VerifyShopzio);

	}
	
	public WebElement getVerifyYearRoundSection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyYearRoundSection));
		return driver.findElement(VerifyYearRoundSection);

	}
	
	
}