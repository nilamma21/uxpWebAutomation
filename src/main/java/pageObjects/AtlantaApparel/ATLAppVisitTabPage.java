package pageObjects.AtlantaApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppVisitTabPage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By ATLAppVisitTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Visit')]/../..");
	By VisitTabRegistration  = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Registration')]");
	By VisitTabCompleteShowDates = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Complete Show Dates')]");
	By VisitTabTravel = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Travel')]");
	By VisitTabEventsAndAmenities = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Events & Amenities')]");
	By VisitTabDining = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Dining')]");
	By VisitTabDownloadTheApp = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Download the App')]");
	By VisitTabServicesAtMarket = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Services at Market')]");
	By VisitTabFAQs = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'FAQs')]");
	
	public ATLAppVisitTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getATLAppVisitTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAppVisitTab));
		return driver.findElement(ATLAppVisitTab);
	}
	public WebElement getVisitTabRegistration() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTabRegistration));
		return driver.findElement(VisitTabRegistration);
	}
	public WebElement getVisitTabCompleteShowDates() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTabCompleteShowDates));
		return driver.findElement(VisitTabCompleteShowDates);
	}
	public WebElement getVisitTabTravel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTabTravel));
		return driver.findElement(VisitTabTravel);
	}
	public WebElement getVisitTabEventsAndAmenities() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTabEventsAndAmenities));
		return driver.findElement(VisitTabEventsAndAmenities);
	}
	public WebElement getVisitTabDining() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTabDining));
		return driver.findElement(VisitTabDining);
	}
	public WebElement getVisitTabDownloadTheApp() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTabDownloadTheApp));
		return driver.findElement(VisitTabDownloadTheApp);
	}
	public WebElement getVisitTabServicesAtMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTabServicesAtMarket));
		return driver.findElement(VisitTabServicesAtMarket);
	}
	public WebElement getVisitTabFAQs() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTabFAQs));
		return driver.findElement(VisitTabFAQs);
	}
	
	

}
