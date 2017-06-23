package com.backbase.global;


import java.io.File;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackbaseGlobal {
	
	
	public static WebDriver driver = null;
	public static String browser = null;
	public static WebDriverWait waitElement = null;
	public static WebDriverWait waitPage = null;
	public static Actions action = null;
	public static File autoitScriptsPath = null;

	public BackbaseGlobal() {
		// TODO Auto-generated constructor stub
	}

	// Navigations
	public void navigateTo(String url) {
		try {
			driver.get(url);
		} catch (SessionNotCreatedException e) {
			e.printStackTrace();
		}
	}

	// Element Operations
	public void inputField(By by, String value) {
		try {
			waitElement.until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
			waitElement.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void click(By by) {
		try {
			waitElement.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	public void doubleClick(By by) {
		WebElement element;
		try {
			element = waitElement.until(ExpectedConditions.visibilityOfElementLocated(by));
			action.doubleClick(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Assertions
	public boolean isElementPresent(By by) {
		try {
			waitElement.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void assertText(By by, String expectedValue) {
		isElementPresent(by);
		String actualValue;

		try {
			actualValue = waitElement.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();

			Assert.assertEquals(expectedValue, actualValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void isChecked(By by) {
		try {
			boolean checked = waitElement.until(ExpectedConditions.visibilityOfElementLocated(by)).isSelected();
			Assert.assertTrue(checked == true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void notChecked(By by) {
		try {
			boolean checked = waitElement.until(ExpectedConditions.visibilityOfElementLocated(by)).isSelected();
			Assert.assertTrue(checked == false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void assertValue(By by, String expectedText){
		String actualValue = null;
		try {
			actualValue = waitElement.until(ExpectedConditions.visibilityOfElementLocated(by)).getAttribute("value");
			Assert.assertEquals(actualValue, expectedText);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	

	// Sleep
	public void sleep(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
