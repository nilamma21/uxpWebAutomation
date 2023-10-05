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
	By atlverifyjunipermrktpage = By.xpath("(//img[@alt='JuniperMarket'])[position()=2]"); //Locator for Juniper Market page
	By JuniperMarketProd = By.xpath("//a[contains(text(), 'JuniperMarket')]"); //Locator for Juniper Market header tab
	By atlshowspecialsprod = By.xpath("//a[@href='/exhibitor/Show-Specials']"); //Locator for Show Specials menu


	public ATLExhibitorsAndProductsTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getATLExhibitorsAndProducts() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitorsnproducts));
		return driver.findElement(atlexhibitorsnproducts);
	}

	public WebElement getATLExhibitorDirectory() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitordirectory));
		return driver.findElement(atlexhibitordirectory);
	}

	public WebElement getATLFloorPlans() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlfloorplans));
		return driver.findElement(atlfloorplans);
	}

	public WebElement getATLTemporaries() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atltemporaries));
		return driver.findElement(atltemporaries);
	}

	public WebElement getATLCategories() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlcategories));
		return driver.findElement(atlcategories);
	}

	public WebElement getATLVerifyExhibitorsAndProductsSection() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyexhibitorsnproductssection));
		return driver.findElement(atlverifyexhibitorsnproductssection);
	}

	public WebElement getATLVerifyExhibitorDirectory() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyexhibitordirectory));
		return driver.findElement(atlverifyexhibitordirectory);
	}

	public WebElement getATLVerifyFloorPlans() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyfloorplans));
		return driver.findElement(atlverifyfloorplans);
	}

	public WebElement getATLVerifyCatalogsConnectPage() throws InterruptedException {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifycatalogconnectpage));
		return driver.findElement(atlverifycatalogconnectpage);
	}
	
	public WebElement getJuniperMarketProd() {
		wait = new WebDriverWait (driver,30);
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
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyjunipermrktpage));
		return driver.findElement(atlverifyjunipermrktpage);
	}
	public WebElement getATLShowSpecialsPROD() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlshowspecialsprod));
		return driver.findElement(atlshowspecialsprod);
	}
	
	
}



