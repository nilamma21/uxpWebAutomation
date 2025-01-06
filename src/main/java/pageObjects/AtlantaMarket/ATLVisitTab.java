package pageObjects.AtlantaMarket;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLVisitTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By VisitTab = By.xpath("//div[@class='imc-breakpoint-display--hide-tablet']/descendant::span[contains(text(),'Visit')]/../..");
	By Register = By.xpath("//a[@href='/Attend/Register' and contains(text(),'Register')]");
	By MarketDatesAndHours = By.xpath("//a[@href='/Attend/Market-Dates-and-Hours' and contains(text(),'Market Dates & Hours')]");
	By AboutMarket = By.xpath("//a[@href='/Market-Info/About' and contains(text(),'About Market')]");
	By Market101 = By.xpath("//a[@href='/Market-Info/Market-101' and contains(text(),'Market 101')]");
	By MarketPlan = By.xpath("//a[@href='/Attend/Plan-Your-Market' and contains(text(),'Market Plan')]");
	By Travel = By.xpath("//a[@href='/Attend/Travel' and contains(text(),'Travel')]");
	By Dining = By.xpath("//a[@href='/Attend/Dining' and contains(text(),'Dining')]");
	By ServicesAndAmenities = By.xpath("//a[@href='/Attend/Services-and-Amenities' and contains(text(),'Services & Amenities')]");
	
	public ATLVisitTab(WebDriver driver) {
		this.driver = driver; 			
	}
	
	public WebElement getVisitTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(VisitTab));
		return driver.findElement(VisitTab);
	}
	public WebElement getRegister() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Register));
		return driver.findElement(Register);
	}
	public WebElement getMarketDatesAndHours() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketDatesAndHours));
		return driver.findElement(MarketDatesAndHours);
	}
	public WebElement getAboutMarket() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AboutMarket));
		return driver.findElement(AboutMarket);
	}
	public WebElement getMarket101() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Market101));
		return driver.findElement(Market101);
	}
	public WebElement getMarketPlan() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MarketPlan));
		return driver.findElement(MarketPlan);
	}
	public WebElement getTravel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Travel));
		return driver.findElement(Travel);
	}
	public WebElement getDining() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Dining));
		return driver.findElement(Dining);
	}
	public WebElement getServicesAndAmenities() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ServicesAndAmenities));
		return driver.findElement(ServicesAndAmenities);
	}
	
}
