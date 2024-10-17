package pageObjects.AtlantaApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppExhibitorsAndProductTabPage 
{

	public WebDriver driver;
	public WebDriverWait wait;

	By atlaappfloorplans = By.xpath("//div[@class ='imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[1]/a[1]"); //Locator for Floor Plans header tab
	By atlaappCategories = By.xpath("//a[@href=\"/exhibitor/Categories\" and text()='Categories']");
	By AtlAppExhibitorsAndProducts = By.xpath("//*[contains(text(), 'Exhibitors & Products')]"); //Locator for Exhibitors and Products
	
	public ATLAppExhibitorsAndProductTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getATLAppFloorplans()throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlaappfloorplans));
		return driver.findElement(atlaappfloorplans);
	}
	public WebElement getATLAppatlaappCategories()throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlaappCategories));
		return driver.findElement(atlaappCategories);
	}
	public WebElement getAtlAppExhibitorsAndProducts()throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AtlAppExhibitorsAndProducts));
		return driver.findElement(AtlAppExhibitorsAndProducts);
	}
}
