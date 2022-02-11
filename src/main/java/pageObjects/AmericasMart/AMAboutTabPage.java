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

	By Careers = By.xpath("//div[@class = 'imc-section']/div[1]/div[1]/div[2]/div[4]/div[1]/a[1]"); // Locator for Careers in About tab
	By ContactUs = By.xpath("//div[@class = 'imc-section']/div[1]/div[1]/div[2]/div[4]/div[2]/a[1]"); // Locator for Contact Us in About tab
	By IndustryPartners = By.xpath("//div[@class = 'imc-section']/div[1]/div[1]/div[2]/div[4]/div[3]/a[1]"); // Locator for Instagram icon in footer links
	
	
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

}
