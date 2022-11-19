package testcases;

import static io.restassured.RestAssured.given;

import  org.testng.annotations.Test;

import base.TestBase;
import io.restassured.response.Response;

public class RetrieveCustomer extends TestBase {
	
	@Test
	public void getCustomerTest() {
		
		Response response =given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "")
			.formParam("id", "cus_9BoKyB2Km2T7TE")
		.get("/customers");
	
		response.prettyPrint();
	
		
		
	}

}
