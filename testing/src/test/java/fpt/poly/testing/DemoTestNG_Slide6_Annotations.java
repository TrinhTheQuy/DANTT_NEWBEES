package fpt.poly.testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class DemoTestNG_Slide6_Annotations {
	
	private static WebDriver driverChrome;
	private static WebDriver driverFireFox;
	static String appURL = "https://www.google.com.vn/";
	static String currentUsersDir = System.getProperty("user.dir");
	static String pathChrome = currentUsersDir + "/browser/mac/chromedriver";
	static String pathFireFox = currentUsersDir + "/browser/mac/geckodriver";
	
	
	@Test()
	public void test01Chrome() throws InterruptedException {
		System.out.println("Test Chrome");
		
		driverChrome.navigate().to(appURL);
		
		Thread.sleep(60);
		
		driverChrome.findElement(By.name("q")).sendKeys("fpt polytechnic");
				
		Thread.sleep(3000);
		
		driverChrome.findElement(By.name("btnK")).click();
		


		
	}
	
	@Test()
	public void test02FireFox() throws InterruptedException {
		System.out.println("Test FireFox");
		
		driverFireFox.navigate().to(appURL);
		
		Thread.sleep(60);
		
		driverFireFox.findElement(By.name("q")).sendKeys("fpt polytechnic");
		
		
		Thread.sleep(3000);
		
		driverFireFox.findElement(By.name("btnK")).click();
		

	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
 
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
		
        System.setProperty("webdriver.chrome.driver", pathChrome);
		System.setProperty("webdriver.gecko.driver", pathFireFox);
		
		ChromeOptions chromeOptions = new ChromeOptions();
		
		chromeOptions.setHeadless(false);//addArguments("--headless");
		
		driverChrome = new ChromeDriver(chromeOptions);
		
		
		FirefoxOptions fireFoxOptions = new FirefoxOptions();
		fireFoxOptions.setHeadless(false);// addArguments("--headless");

		driverFireFox = new FirefoxDriver(fireFoxOptions)	;
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
		driverChrome.close();
		driverFireFox.close();
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
 
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
 
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
}
