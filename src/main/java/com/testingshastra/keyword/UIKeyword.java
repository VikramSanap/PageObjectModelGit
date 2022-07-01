package com.testingshastra.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testingshastra.config.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIKeyword {
	public RemoteWebDriver driver = null;
	private static UIKeyword uikeywords;
	static {
		uikeywords = new UIKeyword();
	}

	public static UIKeyword getInstance() {
		return uikeywords;
	}

	private UIKeyword() {
	}

	/**
	 * This keyword is used to launch a specified browser
	 * 
	 * @author VikramSanap
	 * @Guide webDriver name must be one of the following:
	 *        <ul>
	 *        <li>Chrome</li>
	 *        <li>Internet Explorer</li>
	 *        <li>Firefox</li>
	 *        </ul>
	 * @param
	 */

	public void openBrowser(String webDriver) {
		if (webDriver.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (webDriver.equalsIgnoreCase("internet Explorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (webDriver.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.err.println("Invalid Browser Name" + webDriver);
		}

	}

	/**
	 * this keyword is used to launch an Url of a website
	 * @author VikramSanap 
	 * @param url
	 */
	public void launchUrl(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		String s = driver.getCurrentUrl();
		return s;
	}

	public void enterText(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);
	}

	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void clickOnElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}

	/**
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath"))
			element = driver.findElement(By.xpath(locatorValue));
		if (locatorType.equalsIgnoreCase("css"))
			element = driver.findElement(By.cssSelector(locatorValue));
		if (locatorType.equalsIgnoreCase("id"))
			element = driver.findElement(By.id(locatorValue));
		if (locatorType.equalsIgnoreCase("name"))
			element = driver.findElement(By.name(locatorValue));
		if (locatorType.equalsIgnoreCase("class"))
			element = driver.findElement(By.className(locatorValue));
		if (locatorType.equalsIgnoreCase("tag"))
			element = driver.findElement(By.tagName(locatorValue));

		return element;
	}

	public void click(WebElement element) {
		element.click();
	}

	public void click(String Object) {
		String[] parts = Object.split("##");
		getWebElement(parts[0], parts[1]).click();
	}

	/**
	 * @deprecated this method is depricated and will be deleted in the next version
	 *             of the framework
	 * @param locatorType
	 * @param locatorValue
	 * @param textToenter
	 */
	public void enterText(String locatorType, String locatorValue, String textToenter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToenter);
	}

	public void enterText(String Object, String textToEnter) {
		String[] parts = Object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);

	}

	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
}
