package pageObjects.AtlantaMarket;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ATLExhibitorsAndProductsTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By atlexhibitorsnproducts = By.xpath("//nav[@class='imc-navigation-container']/descendant::a[contains(text(),'Exhibitors & Products')]"); //Locator for Exhibitors and Products header tab
	By atlexhibitordirectory = By.xpath("(//a[contains(@href,'/exhibitor/exhibitor-directory')])[position()=2]"); //Locator for ExhibitorDirectory header tab
	By atlfloorplans = By.xpath("//a[contains(text(), 'Floor Plans')]"); //Locator for Floor Plans header tab
	By atltemporaries = By.xpath("//a[contains(text(), 'Temporaries')]"); //Locator for Temporaries header tab
	By atlcategories = By.xpath("//a[contains(text(), 'Categories')]"); //Locator for Categories header tab
	By atlverifyexhibitorsnproductssection = By.xpath("//div[@class='imc-navigation-2tier']"); //Locator for verification of Exhibitors and Products section
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
		this.driver = driver; 			
	} 

	public WebElement getATLExhibitorsAndProducts() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitorsnproducts));
		return driver.findElement(atlexhibitorsnproducts);
	}

	public WebElement getATLExhibitorDirectory() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlexhibitordirectory));
		return driver.findElement(atlexhibitordirectory);
	}

	public WebElement getATLFloorPlans() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlfloorplans));
		return driver.findElement(atlfloorplans);
	}

	public WebElement getATLTemporaries() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atltemporaries));
		return driver.findElement(atltemporaries);
	}

	public WebElement getATLCategories() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlcategories));
		return driver.findElement(atlcategories);
	}

	public WebElement getATLVerifyExhibitorsAndProductsSection() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyexhibitorsnproductssection));
		return driver.findElement(atlverifyexhibitorsnproductssection);
	}

	public WebElement getATLVerifyExhibitorDirectory() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyexhibitordirectory));
		return driver.findElement(atlverifyexhibitordirectory);
	}

	public WebElement getATLVerifyFloorPlans() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyfloorplans));
		return driver.findElement(atlverifyfloorplans);
	}

	public WebElement getATLVerifyCatalogsConnectPage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifycatalogconnectpage));
		return driver.findElement(atlverifycatalogconnectpage);
	}
	
	public WebElement getJuniperMarketProd() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(JuniperMarketProd));
		return driver.findElement(JuniperMarketProd);
	}
	public WebElement getATLShopZioLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlshopzio));
		return driver.findElement(atlshopzio);
	}

	public WebElement getATLCatalogConnection() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlcatalogconnection));
		return driver.findElement(atlcatalogconnection);
	}

	public WebElement getATLJunpiperMrktUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atljunipermarketuat));
		return driver.findElement(atljunipermarketuat);
	}
	
	public WebElement getATLVerifyJuniperMarketUAT() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlverifyjunipermrktpage));
		return driver.findElement(atlverifyjunipermrktpage);
	}
	public WebElement getATLShowSpecialsPROD() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(atlshowspecialsprod));
		return driver.findElement(atlshowspecialsprod);
	}
	
	
}



