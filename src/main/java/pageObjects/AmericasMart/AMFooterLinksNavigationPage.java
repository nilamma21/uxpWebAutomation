package pageObjects.AmericasMart;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMFooterLinksNavigationPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By FacebookIcon = By.xpath("//a[@href = 'https://www.facebook.com/AmericasmartAtl']"); // Locator for Facebook icon in footer links
	By TwitterIcon = By.xpath("//a[@href='https://twitter.com/americasmartatl']"); // Locator for Twitter icon in footer links
	By InstagramIcon = By.xpath("//a[@href='https://www.instagram.com/americasmartatl/'])[position()=2]']"); // Locator for Instagram icon in footer links
	By YoutubeIcon = By.xpath("//a[@href='https://www.youtube.com/user/AmericasMart']"); // Locator for You Tube icon in footer links
	By internationalmarketcenters = By.xpath("//a[@href='https://imcenters.com/']"); //Locator for International Market Centers in footer links
	By lasvegasapparellink = By.xpath("(//a[@href='https://www.lasvegas-apparel.com/'])[position()=2]"); //Locator for Las Vegas Apparel footer link
	
	public AMFooterLinksNavigationPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getFacebookIcon() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(FacebookIcon));
		return driver.findElement(FacebookIcon);

	}
	
	public WebElement getTwitterIcon() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(TwitterIcon));
		return driver.findElement(TwitterIcon);

	}

	public WebElement getInstagramIcon() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(InstagramIcon));
		return driver.findElement(InstagramIcon);

	}

	public WebElement getYoutubeIcon() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(YoutubeIcon));
		return driver.findElement(YoutubeIcon);
	}
	
	public WebElement getinternationalmarketcenters() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(internationalmarketcenters));
		return driver.findElement(internationalmarketcenters);
	}
	
	public WebElement getLasVegasApparelLink() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lasvegasapparellink));
		return driver.findElement(lasvegasapparellink);
	}

}


