package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAllChannelsLinksPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlantamarket = By.xpath("//ul[@class='links-wrap']/li[1]/a[1]"); // Locator for Atlanta Market header link
	By atlantaapparel = By.xpath("//ul[@class='links-wrap']/li[2]/a[1]"); // Locator for Atlanta Apparel header link
	By americasmart = By.xpath("//ul[@class='links-wrap']/li[3]/a[1]"); // Locator for Americas Mart header link
	By highpoint = By.xpath("(//a[contains(text(),'ANDMORE at High Point Market')])[1]"); // Locator for IMC High Point Market header link
	By lasvegas = By.xpath("(//a[contains(text(),'Las Vegas Market')])[1]"); // Locator for Las vegas Market header link
	By lasvegasapp = By.xpath("(//a[contains(text(),'Las Vegas Apparel')])[1]"); // Locator for Las vegas Apparel header link

	
	public ATLAllChannelsLinksPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getAtlantaMarket() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlantamarket));
		return driver.findElement(atlantamarket);
	}

	public WebElement getAtlantaApparel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlantaapparel));
		return driver.findElement(atlantaapparel);
	}
	
	public WebElement getAmericasMart() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(americasmart));
		return driver.findElement(americasmart);
	}
	
	public WebElement getHighPoint() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(highpoint));
		return driver.findElement(highpoint);
	}
	
	public WebElement getLasVegas() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lasvegas));
		return driver.findElement(lasvegas);
	}
	
	public WebElement getLasVegasApp() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lasvegasapp));
		return driver.findElement(lasvegasapp);
	}
	
}

