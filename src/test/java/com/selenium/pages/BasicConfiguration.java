package com.selenium.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.selenium.utils.Configuration;

public class BasicConfiguration {

	protected static WebDriver chromeDriver;
	protected SoftAssert softAssert = new SoftAssert();
	private static final Properties config = Configuration.loadProperties("site_test.properties");

	@BeforeMethod(description = "configure browser and  driver before test")
	public void setup() {
		System.setProperty("webdriver.chrome.whitelistedIps", "");

		System.setProperty("webdriver.chrome.driver", config.getProperty("chromedriver"));
		chromeDriver = new ChromeDriver();

		chromeDriver.manage().window().maximize();
		chromeDriver.manage().deleteAllCookies();
		chromeDriver.manage().timeouts().getImplicitWaitTimeout().getSeconds();
		chromeDriver.get(config.getProperty("siteurl"));

	}

	@AfterTest(alwaysRun = true, description = "cleanup and close browser with driver")
	public void cleanup() {
		if (chromeDriver != null) {
			chromeDriver.manage().deleteAllCookies();

			chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			chromeDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
			chromeDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

			chromeDriver.close();
			chromeDriver.quit();
		}
	}
}
