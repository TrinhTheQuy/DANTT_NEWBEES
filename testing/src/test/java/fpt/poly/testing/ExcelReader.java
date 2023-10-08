package fpt.poly.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public Workbook _workbook = null;
	public FileInputStream _inputStream = null;
	public File _file = null;
	public Sheet _sheet = null;
	public Row _row = null;
	public Cell _cell = null;

	public ExcelReader(String sheetName) throws IOException {

		_sheet = readExcel(System.getProperty("user.dir") + "//testCase", "TestCase.xlsx", sheetName);

	}

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

	public String getSheetName() {
		return _sheet.getSheetName().toString();
	}

	// find whether sheets exists
	public boolean isSheetExist() {

		int index = _workbook.getSheetIndex(getSheetName());
		if (index == -1) {
			index = _workbook.getSheetIndex(getSheetName().toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	// returns the row count in a sheet
	public int getRowCount() {
		int index = _workbook.getSheetIndex(getSheetName());
		if (index == -1)
			return 0;
		else {
			_sheet = _workbook.getSheetAt(index);
			int number = _sheet.getLastRowNum() + 1;
			return number;
		}

	}

	public int getRowNum() {
		int number = 0;
		for (int i = 1; i <= getRowCount(); i++) {

		}

		return number;

	}

	// returns number of columns in a sheet
	public int getColumnCount() {
		// check if sheet exists
		if (!isSheetExist())
			return -1;

		_sheet = _workbook.getSheet(getSheetName());

		_row = _sheet.getRow(0);

		if (_row == null)
			return -1;

		return _row.getLastCellNum();

	}

	// returns the data from a cell
	public String getCellData(String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "ROW NUM <= 0";

			int index = _workbook.getSheetIndex(getSheetName());

			int col_Num = -1;

			if (index == -1)
				return "INDEX = -1";

			_row = _sheet.getRow(0);

			for (int i = 0; i < _row.getLastCellNum(); i++) {
//                System.out.println(_row.getCell(i).getStringCellValue().trim());
				if (_row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "COLUM NUM = -1";

			_sheet = _workbook.getSheetAt(index);

			_row = _sheet.getRow(rowNum - 1);

			if (_row == null)
				return "ROW_NULL";
			_cell = _row.getCell(col_Num);

			if (_cell == null)
				return "CELL_NULL";
			// System.out.println(cell.getCellType());
			if (_cell.getCellType() == Cell.CELL_TYPE_STRING)
				return _cell.getStringCellValue();
			else if (_cell.getCellType() == Cell.CELL_TYPE_NUMERIC || _cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

				String cellText = String.valueOf(_cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(_cell)) {
					// format in form of M/D/YY
					double d = _cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

				}

				return cellText;
			} else if (_cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "CELL_TYPE_BLANK";
			else
				return String.valueOf(_cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();

			return "row " + rowNum + " or column " + colName + " does not exist in xls";
		}
	}
}
