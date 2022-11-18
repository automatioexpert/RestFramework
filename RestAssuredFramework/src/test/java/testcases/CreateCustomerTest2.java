package testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.response.Response;

public class CreateCustomerTest2 extends TestBase{

	@Test(priority = 0)
	public void validateCreateCustomerAPIWithValidSecretKey() {

	//	RestAssured.baseURI = "https://api.stripe.com/";

		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
				.formParam("email", "user3473@gnai.com").formParam("description", "user is added").post(config.getProperty("customerAPIEndPoint"));

		response.prettyPrint();

		Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected.Hence Test Failed.");
		System.out.println("validateCreateCustomerAPIWithValidSecretKey Test Passed");

	}

	@Test(priority = 1)
	public void invalidateCreateCustomerAPIWithValidSecretKey() {

	//	RestAssured.baseURI = "https://api.stripe.com/";

		Response response = given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
				.formParam("email", "user3473@gnai.com").formParam("description", "user is added").post(config.getProperty("customerAPIEndPoint"));

		response.prettyPrint();

		Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected.Hence Test Failed.");
		System.out.println("validateCreateCustomerAPIWithValidSecretKey Test Passed");

	}
	
}
