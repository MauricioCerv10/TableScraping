package com.kmmx.seleniumjavaejemplo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {
	private WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/googledriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
	}
	@Test
	public void navigation() {
		driver.findElement(By.linkText("This is a link")).click();
		//Go back to homepage
		driver.navigate().back();
		//Go forwrd to Registration page
		driver.navigate().forward();
		//Go back to homepage
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
		//refresh browser
		driver.navigate().refresh();
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
