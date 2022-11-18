package testcases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateCustomerTest {

	@Test
	public void getCustomerAPIWithValidSecretKey() {
		
		RestAssured.baseURI="https://api.stripe.com";
		RestAssured.basePath="/v1";
		
		Response response=given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
		.get("/customers");

		response.prettyPrint();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
