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

	By FacebookIcon = By.xpath("//a[@href = 'https://www.facebook.com/AmericasmartAtl']"); // Locator for Facebook icon in footer links
	By TwitterIcon = By.xpath("//a[@href='https://twitter.com/americasmartatl']']"); // Locator for Twitter icon in footer links
	By InstagramIcon = By.xpath("//a[@href='https://www.instagram.com/americasmartatl/'])[position()=2]']"); // Locator for Instagram icon in footer links
	By YoutubeIcon = By.xpath("//a[@href='https://www.youtube.com/user/AmericasMart']"); // Locator for You Tube icon in footer links
	
	public AMFooterLinksNavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getFacebookIcon() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(FacebookIcon));
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


