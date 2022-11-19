package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import base.TestBase;

public class DataUtil  extends TestBase{


	@DataProvider
	public Object[][] getData(Method m) {
		//ExcelReader excel = new ExcelReader("./src/test/resources/excel/data.xlsx");

		String sheetName = m.getName();
		System.out.println("Loading sheetName: "+sheetName);

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		System.out.println("Total rows: " + rows + " columns: " + cols);

		System.out.println(excel.getCellData(sheetName, 0, 2));

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}

		}

		return data;
	}
}


