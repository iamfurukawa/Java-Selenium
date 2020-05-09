package com.automation.tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.automation.core.BaseTest;
import com.automation.pages.GitHubPage;
import com.automation.pages.GooglePage;
import com.automation.pages.GoogleResultsPage;

@SpringBootTest
public class GitHubSearchTest extends BaseTest {

	private static final String GIT_USER = "iamfurukawa · GitHub";
	private static final String SEARCH_TO_TEXT = "iamfurukawa GitHub";

	@Test
	public void searchGitHubByName() {
		GooglePage googlePage = new GooglePage(getWebDriver());
		
		googlePage.navigateTo();
		googlePage.setTextOnInputSearch(SEARCH_TO_TEXT);
		GoogleResultsPage googleResultsPage = googlePage.clickOnSearchButton();
		
		GitHubPage gitHubPage = googleResultsPage.clickOnResult();
		gitHubPage.checkTitleUser(GIT_USER);
	}
}