package fpt.poly.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;




public class DemoSeleniumRC {
		
	private static WebDriver driver;
	
	static String appURL = "https://www.google.com.vn/";
	static String currentUsersDir = System.getProperty("user.dir");
	static String path = currentUsersDir + "/browser/chromedriver";
	
	static WebDriverBackedSelenium selenium;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		
		selenium = new WebDriverBackedSelenium(driver, appURL);
		
	    selenium.open(appURL, "google");
	    
	    
		selenium.type("name=q", "fpt polytechnic");
		
		Thread.sleep(3000);
		
		selenium.close();
	}
	
	

}
