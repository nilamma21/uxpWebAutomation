package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	By Dining = By.xpath("//div[contains(@class,'imc-navigation-col')]/div/a[contains(text(),'Dining')]"); //Locator for Dining under Attend
	By Amenities = By.xpath("//div[contains(@class,'imc-navigation-col')]/div/a[contains(text(),'Amenities & Services')]"); //Locator for Amenities under Attend
	By Accessibility = By.xpath("//div[contains(@class,'imc-navigation-col')]/div/a[contains(text(),'Accessibility and ADA')]"); //Locator for Accessibility under Attend
	By DownloadApp = By.xpath("//div[contains(@class,'imc-navigation-col')]/div/a[contains(text(),'Download the App')]"); //Locator for DownloadApp under Attend
	By VerifyAttendSection = By.xpath("//div[@class = 'imc-section']/div[1]/div[4]/div[2]"); // Locator for Attend section verification
	By LVMPlanYourMarket = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']//descendant::a[contains(text(),'Plan Your Market')]");
	
	public UXPAttendPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getWhyAttend() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WhyAttend));
		return driver.findElement(WhyAttend);
	}
	
	public WebElement getRegistration() throws InterruptedException{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Registration));
		return driver.findElement(Registration);
	}

	public WebElement getInternational() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(International));
		return driver.findElement(International);
	}
	
	public WebElement getHotels() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Hotels));
		return driver.findElement(Hotels);
	}
	
	public WebElement getTravel() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Travel));
		return driver.findElement(Travel);
	}
	
	public WebElement getMarketPlanner() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MarketPlanner));
		return driver.findElement(MarketPlanner);
	}
	
	public WebElement getDining() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Dining));
		return driver.findElement(Dining);
	}
	
	public WebElement getAmenities() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Amenities));
		return driver.findElement(Amenities);
	}
	
	public WebElement getAccessibility() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Accessibility));
		return driver.findElement(Accessibility);
	}
	
	public WebElement getDownloadApp() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(DownloadApp));
		return driver.findElement(DownloadApp);
	}
	
	public WebElement getAttend() throws InterruptedException{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Attend));
		return driver.findElement(Attend);
	}
	
	public WebElement getVerifyAttendSection() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(VerifyAttendSection));
		return driver.findElement(VerifyAttendSection);
	}
	public WebElement getLVMPlanYourMarket() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LVMPlanYourMarket));
		return driver.findElement(LVMPlanYourMarket);
	}
	
}



