package pageObjects.AmericasMart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMExhibitTabPage {
		
		public WebDriver driver;
		public WebDriverWait wait;

		By amcExhibitTab = By.xpath("(//a[contains(text(),'Exhibit')])[1]"); // Locator for Exhibit Tab
		By amcExhibitAtAmc=By.xpath("//a[@href='/Exhibit']"); // Locator for Exhibit at AmericasMart
		By amcLeasingExhibitOptions=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Leasing & Exhibit Options')]");// Leasing & Exhibit Options
		By amcAdvertising=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Advertising')]"); // Locator for Advertising
		By amcExpLogin=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Exhibitor Portal Login')]");//EXP Login
		By amcExhFAQ=By.xpath("//a[@class='imc-link imc-navigation__tier2Link' and contains(text(),'Exhibitor FAQs')]");
		By amcExpPotalHeader=By.xpath("//h2[contains(text(),'Sign in with your existing account')]");
		By amcexhibitbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[2]/a"); //Locator for Exhibit Breadcrumb
		By amcExpGuide=By.xpath("//a[contains(text(),'Exhibitor Portal Guide')]");//EXP Guide
		
		public AMExhibitTabPage(WebDriver driver) {
			this.driver = driver; 			
		} 

		public WebElement getamcExhibitTab() throws InterruptedException {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOfElementLocated(amcExhibitTab));
			return driver.findElement(amcExhibitTab);
		}
		
		public WebElement getExhibitAtAmc() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOfElementLocated(amcExhibitAtAmc));
			return driver.findElement(amcExhibitAtAmc);
		}
		public WebElement getLeasingandExhibitOptions() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(amcLeasingExhibitOptions));
			return driver.findElement(amcLeasingExhibitOptions);
		}
		public WebElement getAdvertising() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(amcAdvertising));
			return driver.findElement(amcAdvertising);
		}
		public WebElement getExpLogin() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(amcExpLogin));
			return driver.findElement(amcExpLogin);
		}
		public WebElement getExpPortalHeader() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.visibilityOfElementLocated(amcExpPotalHeader));
			return driver.findElement(amcExpPotalHeader);
		}
		public WebElement getExpFAQs() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(amcExhFAQ));
			return driver.findElement(amcExhFAQ);
		}
		public WebElement getAMCExhibitBrdcrumb() throws InterruptedException {
			Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(amcexhibitbrdcrumb));
			return driver.findElement(amcexhibitbrdcrumb);
		}
		public WebElement getExpGuide() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(amcExpGuide));
			return driver.findElement(amcExpGuide);
		}
}

