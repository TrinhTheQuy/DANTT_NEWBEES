package fpt.poly.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MainTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		ExcelReader excel = new ExcelReader("SearchGoogleKeywordFramwork");
		
		
		
		System.out.print(excel.getCellData("Value", 2));
		
	
	
		
	}

}
