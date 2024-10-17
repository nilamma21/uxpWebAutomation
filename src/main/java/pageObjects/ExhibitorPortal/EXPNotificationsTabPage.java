package pageObjects.ExhibitorPortal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPNotificationsTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By Notifications = By.xpath("//a[@href = '/Notifications']"); // Locator for Notifications symbol
	
	
	public EXPNotificationsTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getNotifications() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(Notifications));
		return driver.findElement(Notifications);

	}

}
