package pageObjects.ExhibitorPortal;

import java.time.Duration;

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
	By LVMPermanentTechnologyServiceTab = By.xpath("//a[contains(text(),'Las Vegas') and contains(text(),'Technology Services') and contains(text(),'Permanent')]"); //Locator for Las Vegas Permanent Technology Service
	By ATLTechnologyServicePermenantTab = By.xpath("//a[contains(text(),'Atlanta') and contains(text(),'Permanent Exhibits') and contains(text(),'Technology Services')]");//Locator for Atlanta | Permanent Exhibits | Technology Services Page
	By ATLElectricalAndLightingServices = By.xpath("//a[contains(text(),'Atlanta') and contains(text(),'Electrical & Lighting Services')]");
	By LVMTemporaryTechnologyServiceTab = By.xpath("//a[contains(text(),'Las Vegas') and contains(text(),'Technology Services') and contains(text(),'Temporary')]"); //Locator for Las Vegas Temporary Technology Service

	
	public EXPRegistrationAndServicesTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getEXPRegAndServicesTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPRegAndServicesTab));
		return driver.findElement(EXPRegAndServicesTab);
	}
	public WebElement getEXPExhibitorReg() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPExhibitorReg));
		return driver.findElement(EXPExhibitorReg);
	}
	public WebElement getEXPAtlantaServices() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaServices));
		return driver.findElement(EXPAtlantaServices);
	}
	public WebElement getEXPAtlantaAdvertisingAndSponcership() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaAdvertisingAndSponcership));
		return driver.findElement(EXPAtlantaAdvertisingAndSponcership);
	}
	public WebElement getEXPAtlantaPayment() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaPayment));
		return driver.findElement(EXPAtlantaPayment);
	}
	public WebElement getEXPAAmericasMartLogisticsExhibitorToolkit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPAAmericasMartLogisticsExhibitorToolkit));
		return driver.findElement(EXPAAmericasMartLogisticsExhibitorToolkit);
	}
	
	public WebElement getVerifyAtlantaLinks() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyAtlantaLinks));
		return driver.findElement(VerifyAtlantaLinks);
	}
	
	public WebElement getVerifyAMCToolKit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyAMCToolKit));
		return driver.findElement(VerifyAMCToolKit);
	}
	
	public WebElement getATLTechnologyServiceTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLTechnologyServiceTab));
		return driver.findElement(ATLTechnologyServiceTab);
	}
	
	public WebElement getLVMPermanentTechnologyServiceTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVMPermanentTechnologyServiceTab));
		return driver.findElement(LVMPermanentTechnologyServiceTab);
	}
	
	public WebElement getMarketBadgeRegistration() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketBadgeRegistration));
		return driver.findElement(MarketBadgeRegistration);
	}
	
	public WebElement getATLServices() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLServices));
		return driver.findElement(ATLServices);
	}
	
	public WebElement getATLAdvertisingAndSponsorship() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAdvertisingAndSponsorship));
		return driver.findElement(ATLAdvertisingAndSponsorship);
	}
	
	public WebElement getATLPayments() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLPayments));
		return driver.findElement(ATLPayments);
	}
	
	public WebElement getAMCLogisticsAndExhToolkit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AMCLogisticsAndExhToolkit));
		return driver.findElement(AMCLogisticsAndExhToolkit);
	}
	
    public WebElement getATLTechnologyServicePermenantTab() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOfElementLocated(ATLTechnologyServicePermenantTab));
      return driver.findElement(ATLTechnologyServicePermenantTab);
  }
	
    public WebElement getATLElectricalAndLightingServices() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ATLElectricalAndLightingServices));
        return driver.findElement(ATLElectricalAndLightingServices);
    }
  
  public WebElement getLVMTemporaryTechnologyServiceTab() {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
      wait.until(ExpectedConditions.visibilityOfElementLocated(LVMTemporaryTechnologyServiceTab));
      return driver.findElement(LVMTemporaryTechnologyServiceTab);
  }
	
}

