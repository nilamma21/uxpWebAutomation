package pageObjects.AmericasMart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPExhibitorDirectoryPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ExhibitorDirectory = By.xpath("//a[@title='Exhibitor & Product Directory']"); // Locator for Exhibitor Directory on Home Page
	
	
	public UXPExhibitorDirectoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getExhibitorDirectory() throws InterruptedException {
		//Wait till Sign In page is displayed
		return driver.findElement(ExhibitorDirectory);

	}

	
}


