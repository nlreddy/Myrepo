package com.mudah.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mudah.utils.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	// public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static ChromeDriver driver;//
	public static FirefoxDriver fdriver;

	public static ExtentReports extent;

	public static ExtentHtmlReporter rep;

	public static ExtentTest logger;

	public DriverManager() {

		WebDriverManager.chromedriver().setup();

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/" + "com/mudah/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		rep = new ExtentHtmlReporter("./Reports/report.html");
		//
		extent = new ExtentReports();

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equals("FF")) {

			fdriver = new FirefoxDriver();

		}

	

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}
