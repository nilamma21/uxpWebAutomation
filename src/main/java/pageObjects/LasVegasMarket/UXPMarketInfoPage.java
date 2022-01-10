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
	By VerifyMarketInfoSection = By.xpath("//div[@class = 'imc-section']/div[1]/div[1]/div[2]"); //Locator for verification of Market Info section
	
	
	public UXPMarketInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getMarketInfoHeader() throws InterruptedException{
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(MarketInfoHeader);

	}
	
	public WebElement getAboutLasVegasMarket(){
		//Wait till Sign In page is displayed
		return driver.findElement(AboutLasVegasMarket);

	}

	public WebElement getMarketDatesAndHrs() {
		//Wait till Sign In page is displayed
		return driver.findElement(MarketDatesAndHrs);

	}
	
	public WebElement getRegistrationDetails() throws InterruptedException {
		//Wait till Sign In page is displayed
		return driver.findElement(RegistrationDetails);

	}
	
	public WebElement getAdmissionPolicies() {
		//Wait till Sign In page is displayed
		return driver.findElement(AdmissionPolicies);

	}
	
	public WebElement getIndustryPartners() {
		//Wait till Sign In page is displayed
		return driver.findElement(IndustryPartners);

	}
	
	public WebElement getFAQs() {
		//Wait till Sign In page is displayed
		return driver.findElement(FAQs);

	}
	
	public WebElement getContactUs() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(ContactUs);

	}
	
	public WebElement getMarketRecap() {
		//Wait till Sign In page is displayed
		return driver.findElement(MarketRecap);

	}
	
	public WebElement getMediaAndPress() {
		//Wait till Sign In page is displayed
		return driver.findElement(MediaAndPress);

	}
	
	public WebElement getVerifyAboutLasVegasMarket() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(VerifyAboutLasVegasMarket);
		
	}
	
	public WebElement getVerifyFAQs() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(VerifyFAQs);
		
	}
	
	public WebElement getVerifyContactUs() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(VerifyContactUs);
		
	}
	
	public WebElement getVerifyMarketInfoSection(){
		//Wait till Sign In page is displayed
		return driver.findElement(VerifyMarketInfoSection);
		
	}
}
