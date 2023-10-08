package fpt.poly.testing;

public class DemoClass {
	
//	In this step, I will create SomeClass which has the following methods:
//	doubleANumber – return an integer number by multiplying two.
//	returnABoolean – return a boolean value based on the input string value.
//	voidFoo – does not return anything and throws an exception when receiving a bad argument.
	
	public int doubleANumber(int num) {
		return num * 2;
	}
	
	public boolean returnABoolean(String inputData) {
		if ("Save".equalsIgnoreCase(inputData)) {
			return true;
		} else {
			return false;
		}
	}

	public void voidFoo(String inputData) {
		if ("Ok".equalsIgnoreCase(inputData)) {
			System.out.println("doing something.");;
		} else {
			throw new IllegalArgumentException("Bad argument:" + inputData);
		}
	}

}
