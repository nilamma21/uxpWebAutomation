package pageObjects.LasVegasApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVAAttendPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By LVAAttendTab = By.xpath("(//a[contains(text(),'Attend')])[1]"); // Locator for Attend tab in header
	By LVADining = By.xpath("//a[contains(text(),'Dining')]");
	By LVATravel = By.xpath("//a[@href='/Attend/Travel']"); //Locator for Travel link
	By LVADiningGuide = By.xpath("//a[@href='/Attend/Dining']"); //Locator for Dining Guide link
	By LVAServicesAndAmenities = By.xpath("//a[@href='/Attend/Services-and-Amenities']"); //Locator for Service and Amenities
	By atlevents = By.xpath("//a[@href='/Attend/Events']"); //Locator for Events sub-menu
	By LVAWhyAttend = By.xpath("(//a[contains(text(),'Why Attend?')][1])"); //Locator for Why Attend link
	By LVAEvents = By.xpath("//a[@href='/Attend/Events']");
	By LVParking = By.xpath("(//a[@href='/Attend/Travel#parking'])[1]");
	By LVHotels = By.xpath("(//a[@href='/Attend/Travel#hotels\'])[1]");
	By LVAirTravel = By.xpath("(//a[@href='/Attend/Travel#flights\'])[1]");
	By LVTravel = By.xpath("(//a[contains(text(),'Travel')])[1]");
	By LVDownloadApp = By.xpath("//a[contains(text(),'Download the App')]");
	
	public LVAAttendPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getLVAAttendTab() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAAttendTab));
		return driver.findElement(LVAAttendTab);
	}
	
	public WebElement getLVATravel() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(LVATravel));
		return driver.findElement(LVATravel);
	}
	
	public WebElement getLVADiningGuide() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(LVADiningGuide));
		return driver.findElement(LVADiningGuide);
	}
	
	public WebElement getLVAServicesAndAmenities() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(LVAServicesAndAmenities));
		return driver.findElement(LVAServicesAndAmenities);
	}
	
	public WebElement getLVAEventsSubmenu() throws InterruptedException {
		return driver.findElement(atlevents);
	}
	
	public WebElement getLVADining() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(LVADining));
		return driver.findElement(LVADining);
	}

	public WebElement getLVAWhyAttend() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(LVAWhyAttend));
		return driver.findElement(LVAWhyAttend);
	}

	public WebElement getLVAEvents() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAEvents));
		return driver.findElement(LVAEvents);
	}

	public WebElement getLVParking() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVParking));
		return driver.findElement(LVParking);
	}

	public WebElement getLVHotels() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVHotels));
		return driver.findElement(LVHotels);
	}

	public WebElement getLVTravel() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVTravel));
		return driver.findElement(LVTravel);
	}

	public WebElement getLVAirTravel() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAirTravel));
		return driver.findElement(LVAirTravel);
	}

	public WebElement getLVDownloadApp() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVDownloadApp));
		return driver.findElement(LVDownloadApp);
	}

}
