package testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.response.Response;
import utilities.DataUtil;
import utilities.ExcelReader;

public class CreateCustomerTest2 extends TestBase {

	@Test(priority = 0,dataProvider = "getData",dataProviderClass = DataUtil.class)
	public void validateCreateCustomerAPI(Hashtable<String, String> table) {

		System.out.println("validateCreateCustomerAPI " + table.get("name") + " email: " + table.get("email") + " description: " + table.get("description"));
		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "").formParam("email", table.get("email"))
				.formParam("description", table.get("description")).post(config.getProperty("customerAPIEndPoint"));

		response.prettyPrint();

		Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected.Hence Test Failed.");
		System.out.println("validateCreateCustomerAPIWithValidSecretKey Test Passed");

	}

	//@Test(priority = 1,dataProvider = "getData",dataProviderClass = DataUtil.class)
	public void invalidCreateCustomerAPI(String name, String email, String description) { 
	{

		// RestAssured.baseURI = "https://api.stripe.com/";

		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc3834", "")
				.formParam("email", email).formParam("description", description)
				.post(config.getProperty("customerAPIEndPoint"));

		response.prettyPrint();

		Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected.Hence Test Failed.");
		System.out.println("validateCreateCustomerAPIWithValidSecretKey Test Passed");

	}
	
	/*

	@DataProvider
	public Object[][] getData() {
		ExcelReader excel = new ExcelReader("./src/test/resources/excel/data.xlsx");

		String sheetName = "validateCreateCustomerAPI";

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
	} */
}}
