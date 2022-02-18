package pageObjects.AmericasMart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMAboutTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By Careers = By.xpath("(//a[@href='/About/Careers'])[position()=1]"); // Locator for Careers in About tab
	By ContactUs = By.xpath("(//a[@href='/About/Contact-Us'])[position()=1]"); // Locator for Contact Us in About tab
	By IndustryPartners = By.xpath("//a[@href='/About/Industry-Partners']"); // Locator for Instagram icon in footer links
	By ErrorAdvancedBtn = By.xpath("//button[@id = 'details-button']");
	By ErrorUnsafeWebLink = By.xpath("//a[@id = 'proceed-link']");
	
	public AMAboutTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getCareers() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Careers));
		return driver.findElement(Careers);

	}
	
	public WebElement getContactUs() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ContactUs));
		return driver.findElement(ContactUs);

	}

	public WebElement getIndustryPartners() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(IndustryPartners));
		return driver.findElement(IndustryPartners);

	}
	
	public WebElement getErrorAdvancedBtn() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ErrorAdvancedBtn));
		return driver.findElement(ErrorAdvancedBtn);

	}
	
	public WebElement getErrorUnsafeWebLink() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ErrorUnsafeWebLink));
		return driver.findElement(ErrorUnsafeWebLink);

	}

}
