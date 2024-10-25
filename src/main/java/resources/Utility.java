package resources;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;

public class Utility extends base {

	// public WebDriver driver;
	UXPLandingPage lap;
	UXPLoginPage lp;
	public WebDriverWait wait;

	@SuppressWarnings("static-access")
	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement scrollToElement(WebElement element) throws InterruptedException {
		WebElement scrollText = element;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollText);
		Thread.sleep(4000);
		return element;
	}
	
	public void scrollToTop() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(4000);
	}
	
	public void scrollIntoView(WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void scrollElementIntoMiddle (WebElement element) throws InterruptedException {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(200);
	}

	public void verifyMPLoginFunctionality() throws IOException, InterruptedException {

		// The purpose of this test case to verify:-
		// TS1- Login to Market Planner

		lap = new UXPLandingPage(driver);
		lp = new UXPLoginPage(driver);

		// Click on Login button from Landing Page
		lap.getLogin().click();

		// Enter the credentials on Login Page and click
		lp.getEmailAddress().sendKeys((prop.getProperty("username")));
		lp.getPassword().sendKeys((prop.getProperty("password")));

		lp.getSignInBtn().click();

	}
	public void verifyCloseBtnPopup() throws IOException, InterruptedException {

		lap = new UXPLandingPage(driver);	

		try {
			lap.getCloseMarktAdBtn().click();
		}catch(Exception e) {
		  e.getMessage();
		}
	}
    public void clickAndAssertUrl( WebElement linkElement) throws InterruptedException {
        
    	
    	Thread.sleep(2000);
        String expectedUrl = linkElement.getAttribute("href");  // Get the href attribute
        linkElement.click();  // Click the link
        Thread.sleep(2000);
       // System.out.println("Click on "+linkElement.getText());
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedUrl));  // Assert the current URL
        Thread.sleep(3000); 
        
    }


	
}
