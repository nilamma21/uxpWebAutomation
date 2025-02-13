package pageObjects.AmericasMart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMMarketsAndEventsTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By amcMarketsAndEventsTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Markets & Events')]/../.."); // Locator for Exhibit Tab
	By amcMarketDatesAndEvents = By.xpath("//a[@href='/Markets/Market-Dates-and-Hours' and contains(text(),'Market Dates & Hours')]");
	By amcVisit = By.xpath("//a[@href='/Year-Round' and contains(text(),'Shop Year Round')]");
	
	public AMMarketsAndEventsTab(WebDriver driver) {
		this.driver = driver; 			
	}
	
	public WebElement getamcExhibitTab() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcMarketsAndEventsTab));
		return driver.findElement(amcMarketsAndEventsTab);
	}
	public WebElement getamcMarketDatesAndEvents() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcMarketDatesAndEvents));
		return driver.findElement(amcMarketDatesAndEvents);
	}
	public WebElement getamcVisit() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcVisit));
		return driver.findElement(amcVisit);
	}
	
}
