package pageObjects.AtlantaApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLAppExhibitTabPage {

	public WebDriver driver;
	public WebDriverWait wait;


	By atlAppExhibitInSocialOccasion = By.xpath("//div[@class ='imc-section']/div[1]/div[4]/div[2]/div[2]/div[3]/a[1]"); 



	public ATLAppExhibitTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getatlAppExhibitInSocialOccasion() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(atlAppExhibitInSocialOccasion));
		return driver.findElement(atlAppExhibitInSocialOccasion);
	}


}
