package pageObjects.ExhibitorPortal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPSettingsPage {
	

	public WebDriver driver;
	public WebDriverWait wait;

	By Settings = By.xpath("//div[@id = 'root']/header[1]/div[1]/div[2]/span"); // Locator for Settings symbol
	By VerifySettings = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]"); // Locator for Settings Panel Verification
	By EXPGuide = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[2]/div[1]/a[1]"); // Locator for Exhibitor Portal Guide link
	By VerifyEXPGuide = By.xpath("//section[@id = 'main-content']"); // Locator for EXP Guide Verification
	By ManageUsers = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[3]/div[1]/a[1]"); // Locator for Manage Users
	By VerifyManageUsers = By.xpath("//div[@id = 'root']/div[1]/div[1]/div[4]/p[1]"); // Locator for Manage Users Verification
	By CorporateInfo = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[4]/div[1]/a[1]"); // Locator for View Corporate Info
	By ContactCustomerSupport = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[5]/div[1]/a[1]"); // Locator for Contact Customer Support
	By VerifyContactCustomerSupport = By.xpath("//div[@class = 'container']/h1"); // Locator for Contact Customer Support Verification
	By CaptchaCheckBox = By.xpath("//div[@id = 'checkbox']"); //Locator for captcha check box
	By SkipCaptcha = By.xpath("//div[@title = 'Skip Challenge']"); //Locator for Skip captcha
	
	
	public EXPSettingsPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getSettings() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(Settings));
		return driver.findElement(Settings);

	}
	
	public WebElement getVerifySettings() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifySettings));
		return driver.findElement(VerifySettings);

	}
	
	public WebElement getEXPGuide() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPGuide));
		return driver.findElement(EXPGuide);

	}
	
	public WebElement getVerifyEXPGuide() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyEXPGuide));
		return driver.findElement(VerifyEXPGuide);

	}
	
	public WebElement getManageUsers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ManageUsers));
		return driver.findElement(ManageUsers);

	}
	
	public WebElement getVerifyManageUsers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyManageUsers));
		return driver.findElement(VerifyManageUsers);

	}
	
	public WebElement getCorporateInfo() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(CorporateInfo));
		return driver.findElement(CorporateInfo);

	}
	
	public WebElement getContactCustomerSupport() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ContactCustomerSupport));
		return driver.findElement(ContactCustomerSupport);

	}
	
	public WebElement getVerifyContactCustomerSupport() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyContactCustomerSupport));
		return driver.findElement(VerifyContactCustomerSupport);

	}

}
