package pageObjects.AmericasMart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMMarketsAndEventsPage {
	
	public WebDriver driver;
	public WebDriverWait wait;

	By FallCashCarry = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[2]/div[4]/a[1]"); // Locator for Fall Cash and Carry
	By YearRoundEvents = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[2]/div[5]/a[1]"); // Locator for Year Round Events
	By AtlantaApparel = By.xpath("//div[@class='imc-section']/div[1]/div[3]/div[2]/div[4]/div[1]/a[1]"); //Locator for Atlanta Apparel logo
	
	public AMMarketsAndEventsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 
	
	public WebElement getFallCashCarry() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(FallCashCarry));
		return driver.findElement(FallCashCarry);
	}
	
	public WebElement getYearRoundEvents() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(YearRoundEvents));
		return driver.findElement(YearRoundEvents);
	}
	
	public WebElement getAtlantaApparel() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(AtlantaApparel));
		return driver.findElement(AtlantaApparel);
	}
}
