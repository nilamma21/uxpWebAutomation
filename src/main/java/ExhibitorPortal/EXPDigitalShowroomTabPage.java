package ExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPDigitalShowroomTabPage 
{

	public WebDriver driver;
	public WebDriverWait wait;

	By EXPYourDigiShowroom = By.xpath("//div[@class='EPHeader_headerWrapper__1X50E']/div[1]/div[1]/button[1]"); // Locator for Your Digi Showroom tab
	By EXPProfileInfo = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[2]/div[1]/a[1]"); // Locator for Profile Info
	By EXPlines = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[1]/a[1]"); // Locator for Instagram icon in footer links
	By EXPProduct = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[2]/a[1]"); 
	By EXPCatalogFlipbooks = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[3]/a[1]"); 
	By EXPJuniperData = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[4]/div[1]/a[1]");
	By EXPYourDigiShowroomAllHeader = By.xpath("//div[@class='EPPageHeader_container__Jiq4V']/div[1]/div[4]/p[1]");
	By EXPJuniperDataHeader = By.xpath("//div[@class='ds-section ds-form-section']/div[1]/form[1]/div[1]/h1[1]");
	
	public EXPDigitalShowroomTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getEXPYourDigiShowroom() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPYourDigiShowroom));
		return driver.findElement(EXPYourDigiShowroom);
	}
	
	public WebElement getEXPProfileInfo() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPProfileInfo));
		return driver.findElement(EXPProfileInfo);
	}
	public WebElement getEXPYourDigiShowroomAllHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(EXPYourDigiShowroomAllHeader));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPYourDigiShowroomAllHeader));
		return driver.findElement(EXPYourDigiShowroomAllHeader);
	}
	public WebElement getEXPlines() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPlines));
		return driver.findElement(EXPlines);
	}
	public WebElement getEXPProduct() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPProduct));
		return driver.findElement(EXPProduct);
	}
	public WebElement getEXPCatalogFlipbooks() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPCatalogFlipbooks));
		return driver.findElement(EXPCatalogFlipbooks);
	}
	public WebElement getEXPJuniperData() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPJuniperData));
		return driver.findElement(EXPJuniperData);
	}
	
	public WebElement getEXPJuniperDataHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(EXPYourDigiShowroomAllHeader));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPJuniperDataHeader));
		return driver.findElement(EXPJuniperDataHeader);
	}
	
}