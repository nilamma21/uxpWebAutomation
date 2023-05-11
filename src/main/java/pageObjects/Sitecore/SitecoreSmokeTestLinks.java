package pageObjects.Sitecore;

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
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getUserName() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(UserName));
		return driver.findElement(UserName);

	}
	
	public WebElement getPassword() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(Password));
		return driver.findElement(Password);

	}
	
	public WebElement getLoginbtn() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(Loginbtn));
		return driver.findElement(Loginbtn);

	}
	
	public WebElement getVerifyHomePage() throws InterruptedException {
		//Thread.sleep(15000);
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyHomePage));
		return driver.findElement(VerifyHomePage);

	}
	
	public WebElement getContentEditor() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ContentEditor));
		return driver.findElement(ContentEditor);

	}
	
	public WebElement getVerifyContentEditor() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VerifyContentEditor));
		return driver.findElement(VerifyContentEditor);

	}
	
	public WebElement getDigitalAdminPanel() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(DigitalAdminPanel));
		return driver.findElement(DigitalAdminPanel);

	}
	
	public WebElement getVerifyDigitalAdminPanel() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(VerifyDigitalAdminPanel));
		return driver.findElement(VerifyDigitalAdminPanel);

	}
	
	public WebElement getExhibitorEventsApproval() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ExhibitorEventsApproval));
		return driver.findElement(ExhibitorEventsApproval);

	}
	
	public WebElement getShowSpecialApprovals() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ShowSpecialApprovals));
		return driver.findElement(ShowSpecialApprovals);

	}
	
	public WebElement getIMCReports() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(IMCReports));
		return driver.findElement(IMCReports);

	}
	
	public WebElement getTaxonomyManager() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(TaxonomyManager));
		return driver.findElement(TaxonomyManager);

	}
	
	public WebElement getEmailExperienceManager() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EmailExperienceManager));
		return driver.findElement(EmailExperienceManager);

	}
	
	public WebElement getControlPanel() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ControlPanel));
		return driver.findElement(ControlPanel);

	}
	
}
