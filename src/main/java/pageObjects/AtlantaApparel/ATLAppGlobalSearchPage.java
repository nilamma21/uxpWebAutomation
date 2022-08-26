package pageObjects.AtlantaApparel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class ATLAppGlobalSearchPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By Exhibitor = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h2[1]");
	By Product = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]");
	By ProductHeader = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/p[1]");
	By ProductName = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]");
	
	By ProductBlock = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	By AMCProductBlock = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]");
	By AMCProductNameDetails = By.xpath("//div[@id='root']/section[1]/div[4]/div[1]/div[1]/h2[1]");
	By AMCProductName = By.xpath("//div[@class='imc-vr--xxlarge']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]");
	By ATLAPPProductName = By.xpath("//div[@class='imc-vr--xxlarge']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]");
	By ATLMatktProductName = By.xpath("//div[@class='imc-vr--xxlarge']/div[2]/div[2]/div[1]/div[1]/div[4]/div[1]/a[1]/div[1]/div[1]/span[1]/span[1]");
	By VerifyGlobalSearch = By.xpath("//div[@class = 'imc-gallery__item']/div[1]/section[1]/span[1]/div[1]"); //Locator for verification of global search 
	
	public ATLAppGlobalSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getExhibitor()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Exhibitor));
		return driver.findElement(Exhibitor);

	}
	public WebElement getProduct()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Product));
		return driver.findElement(Product);

	}
	public WebElement getProductHeader()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductHeader));
		return driver.findElement(ProductHeader);

	}
	public WebElement getProductName()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductName));
		return driver.findElement(ProductName);

	}
	
	public WebElement getProductBlock()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductBlock));
		return driver.findElement(ProductBlock);

	}

	public WebElement getAMCProductBlock()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AMCProductBlock));
		return driver.findElement(AMCProductBlock);

	}

	public WebElement getAMCProductNameDetails()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AMCProductNameDetails));
		return driver.findElement(AMCProductNameDetails);

	}

	public WebElement getAMCProductName()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AMCProductName));
		return driver.findElement(AMCProductName);

	}

	public WebElement getATLAPPProductName()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLAPPProductName));
		return driver.findElement(ATLAPPProductName);

	}

	public WebElement getATLMarktProductName()throws InterruptedException{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ATLMatktProductName));
		return driver.findElement(ATLMatktProductName);

	}
	
	public WebElement getVerifyGlobalSearch()throws InterruptedException{
		Thread.sleep(10000);
		return driver.findElement(VerifyGlobalSearch);

	}
}
