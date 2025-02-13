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

	By AboutTab = By.xpath("//div[@class='imc-content--display-flex imc-content--display-flex-gap-small imc-content--display-flex-justify-center imc-content--full-height']/descendant::span[contains(text(),'About')]/../.."); //About tab
	By AboutAmericasMart = By.xpath("//a[@href=\"/About\" and contains(text(),'About AmericasMart')]");
	By Careers = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Careers')]"); // Locator for Careers in About tab
	By ContactUs = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Contact Us')]"); // Locator for Contact Us in About tab
	By IndustryPartners = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Industry Partners')]"); // Locator for Instagram icon in footer links
	By ErrorAdvancedBtn = By.xpath("//button[@id = 'details-button']");
	By ErrorUnsafeWebLink = By.xpath("//a[@id = 'proceed-link']");
	By History = By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'History')]");// Locator for Careers in History tab
	By Secondrynavigation = By.xpath("//div[@class='imc-navigation-2tier']");
	By AtlantaConventionCenter = By.xpath("//a[@href='https://www.atlconventioncenter.com/' and contains(text(),'Atlanta Convention Center')]");
	
	public AMAboutTabPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	public WebElement getCareers() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(Careers));
		return driver.findElement(Careers);
	}
	public WebElement getContactUs() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ContactUs));
		return driver.findElement(ContactUs);
	}
	public WebElement getIndustryPartners() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(IndustryPartners));
		return driver.findElement(IndustryPartners);
	}
	public WebElement getErrorAdvancedBtn() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ErrorAdvancedBtn));
		return driver.findElement(ErrorAdvancedBtn);
	}
	public WebElement getErrorUnsafeWebLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(ErrorUnsafeWebLink));
		return driver.findElement(ErrorUnsafeWebLink);
	}
	public WebElement getHistory() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(History));
		return driver.findElement(History);
	}
	public WebElement getAboutTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AboutTab));
		return driver.findElement(AboutTab);
	}
	public WebElement getSecondrynavigation() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(Secondrynavigation));
		return driver.findElement(Secondrynavigation);
	}
	public WebElement getAboutAmericasMart() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AboutAmericasMart));
		return driver.findElement(AboutAmericasMart);
	}
	public WebElement getAtlantaConventionCenter() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(AtlantaConventionCenter));
		return driver.findElement(AtlantaConventionCenter);
	}
}
