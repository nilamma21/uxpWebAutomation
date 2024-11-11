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

	By MarketsAndEventsTab = By.xpath("//a[@class='imc-navigation__tier1Link' and contains(text(),'Markets & Events')]");
	By amcfallcashcarry = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Fall Cash & Carry')]"); // Locator for Fall Cash and Carry
	By amcyearroundevents = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Year Round Events')]"); // Locator for Year Round Events
	By atlantaapparel = By.xpath("//a[@class='imc-navigation-2tier-imageLink' and @href='https://atlanta-apparel.com/']"); //Locator for Atlanta Apparel logo
	By amcspringmrkt = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Spring Market')]"); //Locator for Spring Market sub menu
	By amcspringcashcarry = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Spring Cash & Carry')]"); //Locator for Spring Cash & Carry sub menu
	By amcfallmarket = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Fall Market')]"); //Locator for Fall Market sub menu
	By atlantamarket = By.xpath("//a[@class='imc-navigation-2tier-imageLink' and @href='https://atlantamarket.com/']"); //Locator for Atlanta Market logo
	By attendournextmarket = By.xpath("//a[contains(text(),'Attend Our Next Market')]");
	By MarketDatesAndHour = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Market Dates & Hours')]");
	By CasualMarket = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Casual Market')]");
	
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
	public WebElement getMarketsAndEventsTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketsAndEventsTab));
		return driver.findElement(MarketsAndEventsTab);
	}
	public WebElement getCasualMarket() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(CasualMarket));
		return driver.findElement(CasualMarket);
	}
	
}
