package com.backbase.global;
import java.io.File;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import backbase.global.properties.GlobalProperties;


public class SetUpAndTearDown extends BackbaseGlobal {

	public SetUpAndTearDown() {
	};

	@BeforeClass
	public static void setUp() {

		browser = System.getProperty("browser").toLowerCase();
		autoitScriptsPath = new File("src/main/resources/autoit/executable");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			// TODO
			if (System.getProperty("os.arch").equals("x86")) {
				System.setProperty("webdriver.ie.driver", "src/main/resources/Drivers/IEDriverServer32.exe");
			} else {
				System.setProperty("webdriver.ie.driver", "src/main/resources/Drivers/IEDriverServer64.exe");
				
			}
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("opera")) {
			// TODO add location to the opera driver
			driver = new OperaDriver();
		} else if (browser.equalsIgnoreCase("phantomjs")) {
			// TODO find compatible PhantomJS version which will not make issues
			// with chrome driver
			System.setProperty("phantomjs.binary.path", "src/main/resources/Drivers/phantomjs.exe");
			DesiredCapabilities dCaps;
			dCaps = new DesiredCapabilities();
			dCaps.setJavascriptEnabled(true);
			dCaps.setCapability("takesScreenshot", false);
			// driver = new PhantomJSDriver(dCaps);
		} else {
			System.err.println("Specified browser is not supported!!!");
		}

		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 action = new Actions(driver);
		
		try {
			waitPage = new WebDriverWait(driver, GlobalProperties.PAGE_LOAD_TIMEOUT);
			waitElement = new WebDriverWait(driver, GlobalProperties.ELEMENT_LOAD_TIMEOUTS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@AfterClass
	public static void tearDown() {
		try {
			if(driver!=null) {
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
