package pageObjects.AtlantaMarket;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAttendPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ATLDownloadApp = By.xpath("//a[@class='imc-navigation-2tier-imageLink']"); // Locator for Download the App link
	By ATLAttendTab = By.xpath("//nav[@class='imc-navigation-container']/descendant::a[contains(text(),'Attend')]"); // Locator for Attend tab in header
	By ATLWhyAttend = By.xpath("(//a[@href='/Attend/Why-Attend'])[position()=1]"); //Locator for Why Attend link
	By ATLRegistration = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Registration')]"); //Locator for Registration link
	By ATLAdmissionPolicies = By.xpath("(//a[@href='/Attend/Admission-Policies'])[position()=1]"); //Locator for Admission Policies link
	By ATLTravel = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Travel')]"); //Locator for Travel link
	By ATLDiningGuide = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Dining')]"); //Locator for Dining Guide link
	By ATLServicesAndAmenities = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Services & Amenities')]"); //Locator for Service and Amenities
	By ATLTogetherSafely = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[4]/div[1]/a[2]"); //Locator for Together Safely logo
	By VerifyATLAttendSection = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]"); //Locator for verification for Attend section
	By atlevents = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Events')]"); //Locator for Events sub-menu
	By ATLPlanYourMarket = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Plan Your Market')]");
	
	public ATLAttendPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getATLDownloadApp() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLDownloadApp));
		return driver.findElement(ATLDownloadApp);
	}
	
	public WebElement getATLAttendTab() throws InterruptedException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAttendTab));
		return driver.findElement(ATLAttendTab);
	}
	
	public WebElement getATLWhyAttend() throws InterruptedException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLWhyAttend));
		return driver.findElement(ATLWhyAttend);
	}

	public WebElement getATLRegistration() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLRegistration));
		return driver.findElement(ATLRegistration);
	}
	
	public WebElement getATLAdmissionPolicies() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLAdmissionPolicies));
		return driver.findElement(ATLAdmissionPolicies);
	}
	
	public WebElement getATLTravel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLTravel));
		return driver.findElement(ATLTravel);
	}
	
	public WebElement getATLDiningGuide() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLDiningGuide));
		return driver.findElement(ATLDiningGuide);
	}
	
	public WebElement getATLServicesAndAmenities() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLServicesAndAmenities));
		return driver.findElement(ATLServicesAndAmenities);
	}
	
	public WebElement getATLTogetherSafely() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLTogetherSafely));
		return driver.findElement(ATLTogetherSafely);
	}

	public WebElement getVerifyATLAttendSection() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyATLAttendSection));
		return driver.findElement(VerifyATLAttendSection);
	}
	
	public WebElement getATLEventsSubmenu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlevents));
		return driver.findElement(atlevents);
	}
	  public WebElement getATLPlanYourMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLPlanYourMarket));
		return driver.findElement(ATLPlanYourMarket);
	}

}

