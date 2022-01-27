package pageObjects.AtlantaMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLExhibitorsAndProductsTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlexhibitorsnproducts = By.xpath("//div[@class='imc-section']/div[1]/div[2]/div[1]/a[1]"); //Locator for Exhibitors and Products header tab
	By atlexhibitordirectory = By.xpath("(//a[contains(@href,'/exhibitor/exhibitor-directory')])[position()=2]"); //Locator for ExhibitorDirectory header tab
	By atlfloorplans = By.xpath("//a[contains(text(), 'Floor Plans')]"); //Locator for Floor Plans header tab
	By atltemporaries = By.xpath("//a[contains(text(), 'Temporaries')]"); //Locator for Temporaries header tab
	By atlcategories = By.xpath("//a[contains(text(), 'Categories')]"); //Locator for Categories header tab
	By atlverifyexhibitorsnproductssection = By.xpath("//div[@class = 'imc-section']/div[1]/div[2]/div[2]"); //Locator for verification of Exhibitors and Products section
	By atlverifyexhibitordirectory = By.xpath("//ul[@class = 'imc-breadcrumb']/li[3]/a[1]"); // Locator for Exhibitor Directory text
	By atlverifyfloorplans = By.xpath("//div[@class = 'imc-campus-view']"); // Locator for floor plans map
	By atlshopzio = By.xpath("//a[contains(text(), 'ShopZio')]"); //Locator for ShopZio sub-menu
	By atlcatalogconnection = By.xpath("//a[contains(text(), 'Catalog ConneXion')]"); //Locator for Catalog Connection sub-menu
	By atljunipermarketuat = By.xpath("(//a[contains(text(), 'JuniperMarket')])[position()=2]"); //Locator for Juniper Market sub-menu
	By atlverifycatalogconnectpage = By.xpath("//h4[contains(text(), 'Welcome to Catalog Connexion!')]"); //Locator for Catalog Connection page validation
	By atlverifyjunipermrktpage = By.xpath("//img[@alt='JuniperMarket-Logo_Horiz-RGB-500']"); //Locator for Juniper Market page
	By JuniperMarketProd = By.xpath("//a[contains(text(), 'JuniperMarket')]"); //Locator for Juniper Market header tab



	public ATLExhibitorsAndProductsTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLExhibitorsAndProducts() {
		return driver.findElement(atlexhibitorsnproducts);
	}

	public WebElement getATLExhibitorDirectory() {
		return driver.findElement(atlexhibitordirectory);
	}

	public WebElement getATLFloorPlans() {
		return driver.findElement(atlfloorplans);
	}

	public WebElement getATLTemporaries() {
		return driver.findElement(atltemporaries);
	}

	public WebElement getATLCategories() {
		return driver.findElement(atlcategories);
	}

	public WebElement getATLVerifyExhibitorsAndProductsSection() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyexhibitorsnproductssection));
		return driver.findElement(atlverifyexhibitorsnproductssection);
	}

	public WebElement getATLVerifyExhibitorDirectory() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(atlverifyexhibitordirectory);
	}

	public WebElement getATLVerifyFloorPlans() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyfloorplans));
		return driver.findElement(atlverifyfloorplans);
	}

	public WebElement getATLVerifyCatalogsConnectPage() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifycatalogconnectpage));
		return driver.findElement(atlverifycatalogconnectpage);
	}
	
	public WebElement getJuniperMarketProd() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(JuniperMarketProd));
		return driver.findElement(JuniperMarketProd);
	}
	public WebElement getATLShopZioLink() {
		return driver.findElement(atlshopzio);
	}

	public WebElement getATLCatalogConnection() {
		return driver.findElement(atlcatalogconnection);
	}

	public WebElement getATLJunpiperMrktUAT() {
		return driver.findElement(atljunipermarketuat);
	}
	
	public WebElement getATLVerifyJuniperMarketUAT() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyjunipermrktpage));
		return driver.findElement(atlverifyjunipermrktpage);
	}
}



