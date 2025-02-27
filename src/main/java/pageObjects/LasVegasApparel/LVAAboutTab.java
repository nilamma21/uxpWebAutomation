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
	
	By LVAAboutTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'About')]/../..");
	By LVADatesAndHours = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Dates & Hours')]");
	By LVAPressCenter = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Press Center')]");
	By LVAInTheNews = By.xpath("(//a[contains(text(),'In The News')])[1]");
	By LVAContactUs = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Contact Us')]");
	
	public LVAAboutTab(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getLVAAboutTab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAAboutTab));
		return driver.findElement(LVAAboutTab);
	}
	public WebElement getLVADatesAndHours() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVADatesAndHours));
		return driver.findElement(LVADatesAndHours);
	}
	public WebElement getLVAPressCenter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAPressCenter));
		return driver.findElement(LVAPressCenter);
	}
	public WebElement getLVAInTheNews() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAInTheNews));
		return driver.findElement(LVAInTheNews);
	}
	public WebElement getLVAContactUs() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LVAContactUs));
		return driver.findElement(LVAContactUs);
	}
}
