package fpt.poly.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient.Version;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoSeleniumGrid {

	private WebDriver driver;

	static String appURL = "https://www.google.com.vn/";

	static String ipAddress = "10.16.23.187";//103.56.158.97

	private DesiredCapabilities capability;

	String currentUsersDir = System.getProperty("user.dir");
//	String pathLocalFirfox = currentUsersDir + "/browser/mac/geckodriver";
//	String pathLocalChrome = currentUsersDir + "/browser/mac/chromedriver";
	
	String pathLocalFirfox = "/Users/tranhau/Desktop/SeleniumGrid/browser/mac/geckodriver";
	String pathLocalChrome = "/Users/tranhau/Desktop/SeleniumGrid/browser/mac/chromedriver";


	@BeforeMethod
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser" })
	public void setUp(String browser) throws MalformedURLException {
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", pathLocalChrome);


			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setHeadless(false);// addArguments("--headless");
			chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model

			capability = DesiredCapabilities.chrome();
			capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

			driver = new RemoteWebDriver(new URL("http://" + ipAddress + ":4444/wd/hub"), capability);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}

		else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", pathLocalFirfox);

			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			fireFoxOptions.setHeadless(false);// addArguments("--headless");
			fireFoxOptions.addArguments("--no-sandbox"); // Bypass OS security model

			capability = DesiredCapabilities.firefox();
			
			capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, fireFoxOptions);


			driver = new RemoteWebDriver(new URL("http://" + ipAddress + ":4444/wd/hub"), capability);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		driver.get(appURL);
	}

	@Test
	public void googleTitleTest() {
		// validate page title test
		AssertJUnit.assertTrue(driver.getTitle().contentEquals("Google"));

		driver.findElement(By.name("q")).sendKeys("fpt polytechnic");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("btnK")).click();
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

}

//java -jar selenium-server-standalone-3.141.59.jar -port 5557 -role node -hub http://192.168.1.7:4444/grid/register -browser "browserName=chrome, maxInstances=10, platform=ANY, seleniumProtocol=WebDriver"
