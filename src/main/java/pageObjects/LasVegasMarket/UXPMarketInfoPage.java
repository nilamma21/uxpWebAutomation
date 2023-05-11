package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPMarketInfoPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By MarketInfoHeader = By.xpath("//div[@class ='imc-section']/div[1]/div[1]/div[1]/a[1]"); //Locator for Mrket Info tab in header
	By AboutLasVegasMarket = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[1]/div[1]/a[1]"); // Locator for About Las Vegas Market option in Market Info
	By MarketDatesAndHrs = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[1]/a[1]"); // Locator for Market Dates and Hours
	By RegistrationDetails = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[2]/a[1]"); // Locator for Registration Details
	By AdmissionPolicies = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[3]/a[1]"); // Locator for Admission Policies
	By IndustryPartners = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[4]/a[1]"); // Locator for Industry Partners
	By FAQs = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[1]/a[1]"); // Locator for FAQs
	By ContactUs = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[2]/a[1]"); // Locator for Contact Us
	By MarketRecap = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[3]/a[1]"); // Locator for Market Cap
	By MediaAndPress = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[4]/a[1]"); // Locator for Media & Press Releases
	By VerifyAboutLasVegasMarket = By.xpath("//a[@title = 'Register to Attend']"); // Locator for verification of About Las Vegas Market page
	By VerifyFAQs = By.xpath("//div[@class = 'imc-section--content-with-image']/div[1]/div[1]/h2[1]"); // Locator for verification of FAQs page
	By VerifyContactUs = By.xpath("//ul[@class = 'imc-breadcrumb']/li[2]/a[1]"); // Locator for verification of Contact Us page
	By VerifyContactUsATL = By.xpath("//ul[@class = 'imc-breadcrumb']/li[3]/a[1]"); // Locator for verification of Contact Us page
	
	By VerifyMarketInfoSection = By.xpath("//div[@class = 'imc-section']/div[1]/div[1]/div[2]"); //Locator for verification of Market Info section
	By VerifyRegistrationDetailsProd = By.xpath("//a[@title = 'Register Now']"); //Locator for verification of Registration Details
	By VerifyFAQsProd = By.xpath("//div[@class = 'imc-section--content-with-image']/div[1]/div[1]/h1[1]"); // Locator for verification of FAQs page on Prod
	By MarketInfoHeaderProd = By.xpath("//div[@class ='imc-section']/div[1]/div[1]/div[2]/a[1]"); //Locator for Mrket Info tab in header

	public UXPMarketInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getMarketInfoHeader() throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(MarketInfoHeader));
		return driver.findElement(MarketInfoHeader);

	}
	
	public WebElement getAboutLasVegasMarket(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(AboutLasVegasMarket));
		return driver.findElement(AboutLasVegasMarket);

	}

	public WebElement getMarketDatesAndHrs() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(MarketDatesAndHrs));
		return driver.findElement(MarketDatesAndHrs);

	}
	
	public WebElement getRegistrationDetails() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(RegistrationDetails));
		return driver.findElement(RegistrationDetails);

	}
	
	public WebElement getAdmissionPolicies() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(AdmissionPolicies));
		return driver.findElement(AdmissionPolicies);

	}
	
	public WebElement getIndustryPartners() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(IndustryPartners));
		return driver.findElement(IndustryPartners);

	}
	
	public WebElement getFAQs() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(FAQs));
		return driver.findElement(FAQs);

	}
	
	public WebElement getContactUs() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ContactUs));
		return driver.findElement(ContactUs);

	}
	
	public WebElement getMarketRecap() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(MarketRecap));
		return driver.findElement(MarketRecap);

	}
	
	public WebElement getMediaAndPress() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(MediaAndPress));
		return driver.findElement(MediaAndPress);

	}
	
	public WebElement getVerifyAboutLasVegasMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyAboutLasVegasMarket));
		return driver.findElement(VerifyAboutLasVegasMarket);
		
	}
	
	public WebElement getVerifyFAQs() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyFAQs));
		return driver.findElement(VerifyFAQs);
		
	}
	
	public WebElement getVerifyContactUs() throws InterruptedException {
		Thread.sleep(5000);wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyContactUs));
		return driver.findElement(VerifyContactUs);
		
	}
	
	public WebElement getVerifyMarketInfoSection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyMarketInfoSection));
		return driver.findElement(VerifyMarketInfoSection);
		
	}
	
	public WebElement getVerifyRegistrationDetailsProd(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyRegistrationDetailsProd));
		return driver.findElement(VerifyRegistrationDetailsProd);
		
	}
	
	public WebElement getVerifyFAQsProd(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyFAQsProd));
		return driver.findElement(VerifyFAQsProd);
		
	}
	public WebElement getverifyContactUsATL(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyContactUsATL));
		return driver.findElement(VerifyContactUsATL);
		
	}
		
	
	
	
}
