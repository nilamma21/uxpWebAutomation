package pageObjects.LasVegasMarket;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPExhibitorDirectoryPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ExhibitorDirectory = By.xpath("//a[@title='Exhibitor & Product Directory']"); // Locator for Exhibitor Directory on Home Page
	
	
	public UXPExhibitorDirectoryPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getExhibitorDirectory() throws InterruptedException {
		//Wait till Sign In page is displayed
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ExhibitorDirectory));
		return driver.findElement(ExhibitorDirectory);

	}

	
}


