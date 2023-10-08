package fpt.poly.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	Workbook _workbook = null;
	FileInputStream _inputStream = null;
    File _file = null;
	Sheet _sheet = null;
	Row _row = null;
	

	public Sheet readExcel(String filePath, String fileName, String sheetName) throws IOException {

		// Create a object of File class to open xlsx file
		_file = new File(filePath + "//" + fileName);

		// Create an object of FileInputStream class to read excel file
		_inputStream = new FileInputStream(_file);

		// Find the file extension by spliting file name in substing and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {

			// If it is xlsx file then create object of XSSFWorkbook class
			_workbook = new XSSFWorkbook(_inputStream);
		}

		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of XSSFWorkbook class
			_workbook = new HSSFWorkbook(_inputStream);
		}
		// Read sheet inside the workbook by its name
		_sheet = _workbook.getSheet(sheetName);
		
		return _sheet;
	}
	
	public void getDataInExcel() throws IOException {
		
		 
		}
	

}
