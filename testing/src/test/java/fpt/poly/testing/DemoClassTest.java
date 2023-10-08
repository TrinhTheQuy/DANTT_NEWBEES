package fpt.poly.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class DemoClassTest {

	private DemoClass classUnderTest = new DemoClass();
	
	@Rule
	public TestName testName = new TestName();

	@Before
	public void setup() {
		classUnderTest = new DemoClass();
		System.out.println("Start " + testName.getMethodName());
	}

	@Test
	public void test_doubleANumber() {
		assertEquals(6, classUnderTest.doubleANumber(3));
	}

	@Ignore
	public void test_not_executed() {
		fail("It should not executed");
	}

	@Test
	public void test_returnBooleanFoo_false() {
		boolean shouldReturnFalse = classUnderTest.returnABoolean("NA");
		assertFalse(shouldReturnFalse);
	}

	@Test
	public void test_returnBooleanFoo_true() {
		boolean shouldReturnTrue = classUnderTest.returnABoolean("Save");
		assertTrue(shouldReturnTrue);
	}

	@Test
	public void test_voidFoo() throws IllegalAccessException {
		try {
			classUnderTest.voidFoo("OK");
		} catch (Exception e) {
			fail("Should not throw exception");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_voidFoo_exception() throws IllegalAccessException {
		classUnderTest.voidFoo("NA");
	}
	
	@Test(timeout = 1)
	public void test_timeout() {
		classUnderTest.doubleANumber(9999);
	}
}