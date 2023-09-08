package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLExhibitorDirectoryPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlexhibitordirectoryoptn = By.xpath("//span[@title='Exhibitor Directory'][1]"); // Locator for Exhibitor Directory on Home Page
	By atlexhdirtsearchtxtbx = By.xpath("(//input[@id='input-1'])[position()=2]"); //Locator for Exhibitor Directory Search text box
	By atlexhdirtsearchbtn = By.xpath("(//button[@class = 'imc-searchform--button--search'])[position()=2]"); //Locator for Exhibitor Directory Search btn
	
	public ATLExhibitorDirectoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLExhibitorDirectory() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitordirectoryoptn));
		return driver.findElement(atlexhibitordirectoryoptn);
	}

	public WebElement getATLExhDirtSearchBox() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhdirtsearchtxtbx));
		return driver.findElement(atlexhdirtsearchtxtbx);
	}
	public WebElement getATLExhDirtSearchBtn() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhdirtsearchbtn));
		return driver.findElement(atlexhdirtsearchbtn);
	}
}


