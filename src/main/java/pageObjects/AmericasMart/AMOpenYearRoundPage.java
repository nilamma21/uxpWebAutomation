package pageObjects.AmericasMart;

import java.time.Duration;

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
	By amcOpenYearRoundShowrooms=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Open Year Round Showrooms')]"); // Locator for Showroom Direct
	By amcExhibitorDirectory=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Exhibitor Directory')]");
	By amcOpenYearRoundShowroomsHeader=By.xpath("//span[@class='imc-type--color-basic-white']");// Locator for Open Year Round Showrooms page Header
	By amcExhibitorDirectoryHeader=By.xpath("//h2[contains(text(),'Exhibitor Directory')]");// Locator for Exhibitor Directory page Header
	By amcFloorPlans=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Floor Plans')]"); // Locator for Floor Plan
	By amcCampOverview=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Campus Overview')]"); // Locator for Camp Overview
	By amcVisit=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Visit')]"); //Locator for Visit
	By amcHowToRegister=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'How to Register')]"); //Locator for How to Register
	By amcCalendarOfEvents=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Calendar of Events')]");
	By amcDesigners=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'For Designers')]");	
	By amcparkingtransp = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Parking & Transportation')]"); //Locator for Parking & Trasp. sub-menu
	By amchotels = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Hotels')]"); //Locator for Hotel sub-menu
	
	public AMOpenYearRoundPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getOpenYearRoundTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcOpenYearRoundTab));
		return driver.findElement(amcOpenYearRoundTab);
	}
	
	public WebElement getAboutYearRound() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcAboutYearRound));
		return driver.findElement(amcAboutYearRound);
	}
	
	public WebElement getAboutYearRoundPageHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcAboutYearRoundHeader));
		return driver.findElement(amcAboutYearRoundHeader);
	}
	
	public WebElement getOpenYearRoundShowrooms() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcOpenYearRoundShowrooms));
		return driver.findElement(amcOpenYearRoundShowrooms);
	}	
	
	public WebElement getExhibitorDirectory() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcExhibitorDirectory));
		return driver.findElement(amcExhibitorDirectory);			
	}
	
	public WebElement getOpenYearRoundShowroomsPageHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcOpenYearRoundShowroomsHeader));
		return driver.findElement(amcOpenYearRoundShowroomsHeader);		
	}
	
	public WebElement getExhibitorDirectoryPageHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcExhibitorDirectoryHeader));
		return driver.findElement(amcExhibitorDirectoryHeader);		
	}
	
	public WebElement getFloorPlans() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcFloorPlans));
		return driver.findElement(amcFloorPlans);
	}
	
	public WebElement getCampOverview() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcCampOverview));
		return driver.findElement(amcCampOverview);
	}
	
	public WebElement getVisit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcVisit));
		return driver.findElement(amcVisit);
	}
	
	public WebElement getHowToReg() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcHowToRegister));
		return driver.findElement(amcHowToRegister);
	}
	
	public WebElement getCalendarEvents() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcCalendarOfEvents));
		return driver.findElement(amcCalendarOfEvents);
	}
	
	public WebElement getDesigners() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcDesigners));
		return driver.findElement(amcDesigners);
	}
	
	public WebElement getParknTranspSubmenu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amcparkingtransp));
		return driver.findElement(amcparkingtransp);
	}
	
	public WebElement getHotelsSubmenu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(amchotels));
		return driver.findElement(amchotels);
	}
	
	public WebElement gethowtoregister() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(howtoregister));
		return driver.findElement(howtoregister);
	}
	
}

