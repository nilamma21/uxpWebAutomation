package resources;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
=======
>>>>>>> e9f35f02c6055e43bd3fd5bced18701a3282ea88

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

<<<<<<< HEAD
import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

import atlantamarket_UAT.MarketPlanner;
import pageObjects.AtlantaMarket.ATLEventsAndWebinarPage;
import pageObjects.AtlantaMarket.ATLExhLineProdActionsPage;
import pageObjects.AtlantaMarket.ATLGlobalSearchPage;
import pageObjects.AtlantaMarket.ATLLandingPage;
import pageObjects.AtlantaMarket.ATLLoginPage;
import pageObjects.AtlantaMarket.ATLMarketPlannerPage;
=======
import pageObjects.LasVegasMarket.UXPLandingPage;
import pageObjects.LasVegasMarket.UXPLoginPage;
>>>>>>> e9f35f02c6055e43bd3fd5bced18701a3282ea88

public class Utility extends base {

	// public WebDriver driver;
<<<<<<< HEAD
	ATLLandingPage lap;
	ATLLoginPage lp;
	ATLExhLineProdActionsPage atlexhact;
	MarketPlanner mp;
	ATLMarketPlannerPage atlmppge;
	ATLGlobalSearchPage atlgs;
	ATLEventsAndWebinarPage atlevents;
	GenerateData genData;
=======
	UXPLandingPage lap;
	UXPLoginPage lp;
>>>>>>> e9f35f02c6055e43bd3fd5bced18701a3282ea88

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
}