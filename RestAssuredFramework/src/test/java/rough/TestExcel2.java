package rough;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class TestExcel2 {

	@Test(dataProvider = "getData")
	public void test1(String name,String email,String description) {
		System.out.println(name);
	}
	
	@DataProvider
	public Object[][] getData() {
		ExcelReader excel = new ExcelReader("./src/test/resources/excel/data.xlsx");

		String sheetName = "validateCreateCustomerAPI";

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		System.out.println("Total rows: " + rows + " columns: " + cols);

		System.out.println(excel.getCellData(sheetName, 0, 2));

		Object[][] data = new Object[rows-1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {

			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);

			}

		}

		return data;
	}
}
