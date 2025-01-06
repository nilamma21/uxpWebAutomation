package pageObjects.AtlantaMarket;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlglobalsearchtxtbx = By.xpath("//button[@class='imc-button imc-button--search imc-button--transparent-mobile-header imc-button--transparent juniper-search-v3 ']"); // Locator for Global Search field 
	By atlsearchbtn = By.xpath("((//div[@class = 'imc-searchform--button--search']/button))[3]"); //Locator for Seach button for global search
	By atlverifyglobalseacrh = By.xpath("(//div[@class = 'imc-exhibitorcard-title-row ']/descendant::h2)[1]"); // Locator for global search verification
	By GlobalSearchEnterText = By.xpath("//div[@class='top-nav-dropdown-grid imc-content--relative']/div/div/section/div/form/div/input"); // Locator for Global Search field

	
	public ATLGlobalSearchPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getATLGlobalSearchTextBox() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlglobalsearchtxtbx));
		return driver.findElement(atlglobalsearchtxtbx);
	}

	public WebElement getATLSearchButton() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchbtn));
		return driver.findElement(atlsearchbtn);
	}
	
	public WebElement getATLVerifyGlobalSeacrh() throws InterruptedException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlverifyglobalseacrh));
		return driver.findElement(atlverifyglobalseacrh);
	}
	
	public WebElement getGlobalSearchEnterText() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(GlobalSearchEnterText));
		return driver.findElement(GlobalSearchEnterText);

	}
	
}



