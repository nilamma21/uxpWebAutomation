package pageObjects.LasVegasApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVAExhibitTab{
	public WebDriver driver;
	public WebDriverWait wait;
	
	By LVAExhibitTab = By.xpath("(//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Exhibit')]/../..)[2]");
	By LVAExhibitorPortalLogin = By.xpath("(//a[contains(text(),'Exhibitor Portal Login')])[1]");
	By LVAExhibitorPortalGuide = By.xpath("(//a[contains(text(),'Exhibitor Portal Guide')])[1]");
	By LVAMarketToolkit = By.xpath("(//a[contains(text(),'Market Toolkit')])[1]");
	By LVAWhyExhibit = By.xpath("(//a[contains(text(),'Why Exhibit?')])[1]");
	By LVAAdvertisingAndSponsorship = By.xpath("(//a[contains(text(),'Advertising & Sponsorship')])[1]");
	By LVALeasingInquiry = By.xpath("(//a[contains(text(),'Leasing Inquiry')])[1]");
	By LVAExhibitorResources = By.xpath("(//a[contains(text(),'Exhibitor Resources')])[1]");
	By LVAAlreadyOnExhibitor = By.xpath("(//a[contains(text(),'Already an Exhibitor?')])[1]");
	
	public LVAExhibitTab(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLVAExhibitTab() throws InterruptedException {
	  Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAExhibitTab));
		return driver.findElement(LVAExhibitTab);
	}
	public WebElement getLVAExhibitorPortalLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAExhibitorPortalLogin));
		return driver.findElement(LVAExhibitorPortalLogin);
	}
	public WebElement getLVAExhibitorPortalGuide() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAExhibitorPortalGuide));
		return driver.findElement(LVAExhibitorPortalGuide);
	}
	public WebElement getLVAMarketToolkit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAMarketToolkit));
		return driver.findElement(LVAMarketToolkit);
	}
	public WebElement getLVAWhyExhibit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAWhyExhibit));
		return driver.findElement(LVAWhyExhibit);
	}
	public WebElement getLVAAdvertisingAndSponsorship() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAAdvertisingAndSponsorship));
		return driver.findElement(LVAAdvertisingAndSponsorship);
	}
	public WebElement getLVALeasingInquiry() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVALeasingInquiry));
		return driver.findElement(LVALeasingInquiry);
	}
	public WebElement getLVAExhibitorResources() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAExhibitorResources));
		return driver.findElement(LVAExhibitorResources);
	}
	public WebElement getLVAAlreadyOnExhibitor() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAAlreadyOnExhibitor));
		return driver.findElement(LVAAlreadyOnExhibitor);
	}
}
