package ExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPRegistrationAndServicesTabPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By EXPRegAndServicesTab = By.xpath("//div[@id ='root']/header[1]/div[1]/div[1]/div[1]/button[4]"); // Locator for Reg & Services tab
	By EXPExhibitorReg = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[2]/div[1]/a[1]"); // Locator for Exhibitor reg
	By EXPAtlantaServices = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[1]/a[1]"); // Locator for Atlanta Services
	By EXPAtlantaAdvertisingAndSponcership = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[2]/a[1]"); //Locator for Atlanta Advertising And Sponcership
	By EXPAtlantaPayment = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[3]/a[1]");//Locator Atlanta payment
	By EXPAAmericasMartLogisticsExhibitorToolkit = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[4]/div[1]/a[1]");//Locator for AmericasMart Logistics | Exhibitor Toolkit
	By EXPExhibitorRegHeader = By.xpath("//div[@class='EPPageHeader_block__1JPqk']/div[4]/p[1]");//Exhibitor reg Header
	By ExpPotalHeader=By.xpath("//h2[contains(text(),'Sign in with your existing account')]");
	By ExpPermSpaceHeader=By.xpath("//h1[@class='sg-title']/span[1]");
	By ExpGiftTradeshowHeader=By.xpath("//div[@class='sg-instructions']/div[1]/span[1]");
	By ExpFurniTradeshowHeader=By.xpath("//div[@class='sg-instructions']/div[1]");
	
	
	public EXPRegistrationAndServicesTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getEXPRegAndServicesTab() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPRegAndServicesTab));
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
	
	public WebElement getEXPExhibitorRegHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPExhibitorRegHeader));
		return driver.findElement(EXPExhibitorRegHeader);
	}
	public WebElement getExpPortalHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExpPotalHeader));
		return driver.findElement(ExpPotalHeader);
	}
	public WebElement getExpPermSpaceHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExpPermSpaceHeader));
		return driver.findElement(ExpPermSpaceHeader);
	}
	public WebElement getExpGiftTradeshowHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExpGiftTradeshowHeader));
		return driver.findElement(ExpGiftTradeshowHeader);
	}
	public WebElement getExpFurniTradeshowHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExpFurniTradeshowHeader));
		return driver.findElement(ExpFurniTradeshowHeader);
	}
}

