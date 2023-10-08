package fpt.poly.testing;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import fpt.poly.operation.ReadObject;
import fpt.poly.operation.UIOperation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class DemoDataDrivenFrameworkinSelenium {

	WebDriver driver;
	String appURL = "https://www.google.com.vn/";
	String currentUsersDir = System.getProperty("user.dir");
	String path = currentUsersDir + "/browser/mac/chromedriver";	


	@BeforeTest
	public void beforeTest() {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", path);

		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.setHeadless(false);// addArguments("--headless");

		driver = new ChromeDriver(chromeOptions);
	}

	@AfterTest
	public void afterTest() {
		// close chrome
		driver.close();
	}

	@Test
	public void testSearch() throws Exception {
		ExcelReader excel = new ExcelReader("SearchGoogle");
		
		driver.navigate().to(appURL);

		Thread.sleep(60);

		driver.findElement(By.name("q")).sendKeys(excel.getCellData("Value", 2));

		Thread.sleep(3000);

		driver.findElement(By.name("btnK")).click();

		System.out.print("click");

		Thread.sleep(3000);

	}

}
