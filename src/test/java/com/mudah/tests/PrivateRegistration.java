package com.mudah.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mudah.base.DriverManager;
import com.mudah.pages.HomePage;
import com.mudah.pages.Registration;
import com.mudah.pages.UserAccount;

public class PrivateRegistration extends DriverManager {

	HomePage homePage;
	UserAccount userAcnt;
	Registration registration;

	public PrivateRegistration() {
		super();

	}

	// this method initializes all required objects
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();

		homePage = new HomePage();

	}

	// this test will be executed as first priority
	@Test(priority = 1)
	public void registerPrivateUser() throws IOException {

		extent.attachReporter(rep);
		logger = extent.createTest("Verify Private User registration");

		homePage.validatePrivateRegistration();

	}

	// this method flushes test reports & calls quit method..
	@AfterClass
	public void quit() {
		extent.flush();
		homePage.quit();

	}

}