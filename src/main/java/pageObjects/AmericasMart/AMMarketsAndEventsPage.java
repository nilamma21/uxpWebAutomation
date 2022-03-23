package pageObjects.AmericasMart;

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
	By atlantaapparel = By.xpath("(//a[@href='https://atlanta-apparel.com/'])[position()=1]"); //Locator for Atlanta Apparel logo
	By amcspringmrkt = By.xpath("(//a[@href='/Markets/Spring-Market'])[position()=1]"); //Locator for Spring Market sub menu
	By amcspringcashcarry = By.xpath("(//a[@href='/Markets/Spring-Cash-and-Carry'])[position()=1]"); //Locator for Spring Cash & Carry sub menu
	By amcfallmarket = By.xpath("(//a[@href='/Markets/Fall-Market'])[position()=1]"); //Locator for Fall Market sub menu
	By atlantamarket = By.xpath("(//a[@href='https://atlantamarket.com/'])[position()=1]"); //Locator for Atlanta Market logo
	
	public AMMarketsAndEventsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getFallCashCarry() throws InterruptedException {
		return driver.findElement(amcfallcashcarry);
	}
	
	public WebElement getYearRoundEvents() throws InterruptedException {
		return driver.findElement(amcyearroundevents);
	}
	public WebElement getAtlantaMarket() throws InterruptedException {
		return driver.findElement(atlantamarket);
	}
	public WebElement getAtlantaApparel() throws InterruptedException {
		return driver.findElement(atlantaapparel);
	}
	public WebElement getAMCSpringMarket() {
		return driver.findElement(amcspringmrkt);
	}
	public WebElement getAMCSpringCashnCarry() {
		return driver.findElement(amcspringcashcarry);
	}
	public WebElement getAMCFallMarket() {
		return driver.findElement(amcfallmarket);
	}
}
