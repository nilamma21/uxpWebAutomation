package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLProfileAndSettingsPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlwelcometext = By.xpath("//div[@id ='root']/div[1]/div[1]/div[3]/button[1]"); //Locator for Welcome Text in Market Planner
	By atlprofileandsettings = By.xpath("//div[@class = 'imc-header-user-icon--links-settings']/a[1]"); //Locator for Profile and Settings option in Market Planner
	By amcexhibitorportal = By.xpath("//div[@class = 'imc-header-user-icon--links-portal']/a[1]"); //Locator for Exhibitor Portal sub menu
	By amcexhphome = By.xpath("//h1[contains(text(), 'Exhibitor Dashboard')]"); //Locator for EXP Home page title
	
	public ATLProfileAndSettingsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLWelcomeText() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(atlwelcometext);
	}

	public WebElement getATLProfileAndSettings() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlprofileandsettings));
		return driver.findElement(atlprofileandsettings);
	}
	
	public WebElement getAMCExhibitorPortalOptn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcexhibitorportal));
		return driver.findElement(amcexhibitorportal);
	}
	public WebElement getAMCExhibitorPortalHome() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(amcexhphome));
		return driver.findElement(amcexhphome);
	}
	
	
}