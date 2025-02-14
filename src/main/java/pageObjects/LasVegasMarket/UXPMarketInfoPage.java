package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPMarketInfoPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By MarketInfoHeader = By.xpath("//nav[@class='imc-navigation-container']/descendant::a[contains(text(),'Markets')]"); //Locator for Mrket Info tab in header
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
		this.driver = driver; 			
	} 
	
	public WebElement getMarketInfoHeader() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(MarketInfoHeader));
		return driver.findElement(MarketInfoHeader);
	}
	
	public WebElement getAboutLasVegasMarket(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AboutLasVegasMarket));
		return driver.findElement(AboutLasVegasMarket);
	}

	public WebElement getMarketDatesAndHrs() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(MarketDatesAndHrs));
		return driver.findElement(MarketDatesAndHrs);
	}
	
	public WebElement getRegistrationDetails() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(RegistrationDetails));
		return driver.findElement(RegistrationDetails);
	}
	
	public WebElement getAdmissionPolicies() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AdmissionPolicies));
		return driver.findElement(AdmissionPolicies);
	}
	
	public WebElement getIndustryPartners() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(IndustryPartners));
		return driver.findElement(IndustryPartners);
	}
	
	public WebElement getFAQs() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(FAQs));
		return driver.findElement(FAQs);
	}
	
	public WebElement getContactUs() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ContactUs));
		return driver.findElement(ContactUs);
	}
	
	public WebElement getMarketRecap() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(MarketRecap));
		return driver.findElement(MarketRecap);
	}
	
	public WebElement getMediaAndPress() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(MediaAndPress));
		return driver.findElement(MediaAndPress);
	}
	
	public WebElement getVerifyAboutLasVegasMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyAboutLasVegasMarket));
		return driver.findElement(VerifyAboutLasVegasMarket);
	}
	
	public WebElement getVerifyFAQs() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyFAQs));
		return driver.findElement(VerifyFAQs);
	}
	
	public WebElement getVerifyContactUs() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyContactUs));
		return driver.findElement(VerifyContactUs);
	}
	
	public WebElement getVerifyMarketInfoSection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyMarketInfoSection));
		return driver.findElement(VerifyMarketInfoSection);
	}
	
	public WebElement getVerifyRegistrationDetailsProd(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyRegistrationDetailsProd));
		return driver.findElement(VerifyRegistrationDetailsProd);
	}
	
	public WebElement getVerifyFAQsProd(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyFAQsProd));
		return driver.findElement(VerifyFAQsProd);
	}
	
	public WebElement getverifyContactUsATL(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyContactUsATL));
		return driver.findElement(VerifyContactUsATL);
	}
	
}
