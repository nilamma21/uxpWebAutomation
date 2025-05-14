package resources;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
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
	
	public void scrollToBottom() throws InterruptedException {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(200);
	}
	
    public void waitForPageToLoad() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        // Wait until the document readyState is 'complete'
        wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));
        Thread.sleep(1000);
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
    
    // Utility method to handle switching between windows/tabs (handles both same window and new tab cases)
    public void windowHandle(WebElement elementToClick, String expectedTitle) throws InterruptedException {
        // Store the current window handle (main window)
        String mainWindowHandle = driver.getWindowHandle();
        
        // Get the number of current window handles before clicking
        Set<String> windowHandlesBeforeClick = driver.getWindowHandles();
        Thread.sleep(100);
        // Click on the element (link or button) that opens the new window or stays in the same window
        elementToClick.click();
        
        // Wait for the new window/tab to open if any
        Set<String> windowHandlesAfterClick = driver.getWindowHandles();
        
        // Check if a new window/tab has been opened
        if (windowHandlesAfterClick.size() > windowHandlesBeforeClick.size()) {
            // A new window/tab has opened
            for (String handle : windowHandlesAfterClick) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        }
        
        // Perform the verification/assertion on the current window (whether it's a new tab or the same window)
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedTitle), "Expected title is not present.");
        Thread.sleep(500);
        // If a new window was opened, close it and switch back to the original window
        if (windowHandlesAfterClick.size() > windowHandlesBeforeClick.size()) {
            driver.close(); // Close the new window
            driver.switchTo().window(mainWindowHandle); // Switch back to the original window
        }
    }
    
    // Utility method to handle switching between windows/tabs (handles both same window and new tab cases)
    public void windowHandleTitle(WebElement elementToClick, String expectedTitle) throws InterruptedException {
        // Store the current window handle (main window)
        String mainWindowHandle = driver.getWindowHandle();
        
        // Get the number of current window handles before clicking
        Set<String> windowHandlesBeforeClick = driver.getWindowHandles();
        Thread.sleep(100);
        // Click on the element (link or button) that opens the new window or stays in the same window
        elementToClick.click();
        
        // Wait for the new window/tab to open if any
        Set<String> windowHandlesAfterClick = driver.getWindowHandles();
        
        // Check if a new window/tab has been opened
        if (windowHandlesAfterClick.size() > windowHandlesBeforeClick.size()) {
            // A new window/tab has opened
            for (String handle : windowHandlesAfterClick) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
        }
        
        // Perform the verification/assertion on the current window (whether it's a new tab or the same window)
        Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Expected title is not present.");
        Thread.sleep(500);
        // If a new window was opened, close it and switch back to the original window
        if (windowHandlesAfterClick.size() > windowHandlesBeforeClick.size()) {
            driver.close(); // Close the new window
            driver.switchTo().window(mainWindowHandle); // Switch back to the original window
        }
    }
	
}
