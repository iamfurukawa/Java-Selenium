package com.automation.core;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {
	private static final String CHROMEDRIVER_EXE = "chromedriver.exe";
	private WebDriver driver = null;

	@BeforeAll
	public void setUp() {		
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(findFile()))
				.build();
		
		ChromeOptions options = new ChromeOptions()
			   	.setExperimentalOption("useAutomationExtension", false)
				.addArguments("--no-sandbox", "start-maximized", "disable-infobars", "--disable-extensions", "--disable-gpu", "--disable-dev-shm-usage")
				.merge(DesiredCapabilities.chrome());
		
		this.driver = new ChromeDriver(service, options);
	}

	@AfterAll
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	private String findFile() {
		return getClass().getClassLoader().getResource(CHROMEDRIVER_EXE).getFile();
	}

	public WebDriver getWebDriver() {
		return this.driver;
	}
}
