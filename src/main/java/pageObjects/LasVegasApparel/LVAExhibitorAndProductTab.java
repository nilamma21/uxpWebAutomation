package pageObjects.LasVegasApparel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LVAExhibitorAndProductTab {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	By LVAExhibitorDirectoryTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'Exhibitor Directory')]/../..");
	By LVAExhibitorDirectory = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Exhibitor Directory')]");
	By LVAListOfBrands = By.xpath("(//a[contains(text(),'List of Brands')])[1]");
	By LVAOpenShowroom = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Open Showrooms')]");
	By LVAFloorPlans = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Floor Plans')]");
	By LVMTrendReport = By.xpath("//div[@class='imc-content--top-0 imc-content--absolute imc-navigation--wrapper-menu active']/descendant::a[contains(text(),'Trend Report')]");
	
	public LVAExhibitorAndProductTab(WebDriver driver) {
		this.driver = driver; 			
	} 
	
	public WebElement getLVAExhibitorDirectoryTab() throws InterruptedException {
	  Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAExhibitorDirectoryTab));
		return driver.findElement(LVAExhibitorDirectoryTab);
	}
	public WebElement getLVAExhibitorDirectory() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAExhibitorDirectory));
		return driver.findElement(LVAExhibitorDirectory);
	}
	public WebElement getLVAListOfBrands() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAListOfBrands));
		return driver.findElement(LVAListOfBrands);
	}
	public WebElement getLVAOpenShowroom() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAOpenShowroom));
		return driver.findElement(LVAOpenShowroom);
	}
	public WebElement getLVAFloorPlans() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVAFloorPlans));
		return driver.findElement(LVAFloorPlans);
	}
	public WebElement getLVMTrendReport() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(LVMTrendReport));
		return driver.findElement(LVMTrendReport);
	}
}
