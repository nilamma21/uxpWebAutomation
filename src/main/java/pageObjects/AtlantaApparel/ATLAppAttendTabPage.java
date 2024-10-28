package pageObjects.AtlantaApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppAttendTabPage {
	public WebDriver driver;
	public WebDriverWait wait;

	By ATLAttendingMarkets = By.xpath("//a[@href='/Attend']"); //Locator for Why Attend link, now attending out markets
	By ATLAttendingMarketsImg = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[1]/div[1]/a[2]"); //Locator for Why Attend link
	By ATLBuyersGuide = By.xpath("//a[@href='https://atlanta-apparel.com/guide']");
	By ATLFAQs = By.xpath("//a[@href='/Attend/FAQs']");
	By ATLFAQ = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[2]/div[3]/a[1]");
	By ATlAppServices = By.xpath("//a[@href='/Attend/Services-and-Amenities']"); //Locator for Services and Amenities
	By ATLHotels = By.xpath("//a[@href='/Attend/Travel/Hotels']");
	By ATLEvents = By.xpath("//a[@href='/Attend/Events']");
	By ATLHotelsImg = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[3]/div[1]/a[2]");
	By ATLTravel = By.xpath("//a[@href='/Attend/Travel']");
	By ATLDining = By.xpath("//a[@href='/Attend/Dining']");
	By ATLDownloadApp = By.xpath("//div[@class ='imc-section']/div[1]/div[3]/div[2]/div[4]/div[3]/a[1]");
	By ATLVerifyHotels = By.xpath("//ul[@class = 'imc-breadcrumb']/li[4]/a[1]"); //locator for verification of Hotels link
	By ExploreAtlanta = By.xpath("//a[@href='/Attend/Explore-Atlanta']");
	By SafetyAndSecurity = By.xpath("//a[@href='/Attend/Safety-and-Security']");
	By DownloadTheApp = By.xpath("//a[@href='/Attend/Plan-Your-Market' and contains(text(),'Download the App')]");
	
	public ATLAppAttendTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getATLAttendingMarkets() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ATLAttendingMarkets));
		return driver.findElement(ATLAttendingMarkets);
	}

	public WebElement getATLAttendingMarketsImg() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAttendingMarketsImg));
		return driver.findElement(ATLAttendingMarketsImg);
	}

	public WebElement getATLBuyrsGuide() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLBuyersGuide));
		return driver.findElement(ATLBuyersGuide);
	}


	public WebElement getATLFAQs() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLFAQs));
		return driver.findElement(ATLFAQs);
	}
	public WebElement getATLFAQ() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLFAQ));
		return driver.findElement(ATLFAQ);
	}

	public WebElement getATLHotels() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLHotels));
		return driver.findElement(ATLHotels);
	}

	public WebElement getATLHotelsImg() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLHotelsImg));
		return driver.findElement(ATLHotelsImg);
	}

	public WebElement getATLTravel() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLTravel));
		return driver.findElement(ATLTravel);
	}

	public WebElement getATLEvents() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLEvents));
		return driver.findElement(ATLEvents);
	}

	public WebElement getATLDining() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLDining));
		return driver.findElement(ATLDining);
	}

	public WebElement getATLDownloadApp() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLDownloadApp));
		return driver.findElement(ATLDownloadApp);
	}
	
	public WebElement getATLVerifyHotels() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLVerifyHotels));
		return driver.findElement(ATLVerifyHotels);
	}
	
	public WebElement getATlAppServices() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATlAppServices));
		return driver.findElement(ATlAppServices);
	}
	
	public WebElement getExploreAtlanta() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExploreAtlanta));
		return driver.findElement(ExploreAtlanta);
	}
	
	public WebElement getSafetyAndSecurity() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(SafetyAndSecurity));
		return driver.findElement(SafetyAndSecurity);
	}
	
	public WebElement getDownloadTheApp() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(DownloadTheApp));
		return driver.findElement(DownloadTheApp);
	}
	
	
	
}
