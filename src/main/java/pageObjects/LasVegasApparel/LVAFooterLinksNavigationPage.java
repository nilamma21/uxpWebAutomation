package pageObjects.LasVegasApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVAFooterLinksNavigationPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By ourBrandsLVA = By.xpath("//a[@href='/exhibitor/directory']"); //Locator for Our brands in footer links ATL
	By DownloadTheApp = By.xpath("//a[contains(text(),'Download the @Market App')]"); //Locator for Download The App in footer links
	By ContactUsLVA = By.xpath("//a[@href='/about/contact-us']");
	By CareersATL = By.xpath("//a[contains(text(),'Careers')]"); //Locator for Careers in footer links
	By TermsAndConditions = By.partialLinkText("Terms"); // Locator for Terms and Conditions in footer links
	By atlprivacypolicy = By.xpath("//a[contains(text(),'Privacy Policy')]"); //Locator for Privacy Policy on LVM Footer
	By AmericasMart_ATLApp = By.xpath("(//a[contains(text(),'AmericasMart')])[1]"); //Locator for Americas Mart in footer links of ATLApp
	By AtlantaApparel = By.xpath("(//a[contains(@href,'https://www.atlanta-apparel.com')])[1]"); //Locator for Atlanta Apparel in footer links
	By AtlantaMarket = By.xpath("//div[contains(@class,'imc-accordion imc-vr--titan imc-category--heading')]//a[contains(text(),'Atlanta Market')]"); //Locator for Atlanta Matket in footer links
	By CasualMarket = By.xpath("(//a[contains(text(),'Casual Market Atlanta')])[1]");
	By HighPointMarket = By.xpath("(//a[contains(text(),'ANDMORE at High Point Market')])[1]"); //Locator for High Point Market in footer links
	By lvmlink_ATL = By.xpath("(//a[contains(text(),'Las Vegas Market')])[1]"); //Locator for Las Vegas market footer link
	By andmore = By.xpath("(//div[contains(@class,'imc-gallery__item imc-gallery__item--minheight imc-content-nav-container--column')]/div/p/a[contains(text(),'ANDMORE')])[2]"); //Locator for ANDMORE in footer links
	By marketInfoAMC = By.xpath("//a[@href='/about']"); //Locator for Market information in footer links AMC
	
	
	public LVAFooterLinksNavigationPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getourBrandsLVA() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ourBrandsLVA));
		return driver.findElement(ourBrandsLVA);
	}
	public WebElement getDownloadTheApp() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(DownloadTheApp));
		return driver.findElement(DownloadTheApp);
	}
	public WebElement getContactUsLVA() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContactUsLVA));
		return driver.findElement(ContactUsLVA);
	}
	public WebElement getCareersATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CareersATL));
		return driver.findElement(CareersATL);
	}
	public WebElement getTermsAndConditions() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(TermsAndConditions));
		return driver.findElement(TermsAndConditions);
	}
	public WebElement getatlprivacypolicy() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlprivacypolicy));
		return driver.findElement(atlprivacypolicy);
	}
	public WebElement getAmericasMart_ATLApp() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AmericasMart_ATLApp));
		return driver.findElement(AmericasMart_ATLApp);
	}
	public WebElement getAtlantaApparel() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaApparel));
		return driver.findElement(AtlantaApparel);
	}
	public WebElement getCasualMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CasualMarket));
		return driver.findElement(CasualMarket);
	}
	public WebElement getAtlantaMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaMarket));
		return driver.findElement(AtlantaMarket);
	}
	public WebElement getHighPointMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HighPointMarket));
		return driver.findElement(HighPointMarket);
	}
	public WebElement getlvmlink_ATL() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lvmlink_ATL));
		return driver.findElement(lvmlink_ATL);
	}
	public WebElement getandmore() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(andmore));
		return driver.findElement(andmore);
	}
	public WebElement marketInfoAMC() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketInfoAMC));
		return driver.findElement(marketInfoAMC);
	}		

}
