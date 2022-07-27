package com.ijmeet.util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ijmeet.keyword.UIKeyword;

public class WaitFor {
	private static final WebDriverWait wait;
	private static final String String = null;

	static {
		wait = new WebDriverWait(UIKeyword.getInstance().driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(500));
	}

	public static void elementToBeVisible(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void stalenessOf(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	public static void elementToBeClickable(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void elementToBeClickable(WebElement element) {
		wait.withTimeout(Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
