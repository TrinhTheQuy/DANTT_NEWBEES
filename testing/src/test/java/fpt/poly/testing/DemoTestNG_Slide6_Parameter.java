package fpt.poly.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class DemoTestNG_Slide6_Parameter {

	private WebDriver driver;

//	static String appURL = "https://www.google.com.vn/";

	String currentUsersDir = System.getProperty("user.dir");
	String pathLocalFirfox = currentUsersDir + "/browser/mac/geckodriver";
	String pathLocalChrome = currentUsersDir + "/browser/mac/chromedriver";

	@BeforeMethod
	@BeforeClass(alwaysRun = true)
	@Parameters({ "browser", "appURL" })
	public void setUp(String browser, String appURL) throws MalformedURLException {
		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", pathLocalChrome);

			ChromeOptions chromeOptions = new ChromeOptions();

			chromeOptions.setHeadless(false);// addArguments("--headless");

			driver = new ChromeDriver(chromeOptions);

		}

		else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", pathLocalFirfox);

			FirefoxOptions fireFoxOptions = new FirefoxOptions();
			fireFoxOptions.setHeadless(false);// addArguments("--headless");

			driver = new FirefoxDriver(fireFoxOptions);

		}

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(appURL);
	}

	@Test
	public void googleTitleTest() {
		// validate page title test
		Assert.assertTrue(driver.getTitle().contentEquals("Google"));

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
