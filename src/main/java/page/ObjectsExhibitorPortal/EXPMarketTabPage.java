package page.ObjectsExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPMarketTabPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By EXPMarketTab = By.xpath("//button[contains(text(),'Markets')]"); // Locator for Market tab
	By EXPManageYourMarket = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[2]/div[1]/a[1]"); // Locator for Manage Your Market
	By EXPExhibitorResources = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[2]/div[2]/a[1]");//Locator for Exhibitor Resources
	By EXPMarket = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[1]/a[1]");//Locator for Market
	By EXPManageMarketHeader = By.xpath("//h2[contains(text(), 'Manage Your Markets')]");//Locator for Market
	By EXPExhibitorResourcesHeader = By.xpath("//p[contains(text(), 'Exhibitor Resources')]");
	By EXPMarketHeader = By.xpath("//p[contains(text(), 'Manage')]");
	
	public EXPMarketTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getEXPMarketTab() throws InterruptedException {
		Thread.sleep(7000);
//		wait = new WebDriverWait (driver,20);
//		wait.until(ExpectedConditions.elementToBeClickable(EXPMarketTab));
		return driver.findElement(EXPMarketTab);
	}
	public WebElement getEXPManageYourMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPManageYourMarket));
		return driver.findElement(EXPManageYourMarket);
	}
	public WebElement getEXPExhibitorResources() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPExhibitorResources));
		return driver.findElement(EXPExhibitorResources);
	}
	public WebElement getEXPMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(EXPMarket));
		return driver.findElement(EXPMarket);
	}
	public WebElement getEXPManageMarketHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPManageMarketHeader));
		return driver.findElement(EXPManageMarketHeader);
	}
	public WebElement getEXPExhibitorResourcesHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPExhibitorResourcesHeader));
		return driver.findElement(EXPExhibitorResourcesHeader);
	}
	public WebElement getEXPMarketHeader() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPMarketHeader));
		return driver.findElement(EXPMarketHeader);
	}
}

