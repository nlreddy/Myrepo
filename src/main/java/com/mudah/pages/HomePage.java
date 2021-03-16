package com.mudah.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.mudah.base.DriverManager;

public class HomePage extends DriverManager {

	String userID = prop.getProperty("username");
	String pwd = prop.getProperty("password");
	
	JavascriptExecutor js;



	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	// web element locator for home pag:
	@FindBy(xpath = "(.//*[text()='Sign in'])[1]")
	WebElement sign_link;

	// web element locator for private link
	@FindBy(xpath = "(//*[text()='Start here.'])[1]")
	WebElement start_link_prvt;

	// web element locator for private individual account sing up
	@FindBy(xpath = "(//*[text()='SIGN UP'])[1]")
	WebElement sing_up_private_individual;

	// web element private individual account text
	@FindBy(xpath = "(//*[text()='Private (Individual) Account'])")
	WebElement private_individual_text;

	@FindBy(name = "email")
	WebElement emailAddress_input;

	@FindBy(name = "password")
	WebElement password_input;

	@FindBy(name = "verification_password")
	WebElement retypePassword_input;

	@FindBy(xpath = "//*[text()='Sign up with your email.']")
	WebElement signupWithEmail;

	// private user sing up check box
	@FindBy(xpath = "//*[@type='checkbox']")
	WebElement signUpCheckBox;
	
	@FindBy(xpath="//*[text()='SIGN UP']")
	WebElement pvtActSignUp_btn;

	
	// this method perform Private user registration 
	public void validatePrivateRegistration() throws IOException {

		String homePageTitle = driver.getTitle();
		logger.log(Status.INFO, "User navigate to home page ");
		Assert.assertEquals(homePageTitle,
				"Malaysia's Largest Marketplace - Buy & Sell Your New and Preloved Items - Mudah.my - Mudah.my");
		
		logger.log(Status.PASS, "User valiated application title is:"+homePageTitle);

		

		sign_link.click();
		logger.log(Status.INFO, "User clicked on Sing in from home page");

		// logger.log(Status.ERROR, "failed after click..");

		String userAccountTitle = driver.getTitle();

		Assert.assertEquals(userAccountTitle, "Mudah User Account");
		
		logger.log(Status.PASS, "User valiated application title is:"+userAccountTitle);
		
		

		start_link_prvt.click();
		logger.log(Status.INFO, "User clicked on Start here link");

		Assert.assertEquals(userAccountTitle, "Mudah User Account");
		logger.log(Status.PASS, "User valiated application title is:"+userAccountTitle);

		boolean b = private_individual_text.isDisplayed();

		Assert.assertTrue(b);
		sing_up_private_individual.click();
		logger.log(Status.INFO, "User clicked on SIGN UP from register page");
		
		Assert.assertTrue(signupWithEmail.isDisplayed());
		logger.log(Status.PASS, "User valiated Private Account page");
		

		emailAddress_input.sendKeys(userID);
		logger.log(Status.INFO, "User entered email ID as"+userID);
		
		password_input.sendKeys(pwd);
		retypePassword_input.sendKeys(pwd);
		
		logger.log(Status.INFO, "User entered email ID as"+pwd);

		signUpCheckBox.click();
		logger.log(Status.INFO, "User clicked on check box for to receive exciting news");
		
		String checkedStatus = signUpCheckBox.getAttribute("value");

		
		 js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0, 250)");
		
		pvtActSignUp_btn.click();
		logger.log(Status.INFO, "User clicked on SIGN UP button on private account page.");
	}

	// this method will quit selenium driver.
	public void quit() {

		driver.quit();
	}

}
