package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPAttendPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By Attend = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[1]/a[1]"); //Locator for Attend tab in header
	By WhyAttend = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[1]/div[1]/a[1]"); //Locator for Why Attend tab in header
	By Registration = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[2]/div[1]/a[1]"); //Locator for Registration under Attend
	By International = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[2]/div[2]/a[1]"); //Locator for International under Attend
	By Hotels = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[3]/div[1]/a[1]"); //Locator for Hotels under Attend
	By Travel = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[3]/div[2]/a[1]"); //Locator for Travel under Attend
	By MarketPlanner = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[4]/div[1]/a[1]"); //Locator for MarketPlanner under Attend
	By Dining = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[4]/div[2]/a[1]"); //Locator for Dining under Attend
	By Amenities = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[4]/div[3]/a[1]"); //Locator for Amenities under Attend
	By Accessibility = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[4]/div[4]/a[1]"); //Locator for Accessibility under Attend
	By DownloadApp = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[4]/div[5]/a[1]"); //Locator for DownloadApp under Attend
	By VerifyAttendSection = By.xpath("//div[@class = 'imc-section']/div[1]/div[4]/div[2]"); // Locator for Attend section verification
	
	
	public UXPAttendPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getWhyAttend() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(WhyAttend);

	}
	
	public WebElement getRegistration() throws InterruptedException{
		Thread.sleep(5000);
		return driver.findElement(Registration);

	}

	public WebElement getInternational() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(International);

	}
	
	public WebElement getHotels() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(Hotels);

	}
	
	public WebElement getTravel() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(Travel);

	}
	
	public WebElement getMarketPlanner() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(MarketPlanner);

	}
	
	public WebElement getDining() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(Dining);

	}
	
	public WebElement getAmenities() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(Amenities);

	}
	
	public WebElement getAccessibility() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(Accessibility);

	}
	
	public WebElement getDownloadApp() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(DownloadApp);

	}
	
	public WebElement getAttend() throws InterruptedException{
		Thread.sleep(5000);
		return driver.findElement(Attend);

	}
	
	public WebElement getVerifyAttendSection() throws InterruptedException {
		Thread.sleep(5000);;
		return driver.findElement(VerifyAttendSection);

	}
}



