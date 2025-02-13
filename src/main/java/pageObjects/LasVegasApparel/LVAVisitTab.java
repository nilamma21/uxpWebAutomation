package pageObjects.LasVegasApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVAVisitTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By LVAVisitTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Visit')]/../..");
	By LVAWhyAttend = By.xpath("//a[@href='/Attend' and contains(text(),'Why Attend?')]"); //Locator for Why Attend link
	By LVARigister = By.xpath("//a[@href='/About/Market-Dates-and-Hours' and contains(text(),'Register')]");
	By LVTravel = By.xpath("//a[@href='/Attend/Travel' and contains(text(),'Travel')]");
	By LVAEvents = By.xpath("//a[@href='/Attend/Events' and contains(text(),'Events')]");
	By LVDining = By.xpath("//a[@href='/Attend/Dining' and contains(text(),'Dining')]");
	By LVServicesAndAmenities = By.xpath("//a[@href='/Attend/Services-and-Amenities' and contains(text(),'Services & Amenities')]");
	By LVDownloadApp = By.xpath("//a[@href='/Attend/Plan-Your-Market' and contains(text(),'Download the App')]");
	
	public LVAVisitTab(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getLVAVisitTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAVisitTab));
		return driver.findElement(LVAVisitTab);
	}
	public WebElement getLVAWhyAttend() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAWhyAttend));
		return driver.findElement(LVAWhyAttend);
	}
	public WebElement getLVARigister() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVARigister));
		return driver.findElement(LVARigister);
	}
	public WebElement getLVTravel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVTravel));
		return driver.findElement(LVTravel);
	}
	public WebElement getLVAEvents() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAEvents));
		return driver.findElement(LVAEvents);
	}
	public WebElement getLVDining() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVDining));
		return driver.findElement(LVDining);
	}
	public WebElement getLVServicesAndAmenities() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVServicesAndAmenities));
		return driver.findElement(LVServicesAndAmenities);
	}
	public WebElement getLVDownloadApp() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVDownloadApp));
		return driver.findElement(LVDownloadApp);
	}
	
	
	
	
}
