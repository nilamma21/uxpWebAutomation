package pageObjects.AmericasMart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMMarketsAndEventsPage {
	
	public WebDriver driver;
	public WebDriverWait wait;

	By amcfallcashcarry = By.xpath("(//a[@href='/Markets/Fall-Cash-and-Carry'])[position()=1]"); // Locator for Fall Cash and Carry
	By amcyearroundevents = By.xpath("//a[@href='/Year-Round/Calendar-of-Events']"); // Locator for Year Round Events
	By atlantaapparel = By.xpath("(//a[@href='https://atlanta-apparel.com/'])[position()=2]"); //Locator for Atlanta Apparel logo
	By amcspringmrkt = By.xpath("(//a[@href='/Markets/Spring-Market'])[position()=1]"); //Locator for Spring Market sub menu
	By amcspringcashcarry = By.xpath("(//a[@href='/Markets/Spring-Cash-and-Carry'])[position()=1]"); //Locator for Spring Cash & Carry sub menu
	By amcfallmarket = By.xpath("(//a[@href='/Markets/Fall-Market'])[position()=1]"); //Locator for Fall Market sub menu
	By atlantamarket = By.xpath("(//a[@href='https://atlantamarket.com/'])[position()=2]"); //Locator for Atlanta Market logo
	By attendournextmarket = By.xpath("//a[contains(text(),'Attend Our Next Market')]");
	By MarketDatesAndHour = By.xpath("//a[contains(text(),'Market Dates & Hours')]");
	
	public AMMarketsAndEventsPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getFallCashCarry() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcfallcashcarry));
		return driver.findElement(amcfallcashcarry);
	}
	
	public WebElement getYearRoundEvents() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcyearroundevents));
		return driver.findElement(amcyearroundevents);
	}
	public WebElement getAtlantaMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlantamarket));
		return driver.findElement(atlantamarket);
	}
	public WebElement getAtlantaApparel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlantaapparel));
		return driver.findElement(atlantaapparel);
	}
	public WebElement getAMCSpringMarket() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcspringmrkt));
		return driver.findElement(amcspringmrkt);
	}
	public WebElement getAMCSpringCashnCarry() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcspringcashcarry));
		return driver.findElement(amcspringcashcarry);
	}
	public WebElement getAMCFallMarket() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcfallmarket));
		return driver.findElement(amcfallmarket);
	}
	public WebElement getattendournextmarket() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(attendournextmarket));
		return driver.findElement(attendournextmarket);
	}
	public WebElement getMarketDatesAndHour() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketDatesAndHour));
		return driver.findElement(MarketDatesAndHour);
	}
}
