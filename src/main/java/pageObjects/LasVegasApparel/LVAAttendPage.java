package pageObjects.LasVegasApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVAAttendPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By LVAAttendTab = By.xpath("(//a[contains(text(),'Attend')])[1]"); // Locator for Attend tab in header
	By LVADining = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Dining')]");
	By LVATravel = By.xpath("//a[@href='/Attend/Travel']"); //Locator for Travel link
	By LVADiningGuide = By.xpath("//a[@href='/Attend/Dining']"); //Locator for Dining Guide link
	By LVAServicesAndAmenities = By.xpath("//a[@href='/Attend/Services-and-Amenities']"); //Locator for Service and Amenities
	By atlevents = By.xpath("//a[@href='/Attend/Events']"); //Locator for Events sub-menu
	By LVAWhyAttend = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Why Attend?')]"); //Locator for Why Attend link
	By LVAEvents = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Events')]");
	By LVParking = By.xpath("//a[@href='/Attend/Travel' and contains(text(),'Shuttles & Parking')]");
	By LVHotels = By.xpath("//a[@href='/Attend/Travel' and contains(text(),'Hotels')]");
	By LVAirTravel = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Air Travel')]");
	By LVTravel = By.xpath("(//a[contains(text(),'Travel')])[1]");
	By LVDownloadApp = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Download the App')]");
	
	public LVAAttendPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getLVAAttendTab() throws InterruptedException {
	  Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAAttendTab));
		return driver.findElement(LVAAttendTab);
	}
	
	public WebElement getLVATravel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVATravel));
		return driver.findElement(LVATravel);
	}
	
	public WebElement getLVADiningGuide() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVADiningGuide));
		return driver.findElement(LVADiningGuide);
	}
	
	public WebElement getLVAServicesAndAmenities() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAServicesAndAmenities));
		return driver.findElement(LVAServicesAndAmenities);
	}
	
	public WebElement getLVAEventsSubmenu() throws InterruptedException {
		return driver.findElement(atlevents);
	}
	
	public WebElement getLVADining() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVADining));
		return driver.findElement(LVADining);
	}

	public WebElement getLVAWhyAttend() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAWhyAttend));
		return driver.findElement(LVAWhyAttend);
	}

	public WebElement getLVAEvents() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAEvents));
		return driver.findElement(LVAEvents);
	}

	public WebElement getLVParking() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVParking));
		return driver.findElement(LVParking);
	}

	public WebElement getLVHotels() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVHotels));
		return driver.findElement(LVHotels);
	}

	public WebElement getLVTravel() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVTravel));
		return driver.findElement(LVTravel);
	}

	public WebElement getLVAirTravel() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAirTravel));
		return driver.findElement(LVAirTravel);
	}

	public WebElement getLVDownloadApp() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVDownloadApp));
		return driver.findElement(LVDownloadApp);
	}

}
