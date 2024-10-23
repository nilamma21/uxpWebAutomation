package pageObjects.LasVegasMarket;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By GlobalSearchTextBox = By.xpath("//input[@id='input-1']"); // Locator for Global Search field 
	By SearchButton = By.xpath("//div[@class = 'imc-searchform--button--search']"); //Locator for Seach button for global search
	By VerifyGlobalSeacrh = By.xpath("(//h2[@class='imc-exhibitorcard__exhibitorname imc-exhibitorcard--title-hover'])[1]"); // Locator for global search verification
	
	public UXPGlobalSearchPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getGlobalSearchTextBox() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(GlobalSearchTextBox));
		return driver.findElement(GlobalSearchTextBox);

	}

	public WebElement getSearchButton() {
		//Wait till Sign In page is displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SearchButton));
		return driver.findElement(SearchButton);

	}
	
	public WebElement getVerifyGlobalSeacrh() throws InterruptedException {
		//Wait till Sign In page is displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyGlobalSeacrh));
		return driver.findElement(VerifyGlobalSeacrh);

	}
	
}



