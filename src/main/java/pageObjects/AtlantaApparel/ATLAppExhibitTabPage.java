package pageObjects.AtlantaApparel;

import java.time.Duration;

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
		this.driver = driver; 			
	} 

	public WebElement getatlAppExhibitInSocialOccasion() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(atlAppExhibitInSocialOccasion));
		return driver.findElement(atlAppExhibitInSocialOccasion);
	}


}
