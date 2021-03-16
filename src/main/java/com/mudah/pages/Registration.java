package com.mudah.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	public Registration(WebDriver driver) {
		
		this.driver = driver;
		
		this.wait = new WebDriverWait(driver, 30);
		
		
		
	}
	
	

}
