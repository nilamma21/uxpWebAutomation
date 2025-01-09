package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPLandingPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By loginbtn= By.xpath("//a[contains(text(),'Login')]"); //Locator for Login button on app landing Page
	By marketplannerlinktext = By.xpath("//span[contains(text(),'s Market Planner')][1]"); //Locator for Market Planner link text
	By iunderstandbtn = By.xpath("//button[@id='gdpr-btn']"); //Locator for I Understand button
	By mpsignoutbtn = By.xpath("(//a[@href='/imc-api/account/v1/logout'])[position()=1]"); //Locator for Sign out button
	By closemrktadbtn = By.xpath("//div[@class=' contact-exit']"); //Locator for Close button of Market ad
	By planYourMarket = By.xpath("//span[@title='Plan Your Market']");//Locator for plan your market
	By marketRecap = By.xpath("//*[@class='imc-breakpoint-display--hide-mobile imc-header-subnav__link-text max-two-lines' and @title='Market Recap']");//Locator for Market Recap

	public UXPLandingPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getLogin() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginbtn));
		return driver.findElement(loginbtn);		
	}
	
	public WebElement getMPLinkText() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketplannerlinktext));
		return driver.findElement(marketplannerlinktext);		
	}	
	
	public WebElement getIUnderstandBtn() throws InterruptedException {
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(iunderstandbtn));
		return driver.findElement(iunderstandbtn);		
	}
	
	public WebElement getMPSignOutBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(mpsignoutbtn));
		return driver.findElement(mpsignoutbtn);		
	}	
	
	public WebElement getCloseMarktAdBtn() throws InterruptedException{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(closemrktadbtn));
		return driver.findElement(closemrktadbtn);		
	}
	
	public WebElement getplanYourMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(planYourMarket));
		return driver.findElement(planYourMarket);
	}
	
	public WebElement getMarketRecap() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketRecap));
		return driver.findElement(marketRecap);
	}
	
}
