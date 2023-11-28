package pageObjects.LasVegasMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPHeaderChannelLinksPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By AtlantaMarket = By.xpath("//ul[@class='links-wrap']/li[1]/a[1]"); // Locator for Atlanta Market header link
	By AtlantaApparel = By.xpath("//ul[@class='links-wrap']/li[2]/a[1]"); // Locator for Atlanta Apparel header link
	By AmericasMart = By.xpath("//ul[@class='links-wrap']/li[3]/a[1]"); // Locator for Americas Mart header link
	By HighPoint = By.xpath("(//a[contains(text(),'ANDMORE at High Point Market')])[1]"); // Locator for IMC High Point Market header link
	By LasVegas = By.xpath("(//a[contains(text(),'Las Vegas Market')])[1]"); // Locator for Las vegas Market header link
	
	
	public UXPHeaderChannelLinksPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getAtlantaMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaMarket));
		return driver.findElement(AtlantaMarket);
	}

	public WebElement getAtlantaApparel() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlantaApparel));
		return driver.findElement(AtlantaApparel);
	}
	
	public WebElement getAmericasMart() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(AmericasMart));
		return driver.findElement(AmericasMart);
	}
	
	public WebElement getHighPoint() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(HighPoint));
		return driver.findElement(HighPoint);
	}
	
	public WebElement getLasVegas() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LasVegas));
		return driver.findElement(LasVegas);
	}
	
}

