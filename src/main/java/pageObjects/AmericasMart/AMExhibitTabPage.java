package pageObjects.AmericasMart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AMExhibitTabPage {
		
		public WebDriver driver;
		public WebDriverWait wait;

		By amcExhibitTab = By.xpath("(//a[contains(text(),'Exhibit')])[1]"); // Locator for Exhibit Tab
		By amcExhibitAtAmc=By.xpath("//a[contains(text(),'Exhibit at AmericasMart')]"); // Locator for Exhibit at AmericasMart
		By amcLeasingExhibitOptions=By.xpath("//a[@href='/Exhibit/Opportunities' and contains(text(),'Leasing & Exhibit Options')]");// Leasing & Exhibit Options
		By amcAdvertising=By.xpath("//a[@href='/Exhibit/Advertising' and  contains(text(),'Advertising')]"); // Locator for Advertising
		By amcExpLogin=By.xpath("//a[@title='The Exhibitor Portal Manages Your Exhibitor Account']");
		By amcExhFAQ=By.xpath("//a[@href='/Exhibit/FAQs' and contains(text(),'Exhibitor FAQs')]");
		By amcExpPotalHeader=By.xpath("//h2[contains(text(),'Sign in with your existing account')]");
		
		//h1[contains(text(),'Market Planner Account Login')]
		public AMExhibitTabPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver; 			
		} 

		public WebElement getamcExhibitTab() throws InterruptedException {
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(amcExhibitTab));
			return driver.findElement(amcExhibitTab);
		}
		
		public WebElement getExhibitAtAmc() throws InterruptedException {
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(amcExhibitAtAmc));
			return driver.findElement(amcExhibitAtAmc);
		}
		public WebElement getLeasingandExhibitOptions() throws InterruptedException {
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(amcLeasingExhibitOptions));
			return driver.findElement(amcLeasingExhibitOptions);
		}
		public WebElement getAdvertising() throws InterruptedException {
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(amcAdvertising));
			return driver.findElement(amcAdvertising);
		}
		public WebElement getExpLogin() throws InterruptedException {
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(amcExpLogin));
			return driver.findElement(amcExpLogin);
		}
		public WebElement getExpPortalHeader() throws InterruptedException {
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(amcExpPotalHeader));
			return driver.findElement(amcExpPotalHeader);
		}
		public WebElement getExpFAQs() throws InterruptedException {
			wait = new WebDriverWait (driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(amcExhFAQ));
			return driver.findElement(amcExhFAQ);
		}
		
}

