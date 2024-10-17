package pageObjects.Sitecore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SitecoreSmokeTestLinks {

	public WebDriver driver;
	public WebDriverWait wait;
	
	By UserName = By.xpath("//input[@id = 'Username']"); // Locator for User Name
	By Password = By.xpath("//input[@id = 'Password']"); //Locator for Password
	By Loginbtn = By.xpath("//button[@name = 'button']"); //Locator for Login button
	By VerifyHomePage = By.xpath("//a[@href='/sitecore/shell/sitecore/client/Applications/Launchpad']"); //Locator for verification of home page
	By ContentEditor = By.xpath("//a[@title = 'Content Editor']"); //Locator for Content Editor option
	By VerifyContentEditor = By.xpath("//span[@class = 'scEditorTabHeaderActive']"); //Locator for Verify Content Editor
	By DigitalAdminPanel = By.xpath("//a[@title = 'Digital Admin Panel']"); //Locator for Digital Admin Panel option
	By VerifyDigitalAdminPanel = By.xpath("//div[@class = 'sc-applicationHeader-title']"); //Locator for verify Digital Admin Panel
	By ExhibitorEventsApproval = By.xpath("//a[@title = 'Exhibitor Events Approvals']"); //Locator for Exhibitor Events Approval option
	By ShowSpecialApprovals = By.xpath("//a[@title = 'Show Specials Approvals']"); //Locator for Show Specials Approvals option
	By IMCReports = By.xpath("//a[@title = 'IMC Reports']"); //Locator for IMC Reports option
	By TaxonomyManager = By.xpath("//a[@title = 'Taxonomy Manager']"); //Locator for Taxonomy Manager option
	By EmailExperienceManager = By.xpath("//a[@title = 'Email Experience Manager']"); //Locator for Email Experience Manager option
	By ControlPanel = By.xpath("//a[@title = 'Control Panel']"); //Locator for Control Panel option
	
	public SitecoreSmokeTestLinks(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getUserName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(UserName));
		return driver.findElement(UserName);
	}
	
	public WebElement getPassword() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(Password));
		return driver.findElement(Password);
	}
	
	public WebElement getLoginbtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(Loginbtn));
		return driver.findElement(Loginbtn);
	}
	
	public WebElement getVerifyHomePage() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyHomePage));
		return driver.findElement(VerifyHomePage);
	}
	
	public WebElement getContentEditor() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ContentEditor));
		return driver.findElement(ContentEditor);
	}
	
	public WebElement getVerifyContentEditor() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyContentEditor));
		return driver.findElement(VerifyContentEditor);
	}
	
	public WebElement getDigitalAdminPanel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(DigitalAdminPanel));
		return driver.findElement(DigitalAdminPanel);
	}
	
	public WebElement getVerifyDigitalAdminPanel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(VerifyDigitalAdminPanel));
		return driver.findElement(VerifyDigitalAdminPanel);
	}
	
	public WebElement getExhibitorEventsApproval() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ExhibitorEventsApproval));
		return driver.findElement(ExhibitorEventsApproval);
	}
	
	public WebElement getShowSpecialApprovals() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ShowSpecialApprovals));
		return driver.findElement(ShowSpecialApprovals);
	}
	
	public WebElement getIMCReports() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(IMCReports));
		return driver.findElement(IMCReports);
	}
	
	public WebElement getTaxonomyManager() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(TaxonomyManager));
		return driver.findElement(TaxonomyManager);
	}
	
	public WebElement getEmailExperienceManager() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(EmailExperienceManager));
		return driver.findElement(EmailExperienceManager);
	}
	
	public WebElement getControlPanel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ControlPanel));
		return driver.findElement(ControlPanel);
	}
	
}