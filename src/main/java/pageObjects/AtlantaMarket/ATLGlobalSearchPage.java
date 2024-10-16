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

	By atlglobalsearchtxtbx = By.xpath("//input[@id='input-1']"); // Locator for Global Search field 
	By atlsearchbtn = By.xpath("//div[@class = 'imc-searchform--button--search']"); //Locator for Seach button for global search
	By atlverifyglobalseacrh = By.xpath("//div[@class = 'imc-gallery__item']/div[1]/section[1]/span[1]/div[1]"); // Locator for global search verification
	
	public ATLGlobalSearchPage(WebDriver driver) {
		this.driver = driver; 			
	} 

	public WebElement getATLGlobalSearchTextBox() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlglobalsearchtxtbx));
		return driver.findElement(atlglobalsearchtxtbx);
	}

	public WebElement getATLSearchButton() throws InterruptedException {
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlsearchbtn));
		return driver.findElement(atlsearchbtn);
	}
	
	public WebElement getATLVerifyGlobalSeacrh() throws InterruptedException {
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(atlverifyglobalseacrh));
		return driver.findElement(atlverifyglobalseacrh);
	}
	
}



