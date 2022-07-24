package com.selenium.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class PageTestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		Allure.getLifecycle().addAttachment("screenshot", "image/png", "png",
				((TakesScreenshot) BasicConfiguration.chromeDriver).getScreenshotAs(OutputType.BYTES));
		System.out.println("\nInformation\n-------\nis on the\n-------\nscreen");
		BasicConfiguration.chromeDriver.close();
		BasicConfiguration.chromeDriver.quit();

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		BasicConfiguration.chromeDriver.close();
		BasicConfiguration.chromeDriver.quit();
	}
}