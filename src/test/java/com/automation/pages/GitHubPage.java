package com.automation.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.core.BasePage;

public class GitHubPage extends BasePage {

	public GitHubPage(final WebDriver webDriver) {
		setWebDriver(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public void checkTitleUser(final String user) {
		assertEquals(user, getWebDriver().getTitle());
	}
}
