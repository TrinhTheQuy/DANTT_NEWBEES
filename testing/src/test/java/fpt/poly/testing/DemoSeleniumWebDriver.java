package fpt.poly.testing;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DemoSeleniumWebDriver {

	private static WebDriver driver;
	static String appURL = "https://www.google.com.vn/";
	static String currentUsersDir = System.getProperty("user.dir");
	static String path = currentUsersDir + "/browser/mac/chromedriver";

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", path);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		chromeOptions.setHeadless(false);//addArguments("--headless");
		
		driver = new ChromeDriver(chromeOptions);
		
//		System.setProperty("webdriver.gecko.driver", path);
//		
//		FirefoxOptions fireFoxOptions = new FirefoxOptions();
//		fireFoxOptions.setHeadless(false);// addArguments("--headless");
//
//		driver = new FirefoxDriver(fireFoxOptions)	;	
//		
		driver.navigate().to(appURL);
		
		Thread.sleep(60);
		
		driver.findElement(By.name("q")).sendKeys("fpt polytechnic");
		
//		System.out.print("sendKeys\n");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("btnK")).click();
		
		System.out.print("click");

		Thread.sleep(3000);
		// close chrome
		driver.close();
	}

}