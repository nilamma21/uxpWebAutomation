package pageObjects.ExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPFooterLinksPage {
	
	public WebDriver driver;
	public WebDriverWait wait;

	By ExhibitorPortalSymbol = By.xpath("//a[@href='/']/img"); // Locator for EXP Symbol
	By AmericasMart = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[1]"); // Locator for Americas Mart link
	By AtlantaMarket = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[2]"); // Locator for Atlanta Market link
	By AtlantaApparel = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[3]"); // Locator for Atlanta Apparel link
	By ADAC = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[4]"); // Locator for ADAC link
	By HighPointMarket = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[5]"); // Locator for High Point Market link
	By LasVegasMarket = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[6]"); // Locator for Las Vegas Market link
	By LasVegasDesignCenter = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[1]/a[7]"); // Locator for Las Vegas Design Center link
	By PrivacyPolicy = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[2]/a[1]"); // Locator for Privacy Policy link
	By TermsAndConditions = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[2]/a[2]"); // Locator for Terms And Conditions link
	By AboutIMC = By.xpath("//div[@id = 'root']/footer[1]/div[1]/div[2]/div[1]/div[2]/a[3]"); // Locator for About IMC link
	
	public EXPFooterLinksPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getExhibitorPortalSymbol() throws InterruptedException {
		Thread.sleep(5000);
		
		return driver.findElement(ExhibitorPortalSymbol);

	}
	
	public WebElement getAmericasMart() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(AmericasMart));
		return driver.findElement(AmericasMart);

	}
	
	public WebElement getAtlantaMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(AtlantaMarket));
		return driver.findElement(AtlantaMarket);

	}
	
	public WebElement getAtlantaApparel() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(AtlantaApparel));
		return driver.findElement(AtlantaApparel);

	}
	
	public WebElement getADAC() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ADAC));
		return driver.findElement(ADAC);

	}
	
	public WebElement getHighPointMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(HighPointMarket));
		return driver.findElement(HighPointMarket);

	}
	
	public WebElement getLasVegasMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(LasVegasMarket));
		return driver.findElement(LasVegasMarket);

	}
	
	public WebElement getLasVegasDesignCenter() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(LasVegasDesignCenter));
		return driver.findElement(LasVegasDesignCenter);

	}
	
	public WebElement getPrivacyPolicy() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(PrivacyPolicy));
		return driver.findElement(PrivacyPolicy);

	}
	
	public WebElement getTermsAndConditions() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(TermsAndConditions));
		return driver.findElement(TermsAndConditions);

	}
	
	public WebElement getAboutIMC() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(AboutIMC));
		return driver.findElement(AboutIMC);

	}

}
