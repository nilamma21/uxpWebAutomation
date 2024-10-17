package pageObjects.LasVegasApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVAAboutTab {
	public WebDriver driver;
	public WebDriverWait wait;
	
	By LVAAboutTab = By.xpath("(//a[contains(text(),'About')])[1]");
	By LVADatesAndHours = By.xpath("(//a[contains(text(),'Dates & Hours')])[1]");
	By LVAPressCenter = By.xpath("(//a[contains(text(),'Press Center')])[1]");
	By LVAInTheNews = By.xpath("(//a[contains(text(),'In The News')])[1]");
	By LVAContactUs = By.xpath("(//a[contains(text(),'Contact Us')])[1]");
	
	public LVAAboutTab(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getLVAAboutTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAAboutTab));
		return driver.findElement(LVAAboutTab);
	}
	public WebElement getLVADatesAndHours() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVADatesAndHours));
		return driver.findElement(LVADatesAndHours);
	}
	public WebElement getLVAPressCenter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAPressCenter));
		return driver.findElement(LVAPressCenter);
	}
	public WebElement getLVAInTheNews() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAInTheNews));
		return driver.findElement(LVAInTheNews);
	}
	public WebElement getLVAContactUs() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAContactUs));
		return driver.findElement(LVAContactUs);
	}
}
