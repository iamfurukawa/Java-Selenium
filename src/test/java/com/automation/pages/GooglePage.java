package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.core.BasePage;
import com.automation.core.INavigate;

public class GooglePage extends BasePage implements INavigate {

	private static final String GOOGLE_URL = "https://www.google.com.br";

	@FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
	private WebElement inputSearch;

	@FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")
	private WebElement buttonSearch;
	
	public GooglePage(final WebDriver webDriver) {
		setWebDriver(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	@Override
	public void navigateTo() {
		getWebDriver().get(GOOGLE_URL);
	}

	public void setTextOnInputSearch(final String textToInput) {
		inputSearch.sendKeys(textToInput);
	}

	public GoogleResultsPage clickOnSearchButton() {
		buttonSearch.click();
		return new GoogleResultsPage(getWebDriver());
	}
}
