package pageObjects.ExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPRegistrationAndServicesTabPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By EXPRegAndServicesTab = By.xpath("//div[@id = 'root']/header[1]/div[1]/div[1]/div[1]/span[4]"); // Locator for Reg & Services tab
	By EXPExhibitorReg = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[2]/div[1]/a[1]"); // Locator for Exhibitor reg
	By EXPAtlantaServices = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[3]/div[1]/a[1]"); // Locator for Atlanta Services
	By EXPAtlantaAdvertisingAndSponcership = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[3]/div[2]/a[1]"); //Locator for Atlanta Advertising And Sponcership
	By EXPAtlantaPayment = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[3]/div[3]/a[1]");//Locator Atlanta payment
	By EXPAAmericasMartLogisticsExhibitorToolkit = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[4]/div[1]/a[1]");//Locator for AmericasMart Logistics | Exhibitor Toolkit
	By VerifyAtlantaLinks = By.xpath("//div[@class = 'ng-scope']/form[1]/div[1]/div[1]/div[1]/div[1]/h2[1]"); //Locator for Exhibitor POrtal Administrator text validation
	By VerifyAMCToolKit = By.xpath("//span[id = 'lblCompany']"); //Locator for verification tool kit page
	
	By MarketBadgeRegistration = By.xpath("//a[contains(text(),'Market Badge Registration')]");
	By ATLTechnologyServiceTab = By.xpath("//a[contains(text(),'Atlanta') and contains(text(),'Temporary Booths') and contains(text(),'Technology Services')]"); //Locator for Atlanta Technology Service
	By ATLServices = By.xpath("//a[contains(text(),'Atlanta | Services')]");
	By ATLAdvertisingAndSponsorship = By.xpath("//a[contains(text(),'Atlanta | Advertising & Sponsorship')]");
	By ATLPayments = By.xpath("//a[contains(text(),'Atlanta | Payments')]");
	By AMCLogisticsAndExhToolkit = By.xpath("//a[contains(text(),'AmericasMart Logistics | Exhibitor Toolkit')]");
	By LVMTechnologyServiceTab = By.xpath("//a[contains(text(),'Las Vegas') and contains(text(),'Technology Services')]"); //Locator for Las Vegas Technology Service
	By ATLTechnologyServicePermenantTab = By.xpath("//a[contains(text(),'Atlanta') and contains(text(),'Permanent Exhibits') and contains(text(),'Technology Services')]");//Locator for Atlanta | Permanent Exhibits | Technology Services Page
	
	
	public EXPRegistrationAndServicesTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getEXPRegAndServicesTab() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(EXPRegAndServicesTab));
		return driver.findElement(EXPRegAndServicesTab);
	}
	public WebElement getEXPExhibitorReg() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(EXPExhibitorReg));
		return driver.findElement(EXPExhibitorReg);
	}
	public WebElement getEXPAtlantaServices() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaServices));
		return driver.findElement(EXPAtlantaServices);
	}
	public WebElement getEXPAtlantaAdvertisingAndSponcership() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaAdvertisingAndSponcership));
		return driver.findElement(EXPAtlantaAdvertisingAndSponcership);
	}
	public WebElement getEXPAtlantaPayment() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaPayment));
		return driver.findElement(EXPAtlantaPayment);
	}
	public WebElement getEXPAAmericasMartLogisticsExhibitorToolkit() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAAmericasMartLogisticsExhibitorToolkit));
		return driver.findElement(EXPAAmericasMartLogisticsExhibitorToolkit);
	}
	
	public WebElement getVerifyAtlantaLinks() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyAtlantaLinks));
		return driver.findElement(VerifyAtlantaLinks);
	}
	
	public WebElement getVerifyAMCToolKit() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyAMCToolKit));
		return driver.findElement(VerifyAMCToolKit);
	}
	
	public WebElement getATLTechnologyServiceTab() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLTechnologyServiceTab));
		return driver.findElement(ATLTechnologyServiceTab);
	}
	
	public WebElement getLVMTechnologyServiceTab() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVMTechnologyServiceTab));
		return driver.findElement(LVMTechnologyServiceTab);
	}
	
	public WebElement getMarketBadgeRegistration() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketBadgeRegistration));
		return driver.findElement(MarketBadgeRegistration);
	}
	
	public WebElement getATLServices() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLServices));
		return driver.findElement(ATLServices);
	}
	
	public WebElement getATLAdvertisingAndSponsorship() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAdvertisingAndSponsorship));
		return driver.findElement(ATLAdvertisingAndSponsorship);
	}
	
	public WebElement getATLPayments() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLPayments));
		return driver.findElement(ATLPayments);
	}
	
	public WebElement getAMCLogisticsAndExhToolkit() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AMCLogisticsAndExhToolkit));
		return driver.findElement(AMCLogisticsAndExhToolkit);
	}
	
    public WebElement getATLTechnologyServicePermenantTab() {
      wait = new WebDriverWait (driver,30);
      wait.until(ExpectedConditions.visibilityOfElementLocated(ATLTechnologyServicePermenantTab));
      return driver.findElement(ATLTechnologyServicePermenantTab);
  }
	
}

