package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By GlobalSearchTextBox = By.xpath("//input[@id='input-1']"); // Locator for Global Search field 
	By SearchButton = By.xpath("//button[@class = 'imc-searchform--button--search']"); //Locator for Seach button for global search
	By VerifyGlobalSeacrh = By.xpath("//section[@class = 'imc-searchform--section ']/span[1]/div[1]"); // Locator for global search verification
	
	public UXPGlobalSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getGlobalSearchTextBox() throws InterruptedException {
		//Wait till Sign In page is displayed
		return driver.findElement(GlobalSearchTextBox);

	}

	public WebElement getSearchButton() {
		//Wait till Sign In page is displayed
		return driver.findElement(SearchButton);

	}
	
	public WebElement getVerifyGlobalSeacrh() throws InterruptedException {
		//Wait till Sign In page is displayed
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyGlobalSeacrh));
		return driver.findElement(VerifyGlobalSeacrh);

	}
	
}



