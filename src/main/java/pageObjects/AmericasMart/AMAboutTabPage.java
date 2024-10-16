package pageObjects.AmericasMart;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMAboutTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By Careers = By.xpath("(//a[@href='/About/Careers'])[position()=1]"); // Locator for Careers in About tab
	By ContactUs = By.xpath("(//a[@href='/About/Contact-Us'])[position()=1]"); // Locator for Contact Us in About tab
	By IndustryPartners = By.xpath("//a[@href='/About/Industry-Partners']"); // Locator for Instagram icon in footer links
	By ErrorAdvancedBtn = By.xpath("//button[@id = 'details-button']");
	By ErrorUnsafeWebLink = By.xpath("//a[@id = 'proceed-link']");
	By History = By.xpath("(//a[@href='/About/History'])[position()=1]");// Locator for Careers in History tab
	
	public AMAboutTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getCareers() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(Careers));
		return driver.findElement(Careers);

	}
	
	public WebElement getContactUs() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ContactUs));
		return driver.findElement(ContactUs);

	}

	public WebElement getIndustryPartners() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(IndustryPartners));
		return driver.findElement(IndustryPartners);

	}
	
	public WebElement getErrorAdvancedBtn() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ErrorAdvancedBtn));
		return driver.findElement(ErrorAdvancedBtn);

	}
	
	public WebElement getErrorUnsafeWebLink() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ErrorUnsafeWebLink));
		return driver.findElement(ErrorUnsafeWebLink);

	}
	
	   public WebElement getHistory() throws InterruptedException {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	        wait.until(ExpectedConditions.elementToBeClickable(History));
	        return driver.findElement(History);

	    }

}
