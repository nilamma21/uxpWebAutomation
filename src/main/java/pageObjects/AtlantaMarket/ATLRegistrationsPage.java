package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLRegistrationsPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlwelcometext = By.xpath("//div[@id ='root']/div[1]/div[1]/div[3]/button[1]"); //Locator for Welcome Text in Market Planner
	By atlregistrations = By.xpath("//a[contains(@href, '/Market-Planner/Registrations')]"); //Locator for Registrations option in Market Planner
	By atlregstninfotab = By.xpath("//div[contains(text(), 'Registration info')]"); //Locator for Registration info tab
		
	public ATLRegistrationsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLRegistrationsOptn() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlregistrations));
		return driver.findElement(atlregistrations);
	}
	
	public WebElement getATLRegistrationsInfoTab() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlregstninfotab));
		return driver.findElement(atlregstninfotab);
	}
	
	
}