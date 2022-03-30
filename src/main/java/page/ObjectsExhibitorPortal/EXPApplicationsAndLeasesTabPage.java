package page.ObjectsExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPApplicationsAndLeasesTabPage 
{
	public WebDriver driver;
	public WebDriverWait wait;

	By EXPApplicationsAndLeasesTab = By.xpath("//div[@id = 'root']/header[1]/div[1]/div[1]/div[1]/button[3]"); // Locator for Application & Leases tab
	//By EXPAtlantaPermanentSpace = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[2]/div[1]/a[1]"); // Locator for Atlanta Permanent space
	By EXPAtlantaApplyForTradeshowSpace = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[2]/div[2]/a[1]"); // Locator for Atlanta Apply For Tradeshow Space
	By EXPAtlantaManageTradeshowSpace = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[1]/div[3]/a[1]"); //Locator for Atlanta Manage Tradeshow Space
	//By EXPAtlantaPayments = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[1]/a[1]"); //Locator for Atlanta Payments
	//By EXPLasVegasPermanentSpace = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[4]/div[1]/a[1]");//Locator Las Vegas Permanent Space
	By EXPLasVegasGiftHomeTradeshowSpace = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[4]/div[2]/a[1]");//Locator Las Vegas Gift Home Tradeshow Space
	By EXPLasVegasFurnitureTradeshowSpace = By.xpath("//div[@id = 'root']/header[1]/div[1]/nav[1]/div[1]/div[4]/div[3]/a[1]");//Locator Las Vegas | Furniture Tradeshow Space
	By EXPAtlantaPermanentSpaceHeader = By.xpath("//div[@class='EPPageHeader_block__1JPqk']/div[4]/p[1]");//Header Atlanta Permanent space
	By EXPLasVegasGiftAndHomeTradeshowSpaceHeader = By.xpath("//div[@class='sg-question-set']/div[1]/div[1]/div[1]/span[1]/strong[1]");//Header Las Vegas Gift & Home Tradeshow Space
	By VerifyPermanantSpace = By.xpath("//h1[@class = 'sg-title']"); //Locator for Leasing Contact Fomr
	By VerifyGiftHomeTradeshow = By.xpath("//div[@class = 'sg-instructions']"); //Locator for verification of gift and tradeshow
	
	
	public EXPApplicationsAndLeasesTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getEXPApplicationsAndLeasesTab() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPApplicationsAndLeasesTab));
		return driver.findElement(EXPApplicationsAndLeasesTab);
	}

	public WebElement getEXPAtlantaApplyForTradeshowSpace() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPAtlantaApplyForTradeshowSpace));
		return driver.findElement(EXPAtlantaApplyForTradeshowSpace);
	}


	public WebElement getEXPLasVegasGiftHomeTradeshowSpace() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPLasVegasGiftHomeTradeshowSpace));
		return driver.findElement(EXPLasVegasGiftHomeTradeshowSpace);
	}
	public WebElement getEXPLasVegasFurnitureTradeshowSpace() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPLasVegasFurnitureTradeshowSpace));
		return driver.findElement(EXPLasVegasFurnitureTradeshowSpace);
	}
	public WebElement getEXPAtlantaPermanentSpaceHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPAtlantaPermanentSpaceHeader));
		return driver.findElement(EXPAtlantaPermanentSpaceHeader);
	}
	public WebElement getEXPLasVegasGiftAndHomeTradeshowSpaceHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPLasVegasGiftAndHomeTradeshowSpaceHeader));
		return driver.findElement(EXPLasVegasGiftAndHomeTradeshowSpaceHeader);
	}

	public WebElement getVerifyPermanantSpace() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyPermanantSpace));
		return driver.findElement(VerifyPermanantSpace);
	}
	
	public WebElement getVerifyGiftHomeTradeshow() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyGiftHomeTradeshow));
		return driver.findElement(VerifyGiftHomeTradeshow);
	}
	
}
