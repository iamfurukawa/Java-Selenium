package com.automation.core;

import org.openqa.selenium.WebDriver;

public class BasePage {

	private WebDriver webDriver;

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(final WebDriver webDriver) {
		this.webDriver = webDriver;
	}
}
