package pageObjects.AtlantaApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppAttendTabPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By ATLAttendingMarkets = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[1]/div[1]/a[1]"); //Locator for Why Attend link
	By ATLAttendingMarketsImg = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[1]/div[1]/a[2]"); //Locator for Why Attend link
	By ATLBuyersGuide = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[1]/div[2]/a[1]");
	By ATLFAQs = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[2]/div[2]/a[1]");
	By ATLFAQ = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[2]/div[3]/a[1]");
	
	By ATLHotels = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[3]/div[1]/a[1]");
	By ATLEvents = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[4]/div[1]/a[1]");
	By ATLHotelsImg = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[3]/div[1]/a[2]");
	By ATLTravel = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[3]/div[2]/a[1]");
	By ATLDining = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[4]/div[2]/a[1]");
	By ATLDownloadApp = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[4]/div[3]/a[1]");
	By ATLVerifyHotels = By.xpath("//ul[@class = 'imc-breadcrumb']/li[4]/a[1]"); //locator for verification of Hotels link
	
	public ATLAppAttendTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLAttendingMarkets() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ATLAttendingMarkets));
		return driver.findElement(ATLAttendingMarkets);
	}

	public WebElement getATLAttendingMarketsImg() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAttendingMarketsImg));
		return driver.findElement(ATLAttendingMarketsImg);
	}

	public WebElement getATLBuyrsGuide() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLBuyersGuide));
		return driver.findElement(ATLBuyersGuide);
	}


	public WebElement getATLFAQs() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLFAQs));
		return driver.findElement(ATLFAQs);
	}
	public WebElement getATLFAQ() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLFAQ));
		return driver.findElement(ATLFAQ);
	}

	public WebElement getATLHotels() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLHotels));
		return driver.findElement(ATLHotels);
	}

	public WebElement getATLHotelsImg() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLHotelsImg));
		return driver.findElement(ATLHotelsImg);
	}

	public WebElement getATLTravel() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLTravel));
		return driver.findElement(ATLTravel);
	}

	public WebElement getATLEvents() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLEvents));
		return driver.findElement(ATLEvents);
	}

	public WebElement getATLDining() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLDining));
		return driver.findElement(ATLDining);
	}

	public WebElement getATLDownloadApp() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLDownloadApp));
		return driver.findElement(ATLDownloadApp);
	}
	
	public WebElement getATLVerifyHotels() throws InterruptedException {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLVerifyHotels));
		return driver.findElement(ATLVerifyHotels);
	}
}
