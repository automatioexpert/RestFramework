package rough;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class TestExcel {

	@Test(dataProvider = "d1")
	public void test1(String s1, String s2, String s3) {
		
		System.out.println(s1+": "+s2+" : "+s3);

	}

	@DataProvider(name="d1")
	public Object[][] getData() {

		ExcelReader excel = new ExcelReader("./src/test/resources/excel/data.xlsx");

		String sheetName = "validateCreateCustomerAPI";

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		System.out.println("Total rows: " + rows + " columns: " + cols);
	
		System.out.println(excel.getCellData(sheetName, 0, 2));

		Object[][] data = new Object[rows][cols];

		for (int rowNum = 2; rowNum <= rows; rows++) {

			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

			}

		}

		return data;

	}

}
