package pageObjects.ExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPRegistrationAndServicesTabPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By EXPRegAndServicesTab = By.xpath("//div[@id = 'root']/header[1]/div[1]/div[1]/div[1]/button[4]"); // Locator for Reg & Services tab
	By EXPExhibitorReg = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[2]/div[1]/a[1]"); // Locator for Exhibitor reg
	By EXPAtlantaServices = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[3]/div[1]/a[1]"); // Locator for Atlanta Services
	By EXPAtlantaAdvertisingAndSponcership = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[3]/div[2]/a[1]"); //Locator for Atlanta Advertising And Sponcership
	By EXPAtlantaPayment = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[3]/div[3]/a[1]");//Locator Atlanta payment
	By EXPAAmericasMartLogisticsExhibitorToolkit = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[4]/div[1]/a[1]");//Locator for AmericasMart Logistics | Exhibitor Toolkit
	By VerifyAtlantaLinks = By.xpath("//div[@class = 'ng-scope']/form[1]/div[1]/div[1]/div[1]/div[1]/h2[1]"); //Locator for Exhibitor POrtal Administrator text validation
	By VerifyAMCToolKit = By.xpath("//span[id = 'lblCompany']"); //Locator for verification tool kit page
	
	public EXPRegistrationAndServicesTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getEXPRegAndServicesTab() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(EXPRegAndServicesTab);
	}
	public WebElement getEXPExhibitorReg() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPExhibitorReg));
		return driver.findElement(EXPExhibitorReg);
	}
	public WebElement getEXPAtlantaServices() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaServices));
		return driver.findElement(EXPAtlantaServices);
	}
	public WebElement getEXPAtlantaAdvertisingAndSponcership() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaAdvertisingAndSponcership));
		return driver.findElement(EXPAtlantaAdvertisingAndSponcership);
	}
	public WebElement getEXPAtlantaPayment() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaPayment));
		return driver.findElement(EXPAtlantaPayment);
	}
	public WebElement getEXPAAmericasMartLogisticsExhibitorToolkit() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAAmericasMartLogisticsExhibitorToolkit));
		return driver.findElement(EXPAAmericasMartLogisticsExhibitorToolkit);
	}
	
	public WebElement getVerifyAtlantaLinks() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyAtlantaLinks));
		return driver.findElement(VerifyAtlantaLinks);
	}
	
	public WebElement getVerifyAMCToolKit() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyAMCToolKit));
		return driver.findElement(VerifyAMCToolKit);
	}
	
}

