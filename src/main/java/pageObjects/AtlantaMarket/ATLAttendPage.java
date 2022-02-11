package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAttendPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ATLDownloadApp = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[2]/div[3]/a[1]"); // Locator for Download the App link
	By ATLAttendTab = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[1]/a[1]"); // Locator for Attend tab in header
	By ATLWhyAttend = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[1]/div[1]/a[1]"); //Locator for Why Attend link
	By ATLRegistration = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[2]/div[1]/a[1]"); //Locator for Registration link
	By ATLAdmissionPolicies = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[2]/div[2]/a[1]"); //Locator for Admission Policies link
	By ATLTravel = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[3]/div[1]/a[1]"); //Locator for Travel link
	By ATLDiningGuide = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[3]/div[2]/a[1]"); //Locator for Dining Guide link
	By ATLServicesAndAmenities = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[3]/div[3]/a[1]"); //Locator for Service and Amenities
	By ATLTogetherSafely = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[4]/div[1]/a[2]"); //Locator for Together Safely logo
	By VerifyATLAttendSection = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]"); //Locator for vrification for Attend section
	
	public ATLAttendPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getATLDownloadApp() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLDownloadApp));
		return driver.findElement(ATLDownloadApp);
	}
	
	public WebElement getATLAttendTab() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(ATLAttendTab);
	}
	
	public WebElement getATLWhyAttend() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLWhyAttend));
		return driver.findElement(ATLWhyAttend);
	}

	public WebElement getATLRegistration() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLRegistration));
		return driver.findElement(ATLRegistration);
	}
	
	public WebElement getATLAdmissionPolicies() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLAdmissionPolicies));
		return driver.findElement(ATLAdmissionPolicies);
	}
	
	public WebElement getATLTravel() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLTravel));
		return driver.findElement(ATLTravel);
	}
	
	public WebElement getATLDiningGuide() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLDiningGuide));
		return driver.findElement(ATLDiningGuide);
	}
	
	public WebElement getATLServicesAndAmenities() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLServicesAndAmenities));
		return driver.findElement(ATLServicesAndAmenities);
	}
	
	public WebElement getATLTogetherSafely() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLTogetherSafely));
		return driver.findElement(ATLTogetherSafely);
	}
	
	public WebElement getVerifyATLAttendSection() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(VerifyATLAttendSection);
	}

}

