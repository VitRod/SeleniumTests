package com.selenium.pages;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

@Listeners(PageTestListener.class)
public class SiteLoginPageTest extends BasicConfiguration {

	private SiteLoginPage loginPage;
	private RegisterPage registerPage;

	@Step("Verify that all elements are present")
	@Test(priority = 1, description = "Verify that Username,Password fields and Login Button are present")

	public void givenAllElementsOnPage_whenFieldsAreDisplayed_thenVerifyAllElementsArePresent() {
		loginPage = new SiteLoginPage(chromeDriver);
		softAssert.assertTrue(loginPage.usernameFieldIsDisplayed());
		softAssert.assertTrue(loginPage.PasswordFieldIsDisplayed());
		softAssert.assertTrue(loginPage.PasswordFieldIsDisplayed());
		softAssert.assertAll();
	}

	@Step("Testing with Username and Password")
	@Test(priority = 2, description = "no such user with given credentials")
	public void givenLogin_whenGetUsernameErrorData_thenCheckThatNoAccountExistsWithThisUsername() {
		loginPage = new SiteLoginPage(chromeDriver);
		registerPage = new RegisterPage();
		loginPage.writeInUsername();
		loginPage.writeInPassword();
		registerPage = loginPage.siteLogin();
		String expected = "No account found with that username.";
		String actual = loginPage.getUsernameErrorData();
		Assert.assertEquals(actual, expected);
	}

	@Step("Logging testing is unsuccessful cuz only Username is given")
	@Test(priority = 3, description = "testing of unsuccessful login,there is no password")
	public void givenLogin_whenGetPasswordErrorData_thenTestingOnlyUsername() {
		loginPage = new SiteLoginPage(chromeDriver);
		registerPage = new RegisterPage();
		loginPage.writeInUsername();
		registerPage = loginPage.siteLogin();
		String expected = "Please enter your password.";
		String actual = loginPage.getPasswordErrorData();
		Assert.assertEquals(actual, expected);
	}

	@Step("Loginging testing is unsuccessful cuz only Password is given")
	@Test(priority = 4, description = "testing of unsuccessful login, there is no username")
	public void givenLogin_whenGetUsernameErrorData_thenTestingOnlyPassword() {
		loginPage = new SiteLoginPage(chromeDriver);
		registerPage = new RegisterPage();
		loginPage.writeInPassword();
		registerPage = loginPage.siteLogin();
		String expected = "Please enter username.";
		String actual = loginPage.getUsernameErrorData();
		Assert.assertEquals(actual, expected);
	}

	@Step("Testing logging with no credentials given")
	@Description("Threre is no myuser and no mypass credentials")
	@Test(priority = 5, description = "no myuser, no mypass")
	public void givenLogin_whenGetUsernameErrorDataAndGetPasswordErrorData_thenTestThatNoCredentials() {
		loginPage = new SiteLoginPage(chromeDriver);
		registerPage = new RegisterPage();
		registerPage = loginPage.siteLogin();
		String expNameErrorMessage = "Please enter username.";
		String actNameErrorMessage = loginPage.getUsernameErrorData();
		softAssert.assertEquals(actNameErrorMessage, expNameErrorMessage);
		String expPasswordErrorMessage = "Please enter your password.";
		String actPasswordErrorMessage = loginPage.getPasswordErrorData();
		softAssert.assertEquals(actPasswordErrorMessage, expPasswordErrorMessage);

	}

	@Step("Test must fail, there should be  wrong results")
	@Test(priority = 6, description = "logging testing should be unsuccessful cuz there is no username")
	public void givenLogin_whenGetUsernameErrorData_thenTestLoggingInWithError() {
		loginPage = new SiteLoginPage(chromeDriver);
		registerPage = new RegisterPage();
		loginPage.writeInPassword();
		registerPage = loginPage.siteLogin();
		String expected = "Please enter stubpass.";
		String actual = loginPage.getUsernameErrorData();
		Assert.assertEquals(actual, expected);
	}
}
