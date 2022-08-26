package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPProfileAndSettingsPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By WelcomeText = By.xpath("//div[@id ='root']/div[1]/div[1]/div[3]/button[1]"); //Locator for Welcome Text in Market Planner
	By ProfileAndSettings = By.xpath("//div[@class = 'imc-header-user-icon--links-settings']/a[1]"); //Locator for Profile and Settings option in Market Planner
	By VerifyProfile = By.xpath("//ul[@class = 'imc-breadcrumb']/li[2]/a[1]"); // Locator for Profile and Settings verification
	
	public UXPProfileAndSettingsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getWelcomeText() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(5000);
		return driver.findElement(WelcomeText);

	}

	public WebElement getProfileAndSettings() {
		//Wait till Sign In page is displayed
		return driver.findElement(ProfileAndSettings);

	}
	
	public WebElement getVerifyProfile() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(5000);
		return driver.findElement(VerifyProfile);

	}
	
}