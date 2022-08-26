package pageObjects.AtlantaApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppYearRoundTabPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By ShopTheMart = By.xpath("//h1[@class ='imc-type--title-1']/strong[1]"); //Locator for Year Round tab in header

	public ATLAppYearRoundTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getShopTheMart() throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopTheMart));
		return driver.findElement(ShopTheMart);

	}
}
