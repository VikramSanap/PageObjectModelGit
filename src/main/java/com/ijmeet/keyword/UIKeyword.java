package com.ijmeet.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ijmeet.config.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class includes the generic keywords which will be used to perform
 * various actions on WebElements
 * 
 * @author Vikram Ashok Sanap
 *
 */
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
	 * 
	 * @author VikramSanap
	 * @param url
	 */
	public void launchUrl(String url) {
		driver.get(url);
	}

	/**
	 * This keyword is used to get an url of a present web page
	 * 
	 * @return URL as a {@code String}.
	 */
	public String getCurrentUrl() {
		String s = driver.getCurrentUrl();
		return s;
	}

	/**
	 * This keyword is used to enter the text to a web element by providing web
	 * element and the text to enter
	 * 
	 * @param element
	 * @param textToEnter
	 */
	public void enterText(WebElement element, String textToEnter) {
		element.sendKeys(textToEnter);
	}

	/**
	 * This keyword is used to get the title of a present web page
	 * 
	 * @return title of the web page as String
	 */
	public String getTitleOfThePage() {
		return driver.getTitle();
	}

	/**
	 * this keyword is used to get the driver instance
	 * 
	 * @return RemoteWebDriver
	 */
	public RemoteWebDriver getDriver() {
		return driver;
	}

	/**
	 * This keyword is used to quit the browser window/tab
	 * 
	 * @author Vikram Ashok Sanap
	 */
	public void quitBrowser() {
		driver.quit();
	}

	/**
	 * This keyword is used to click on a web element whose xpath is available and
	 * provided as an arguement
	 * 
	 * @param xpath
	 * @author Vikram Ashok Sanap
	 */
	public void clickOnElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();

	}

	/**
	 * This keyword is used to find a web elemwnt with the help of various locator
	 * strategies by providing locator type and locator value as an argurments
	 * 
	 * @author Vikram Ashok Sanap
	 * @param locatorType
	 * @param locatorValue
	 * @return WebElemwnt
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

	/**
	 * This keyword is created to click on any WebElement.pass the webelement as an
	 * arguement to this method and the particular web elementwill be clicked
	 * 
	 * @param element
	 * @author Vikram Ashok Sanap
	 */
	public void click(WebElement element) {
		element.click();
	}

	/**
	 * This keyword is created click on any WebElement whose locator strategy and
	 * loctor value is stored in an Object Repository. it takes string arguement
	 * which contains locator strategy and locator value which will inturn be passed
	 * as an arguement to the {@code getWebElement} method which will get a
	 * particular element and will be clicked
	 * 
	 * @param Object
	 * 
	 * @author Vikram Ashok Sanap
	 */
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
	 * @author Vikram Ashok Sanap
	 */
	public void enterText(String locatorType, String locatorValue, String textToenter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToenter);
	}

	/**
	 * This keyword is used to enter a text in text box {@code WebElement}. it takes
	 * two {@code String} arguements first string arguement which contains locator
	 * strategy and locator value which will inturn be passed as an arguement to the
	 * {@code getWebElement} method which returs an {@code WebElement} and second
	 * {@code String} arguement which is the text to be entered particular element
	 * and
	 * 
	 * @param Object
	 * @param textToEnter
	 */
	public void enterText(String Object, String textToEnter) {
		String[] parts = Object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);

	}
/**
 * This keyword is used to switch from one frame to another when frame Id or Name
 * is available 
 * @param idOrName
 * @author Vikrama Ashok Sanap
 */
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
/**
 * This keyword is used to switch from one frame to another when frame {@code Index}
 * is available 
 * @param index
 * @author Vikrama Ashok Sanap
 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
/**
 * This keyword is used to switch from one frame to another when a particular unique
 * {@code WebElement} of destination frame is available 
 * @param element
 * @author Vikrama Ashok Sanap
 */
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
/**
 *This keyword is used to switch to a parent frame from switched frame
 * @author Vikrama Ashok Sanap
 */
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
}
