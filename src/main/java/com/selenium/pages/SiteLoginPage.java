package com.selenium.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utils.Configuration;

public class SiteLoginPage {

	private static final Properties config = Configuration.loadProperties("site_test.properties");
	public static final String LOGIN_USERNAME = "username";
	public static final String LOGIN_PASSWORD = "password";
	public static final String LOGIN_BUTTON = ".btn.btn-success";
	private WebDriver driver;

	public SiteLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = LOGIN_USERNAME)
	private WebElement userName;

	@FindBy(name = LOGIN_PASSWORD)
	private WebElement password;

	@FindBy(css = LOGIN_BUTTON)
	private WebElement loginButton;

	@FindBy(xpath = "//input[@name='username']/following-sibling::span")
	private WebElement loginNameError;

	@FindBy(xpath = "//input[@name='password']/following-sibling::span")
	private WebElement loginPasswordError;

	public void writeInUsername() {
		userName.clear();
		userName.sendKeys(config.getProperty("property.username"));
	}

	public void writeInPassword() {
		password.clear();
		password.sendKeys(config.getProperty("property.password"));
	}

	public RegisterPage siteLogin() {
		loginButton.click();
		return new RegisterPage(driver);
	}

	public String getUsernameErrorData() {
		return loginNameError.getText();

	}

	public String getPasswordErrorData() {
		return loginPasswordError.getText();

	}

	public boolean usernameFieldIsDisplayed() {
		WebElement elem = driver.findElement(By.name(LOGIN_USERNAME));
		if (elem.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean PasswordFieldIsDisplayed() {
		WebElement elem = driver.findElement(By.name(LOGIN_PASSWORD));
		if (elem.isDisplayed())
			return true;
		else
			return false;
	}

	public boolean LoginButtonIsDisplayed() {
		WebElement elem = driver.findElement(By.name(LOGIN_BUTTON));
		if (elem.isDisplayed())
			return true;
		else
			return false;
	}

}
