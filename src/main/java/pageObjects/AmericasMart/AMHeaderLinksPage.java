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
	
	
	public AMHeaderLinksPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getClosePrompt() throws InterruptedException {
		//Wait till Sign In page is displayed
		return driver.findElement(ClosePrompt);

	}

	
}


