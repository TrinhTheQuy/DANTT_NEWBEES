package fpt.poly.testing;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StepRunAnnotations {
	@Test()
	public void testTwoMethod() {
		System.out.println("Test method Two");
	}
	
	@Test()
	public void testOneMethod() {
		System.out.println("Test method One");
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
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
 
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
 
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
 
	 
//	@Test(groups = { "testOne" })
//	public void testOneMethod1() {
//		System.out.println("Test method One groups");
//	}
// 
//	@Test(groups = { "testTwo" })
//	public void testTwoMethod1() {
//		System.out.println("Test method Two groups");
//	}
//
// 
 
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
 
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
 
//	@BeforeGroups(groups = { "testOne" })
//	public void beforeGroupOne() {
//		System.out.println("Before Group testOne");
//	}
// 
//	@AfterGroups(groups = { "testOne" })
//	public void afterGroupOne() {
//		System.out.println("After Group testOne");
//	} 
//	@BeforeGroups(groups = { "testTwo" })
//	public void beforeGroupTwo() {
//		System.out.println("Before Group testTwo");
//	}
// 
//	@AfterGroups(groups = { "testTwo" })
//	public void afterGroupTwo() {
//		System.out.println("After Group testTwo");
//	}
// 


 
}
