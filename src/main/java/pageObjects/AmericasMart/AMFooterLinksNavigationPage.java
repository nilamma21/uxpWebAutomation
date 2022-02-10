package pageObjects.AmericasMart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMFooterLinksNavigationPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By FacebookIcon = By.xpath("//div[@class = 'section-wrapper imc-section--neutral-heavy']/secrtion[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/svg[1]"); // Locator for Facebook icon in footer links
	By TwitterIcon = By.xpath("//div[@class='imc-optin-social']/div[2]/a[1]/div[1]/svg[1]"); // Locator for Twitter icon in footer links
	By InstagramIcon = By.xpath("//div[@class='imc-optin-social']/div[3]/a[1]/div[1]/svg[1]"); // Locator for Instagram icon in footer links
	By YoutubeIcon = By.xpath("//div[@class='imc-optin-social']/div[4]/a[1]/div[1]/svg[1]"); // Locator for You Tube icon in footer links
	
	public AMFooterLinksNavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getFacebookIcon() throws InterruptedException {
		//Wait till Sign In page is displayed
		return driver.findElement(FacebookIcon);

	}
	
	public WebElement getTwitterIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(TwitterIcon));
		return driver.findElement(TwitterIcon);

	}

	public WebElement getInstagramIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(InstagramIcon));
		return driver.findElement(InstagramIcon);

	}

	public WebElement getYoutubeIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(YoutubeIcon));
		return driver.findElement(YoutubeIcon);

	}

}


