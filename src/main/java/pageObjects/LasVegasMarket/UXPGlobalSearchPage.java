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
	By GlobalSearchTextBoxNew = By.xpath("//button[@class='imc-button imc-button--search imc-button--transparent-mobile-header imc-button--transparent juniper-search-v3 ']"); // Locator for Global Search field 
	By SearchButtonNew = By.xpath("(//div[@class = 'imc-searchform--button--search'])[3]"); //Locator for Seach button for global search
	
	By VerifyGlobalSeacrhNew = By.xpath("(//div[@class = 'imc-content--full-width']/descendant::h2)[1]"); // Locator for global search verification
	By VerifyGlobalSeacrhNewSecond = By.xpath("(//div[@class = 'imc-content--full-width']/descendant::h2)[2]");
	By GlobalSearchEnterText = By.xpath("//div[@class='top-nav-dropdown-grid imc-content--relative']/div/div/section/div/form/div/input"); // Locator for Global Search field
	By VerifyGlobalSeacrhSecond = By.xpath("(//h2[@class='imc-exhibitorcard__exhibitorname imc-exhibitorcard--title-hover'])[2]"); // Locator for global search verification
	By GlobalSearchTextBoxTwo = By.xpath("(//input[@id='input-1'])[2]"); //Locator for exhibitor directory Search field 
	By SearchButtonED = By.xpath("(//div[@class = 'imc-searchform--button--search'])[2]"); //Locator for Seach button for global search

	
	public UXPGlobalSearchPage(WebDriver driver) {
		this.driver = driver; 			
	} 
	public WebElement getGlobalSearchEnterText() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(GlobalSearchEnterText));
		return driver.findElement(GlobalSearchEnterText);

	}

	public WebElement getVerifyGlobalSeacrhNew() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyGlobalSeacrhNew));
		return driver.findElement(VerifyGlobalSeacrhNew);

	}
	
	public WebElement getVerifyGlobalSeacrhNewSecond() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyGlobalSeacrhNewSecond));
		return driver.findElement(VerifyGlobalSeacrhNewSecond);

	}
	
	public WebElement getSearchButtonNew() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SearchButtonNew));
		return driver.findElement(SearchButtonNew);

	}
	public WebElement getGlobalSearchTextBoxNew() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(GlobalSearchTextBoxNew));
		return driver.findElement(GlobalSearchTextBoxNew);

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
	public WebElement getVerifyGlobalSeacrhSecond() throws InterruptedException {
		//Wait till Sign In page is displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(VerifyGlobalSeacrhSecond));
		return driver.findElement(VerifyGlobalSeacrhSecond);
	}
			
	public WebElement getGlobalSearchTextBoxTwo() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(GlobalSearchTextBoxTwo));
		return driver.findElement(GlobalSearchTextBoxTwo);

	}
	
	public WebElement getSearchButtonED() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(SearchButtonED));
		return driver.findElement(SearchButtonED);

	}
}



