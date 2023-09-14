package pageObjects.AmericasMart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMOpenYearRoundPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By amcOpenYearRoundTab = By.xpath("//a[contains(text(),'Open Year Round')]"); // Locator for Open Year Round Tab
	By amcAboutYearRound=By.xpath("//a[@title='About Year Round at AmericasMart']"); // Locator for About Year Round
	By amcAboutYearRoundHeader=By.xpath("(//a[contains(text(),'Open Year Round')])[2]");// Locator for About Year Round page Header
	By howtoregister = By.xpath("//a[contains(text(),'How to Register') and @class='imc-link imc-link--invert imc-navigation__tier2Link']");
	By amcOpenYearRoundShowrooms=By.xpath("//a[contains(text(),'Open Year Round Showrooms') and @class='imc-link imc-link--invert imc-navigation__tier2Link']"); // Locator for Showroom Direct
	By amcExhibitorDirectory=By.xpath("//a[@href='/exhibitor/exhibitor-directory' and contains(text(), 'Exhibitor Directory')]");
	By amcOpenYearRoundShowroomsHeader=By.xpath("//h1[contains(text(),'Open Year Round Showrooms at AmericasMart')]");// Locator for Open Year Round Showrooms page Header
	By amcExhibitorDirectoryHeader=By.xpath("//h2[contains(text(),'Exhibitor Directory')]");// Locator for Exhibitor Directory page Header
	By amcFloorPlans=By.xpath("//a[@href='/Market-Map' or contains(text(),'Floor Plans')]"); // Locator for Floor Plan
	By amcCampOverview=By.xpath("//a[@href='/Year-Round/Campus-Overview']"); // Locator for Camp Overview
	By amcVisit=By.xpath("//a[@href='/Year-Round/Visit']"); //Locator for Visit
	By amcHowToRegister=By.xpath("//a[@href='/Year-Round/How-to-Register' and contains(text(),'How to Register')]"); //Locator for How to Register
	By amcCalendarOfEvents=By.xpath("//a[@href='/Year-Round/Calendar-of-Events' and contains(text(),'Calendar of Events')]");
	By amcDesigners=By.xpath("//a[@href='/Year-Round/For-Designers']");	
	By amcparkingtransp = By.xpath("//a[@href='/Year-Round/Parking-and-Transportation']"); //Locator for Parking & Trasp. sub-menu
	By amchotels = By.xpath("//a[@href='/Markets/Hotels']"); //Locator for Hotel sub-menu
	
	public AMOpenYearRoundPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getOpenYearRoundTab() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcOpenYearRoundTab));
		return driver.findElement(amcOpenYearRoundTab);
	}
	
	public WebElement getAboutYearRound() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcAboutYearRound));
		return driver.findElement(amcAboutYearRound);
	}
	
	public WebElement getAboutYearRoundPageHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcAboutYearRoundHeader));
		return driver.findElement(amcAboutYearRoundHeader);
	}
	
	public WebElement getOpenYearRoundShowrooms() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcOpenYearRoundShowrooms));
		return driver.findElement(amcOpenYearRoundShowrooms);
	}	
	
	public WebElement getExhibitorDirectory() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcExhibitorDirectory));
		return driver.findElement(amcExhibitorDirectory);			
	}
	
	public WebElement getOpenYearRoundShowroomsPageHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcOpenYearRoundShowroomsHeader));
		return driver.findElement(amcOpenYearRoundShowroomsHeader);		
	}
	
	public WebElement getExhibitorDirectoryPageHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcExhibitorDirectoryHeader));
		return driver.findElement(amcExhibitorDirectoryHeader);		
	}
	
	public WebElement getFloorPlans() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcFloorPlans));
		return driver.findElement(amcFloorPlans);
	}
	
	public WebElement getCampOverview() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcCampOverview));
		return driver.findElement(amcCampOverview);
	}
	
	public WebElement getVisit() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcVisit));
		return driver.findElement(amcVisit);
	}
	
	public WebElement getHowToReg() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcHowToRegister));
		return driver.findElement(amcHowToRegister);
	}
	
	public WebElement getCalendarEvents() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcCalendarOfEvents));
		return driver.findElement(amcCalendarOfEvents);
	}
	
	public WebElement getDesigners() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcDesigners));
		return driver.findElement(amcDesigners);
	}
	
	public WebElement getParknTranspSubmenu() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amcparkingtransp));
		return driver.findElement(amcparkingtransp);
	}
	
	public WebElement getHotelsSubmenu() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(amchotels));
		return driver.findElement(amchotels);
	}
	
	public WebElement gethowtoregister() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(howtoregister));
		return driver.findElement(howtoregister);
	}
	
}

