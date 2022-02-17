package ExhibitorPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EXPNotificationsTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By Notifications = By.xpath("//a[@href = '/Notifications']"); // Locator for Notifications symbol
	By VeirfyNotifications = By.xpath("//p[@class = 'EPPageHeader_pageTitle__V1XKr']"); // Locator for verify notifications page
	
	public EXPNotificationsTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getNotifications() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Notifications));
		return driver.findElement(Notifications);

	}
	
	public WebElement getVeirfyNotifications() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(VeirfyNotifications));
		return driver.findElement(VeirfyNotifications);

	}
}
