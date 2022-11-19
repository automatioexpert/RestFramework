package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import utilities.ExcelReader;

public class TestBase {

	public Properties config = new Properties();
	private FileInputStream fis = null;
	public static ExcelReader excel = new ExcelReader("./src/test/resources/excel/data.xlsx");
	

	@BeforeSuite
	public void setUp() {

		try {
			fis = new FileInputStream("src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			config.load(fis);
		} catch (IOException e) {

		}
		System.out.println(config.getProperty("baseURI"));
		RestAssured.baseURI = config.getProperty("baseURI");
		RestAssured.basePath = config.getProperty("basePath");

	}

	@AfterSuite
	public void tearDown() {

	}
}
