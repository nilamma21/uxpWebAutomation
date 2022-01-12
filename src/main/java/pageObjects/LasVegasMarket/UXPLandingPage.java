package pageObjects.LasVegasMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPLandingPage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By loginbtn= By.xpath("//a[contains(text(),'Login')]"); //Locator for Login button on app landing Page
	By marketplannerlinktext = By.xpath("//span[contains(text(),'s Market Planner')]"); //Locator for Market Planner link text
	By iunderstandbtn = By.xpath("//button[@id='gdpr-btn']"); //Locator for I Understand button
			
	public UXPLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getLogin() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		return driver.findElement(loginbtn);		
	}
	
	public WebElement getMPLinkText() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketplannerlinktext));
		return driver.findElement(marketplannerlinktext);		
	}	
	
	public WebElement getIUnderstandBtn() throws InterruptedException {
		Thread.sleep(15000);
		return driver.findElement(iunderstandbtn);		
	}
	
}
