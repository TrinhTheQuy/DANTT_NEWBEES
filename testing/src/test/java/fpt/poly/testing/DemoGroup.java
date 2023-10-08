package fpt.poly.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DemoGroup {
  
  
  @Test(groups = "Regression")
  public void testMethodOne() {
	  System.out.print("testMethodOne\n");
  }
  
  @Test(groups = "Regression")
  public void testMethodTwo() {
	  System.out.print("testMethodTwo");
  }
  
  @Test(groups = "Smoke")
  public void testMethodSmoke() {
	  System.out.print("testMethodSmoke");
  }

}
