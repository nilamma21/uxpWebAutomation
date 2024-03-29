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
		By amcExhibitAtAmc=By.xpath("//div[@class = 'imc-section']/div[1]/div[4]/div[2]/div[1]/div[1]/a[1]"); // Locator for Exhibit at AmericasMart
		By amcLeasingExhibitOptions=By.xpath("//a[@href='/Exhibit/Opportunities' and contains(text(),'Leasing & Exhibit Options')]");// Leasing & Exhibit Options
		By amcAdvertising=By.xpath("//a[@href='/Exhibit/Advertising' and  contains(text(),'Advertising')]"); // Locator for Advertising
		By amcExpLogin=By.xpath("//a[@title='The Exhibitor Portal Manages Your Exhibitor Account']");//EXP Login
		By amcExhFAQ=By.xpath("//a[@href='/Exhibit/FAQs' and contains(text(),'Exhibitor FAQs')]");
		By amcExpPotalHeader=By.xpath("//h2[contains(text(),'Sign in with your existing account')]");
		By amcexhibitbrdcrumb = By.xpath("//ul[@class='imc-breadcrumb']/li[2]/a"); //Locator for Exhibit Breadcrumb
		By amcExpGuide=By.xpath("//a[contains(text(),'Exhibitor Portal Guide')]");//EXP Guide
		
		public AMExhibitTabPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver; 			
		} 

		public WebElement getamcExhibitTab() throws InterruptedException {
			Thread.sleep(3000);
			wait = new WebDriverWait (driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(amcExhibitTab));
			return driver.findElement(amcExhibitTab);
		}
		
		public WebElement getExhibitAtAmc() throws InterruptedException {
			wait = new WebDriverWait (driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(amcExhibitAtAmc));
			return driver.findElement(amcExhibitAtAmc);
		}
		public WebElement getLeasingandExhibitOptions() throws InterruptedException {
			wait = new WebDriverWait (driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(amcLeasingExhibitOptions));
			return driver.findElement(amcLeasingExhibitOptions);
		}
		public WebElement getAdvertising() throws InterruptedException {
			wait = new WebDriverWait (driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(amcAdvertising));
			return driver.findElement(amcAdvertising);
		}
		public WebElement getExpLogin() throws InterruptedException {
			wait = new WebDriverWait (driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(amcExpLogin));
			return driver.findElement(amcExpLogin);
		}
		public WebElement getExpPortalHeader() throws InterruptedException {
			wait = new WebDriverWait (driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(amcExpPotalHeader));
			return driver.findElement(amcExpPotalHeader);
		}
		public WebElement getExpFAQs() throws InterruptedException {
			wait = new WebDriverWait (driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(amcExhFAQ));
			return driver.findElement(amcExhFAQ);
		}
		public WebElement getAMCExhibitBrdcrumb() throws InterruptedException {
			Thread.sleep(8000);
			return driver.findElement(amcexhibitbrdcrumb);
		}
		public WebElement getExpGuide() throws InterruptedException {
			wait = new WebDriverWait (driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(amcExpGuide));
			return driver.findElement(amcExpGuide);
		}
}

