package pageObjects.AtlantaApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppMarketsAndEventsTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By ATLAppMarketsAndEventsTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Markets & Events')]/../..");
	By MAECompleteShowdates = By.xpath("(//a[@href='/Markets/Complete-Show-Dates' and contains(text(),'Complete Show Dates')])[1]");
	By MAEEventsAndAmenities = By.xpath("(//a[@href='/Attend/Events' and contains(text(),'Events & Amenities')])[1]");
	By MAEYearAroundAtAmericasMart = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Year Round at AmericasMart')]");
	
	
	public ATLAppMarketsAndEventsTab(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getATLAppMarketsAndEventsTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ATLAppMarketsAndEventsTab));
		return driver.findElement(ATLAppMarketsAndEventsTab);
	}
	public WebElement getMAECompleteShowdates() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MAECompleteShowdates));
		return driver.findElement(MAECompleteShowdates);
	}
	public WebElement getMAEEventsAndAmenities() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MAEEventsAndAmenities));
		return driver.findElement(MAEEventsAndAmenities);
	}
	public WebElement getMAEYearAroundAtAmericasMart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(MAEYearAroundAtAmericasMart));
		return driver.findElement(MAEYearAroundAtAmericasMart);
	}

}
