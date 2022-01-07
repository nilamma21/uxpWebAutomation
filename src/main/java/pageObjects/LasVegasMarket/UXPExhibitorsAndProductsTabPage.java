package pageObjects.LasVegasMarket;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UXPExhibitorsAndProductsTabPage {

	public WebDriver driver;
	public WebDriverWait wait;

	By ExhibitorsAndProducts = By.xpath("//div[@class='imc-section']/div[1]/div[2]/div[1]/a[1]"); //Locator for Exhibitors and Products header tab
	By ExhibitorDirectory = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[1]/div[1]/a[1]"); //Locator for ExhibitorDirectory header tab
	By FloorPlans = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[1]/a[1]"); //Locator for Floor Plans header tab
	By ShowSpecials = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[2]/a[1]"); //Locator for ShowSpecials header tab
	By Temporaries = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[3]/a[1]"); //Locator for Temporaries header tab
	By NewProductIntroductions = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[2]/div[4]/a[1]"); //Locator for NoProductIntroductions header tab
	By Categories = By.xpath("//div[@class = 'imc-navigation__menu imc-content imc-navigation__menu--active imc-navigation__menu--fullwidth']/div[3]/div[1]/a[1]"); //Locator for Categories header tab
	By VerifyExhibitorsAndProductsSection = By.xpath("//div[@class = 'imc-section']/div[1]/div[2]/div[2]"); //Locator for verification of Exhibitors and Products section
	By VerifyExhibitorDirectory = By.xpath("//ul[@class = 'imc-breadcrumb']/li[3]/a[1]"); // Locator for Exhibitor Directory text
	By VerifyFloorPlans = By.xpath("//div[@class = 'imc-campus-view']"); // Locator for floor plans map



	public UXPExhibitorsAndProductsTabPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver; 			
	} 

	public WebElement getExhibitorsAndProducts() {
		//Wait till Sign In page is displayed
		return driver.findElement(ExhibitorsAndProducts);

	}

	public WebElement getExhibitorDirectory() {
		//Wait till Sign In page is displayed
		return driver.findElement(ExhibitorDirectory);

	}

	public WebElement getFloorPlans() {
		//Wait till Sign In page is displayed
		return driver.findElement(FloorPlans);

	}

	public WebElement getShowSpecials() {
		//Wait till Sign In page is displayed
		return driver.findElement(ShowSpecials);

	}

	public WebElement getTemporaries() {
		//Wait till Sign In page is displayed
		return driver.findElement(Temporaries);

	}

	public WebElement getNewProductIntroductions() {
		//Wait till Sign In page is displayed
		return driver.findElement(NewProductIntroductions);

	}

	public WebElement getCategories() {
		//Wait till Sign In page is displayed
		return driver.findElement(Categories);

	}

	public WebElement getVerifyExhibitorsAndProductsSection() {
		//Wait till Sign In page is displayed
		return driver.findElement(VerifyExhibitorsAndProductsSection);

	}

	public WebElement getVerifyExhibitorDirectory() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(VerifyExhibitorDirectory);

	}

	public WebElement getVerifyFloorPlans() throws InterruptedException {
		//Wait till Sign In page is displayed
		Thread.sleep(10000);
		return driver.findElement(VerifyFloorPlans);

	}
}


