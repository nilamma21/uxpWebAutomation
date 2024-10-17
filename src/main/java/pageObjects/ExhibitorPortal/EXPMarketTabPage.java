package pageObjects.ExhibitorPortal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPMarketTabPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By EXPMarketTab = By.xpath("//div[@id = 'root']/header[1]/div[1]/div[1]/div[1]/span[2]"); // Locator for Market tab
	By EXPManageYourMarket = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[2]/div[1]/a[1]"); // Locator for Manage Your Market
	By EXPExhibitorResources = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[2]/div[2]/a[1]");//Locator for Exhibitor Resources
	By EXPMarket = By.xpath("//div[@class='HeaderNavbar_navBlock__3D9ws']/div[3]/div[1]/a[1]");//Locator for Market
	By EXPManageMarketHeader = By.xpath("//h2[contains(text(), 'Manage Your Markets')]");//Locator for Market
	By EXPExhibitorResourcesHeader = By.xpath("//p[contains(text(), 'Exhibitor Resources')]");
	By EXPMarketHeader = By.xpath("//p[contains(text(), 'Manage')]");
	
	public EXPMarketTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getEXPMarketTab() throws InterruptedException {
		Thread.sleep(5000);
		
		return driver.findElement(EXPMarketTab);
	}
	public WebElement getEXPManageYourMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPManageYourMarket));
		return driver.findElement(EXPManageYourMarket);
	}
	public WebElement getEXPExhibitorResources() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPExhibitorResources));
		return driver.findElement(EXPExhibitorResources);
	}
	public WebElement getEXPMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(EXPMarket));
		return driver.findElement(EXPMarket);
	}
	public WebElement getEXPManageMarketHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPManageMarketHeader));
		return driver.findElement(EXPManageMarketHeader);
	}
	public WebElement getEXPExhibitorResourcesHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPExhibitorResourcesHeader));
		return driver.findElement(EXPExhibitorResourcesHeader);
	}
	public WebElement getEXPMarketHeader() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(EXPMarketHeader));
		return driver.findElement(EXPMarketHeader);
	}
}

