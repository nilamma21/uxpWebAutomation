package pageObjects.AtlantaApparel;

import java.time.Duration;

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
		this.driver = driver; 			
	} 

	public WebElement getShopTheMart() throws InterruptedException{
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShopTheMart));
		return driver.findElement(ShopTheMart);
	}
	
}
