package pageObjects.AmericasMart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMHeaderLinksPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ClosePrompt = By.xpath("//div[@class=' contact-exit']"); // Locator for Close Prompt on Home Page
	By ExploreMaketBtn = By.xpath("//a[@class = 'imc-button imc-section--neutral-heaviest']"); //Locator for Explore Market button
	By ExhbAndProdsTab = By.xpath("//section[@class = 'imc-site-wrapper']"); //Locator for Exhibitors and products tab
	
	public AMHeaderLinksPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getClosePrompt() throws InterruptedException {
		//Wait till Sign In page is displayed
		return driver.findElement(ClosePrompt);

	}
	
	public WebElement getExploreMaketBtn() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ExploreMaketBtn));
		return driver.findElement(ExploreMaketBtn);

	}

	public WebElement getExhbAndProdsTab() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(ExhbAndProdsTab));
		return driver.findElement(ExhbAndProdsTab);

	}

	
}


