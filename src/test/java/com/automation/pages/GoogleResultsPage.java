package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.core.BasePage;

public class GoogleResultsPage extends BasePage {

	@FindBy(xpath = "//*[@href=\"https://github.com/iamfurukawa\"]")
	private WebElement resultSearch;

	public GoogleResultsPage(final WebDriver webDriver) {
		setWebDriver(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public GitHubPage clickOnResult() {
		resultSearch.click();
		return new GitHubPage(getWebDriver());
	}
}
