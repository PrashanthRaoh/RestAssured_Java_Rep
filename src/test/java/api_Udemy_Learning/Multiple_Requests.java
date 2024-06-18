package api_Udemy_Learning;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Multiple_Requests {
	
	
	@Test
	public void get_Response() {
//		given()
//		.baseUri("https://api.postman.com/")
//		.header("x-api-key","PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e")
//		.when()
//		.get("/workspaces")
//		.then()
//		.log().all();
		
		
		RequestSpecification reqspec = given()
				.baseUri("https://api.postman.com/")
				.header("x-api-key","PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e");
		
		given().spec(reqspec).
		when()
		.get("/workspaces")
		.then()
		.log().all();
		
	}
	
	@Test
	public void get_Body() {
		
		RequestSpecification reqspec = given()
				.baseUri("https://api.postman.com/")
				.header("x-api-key","PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e");
		given().spec(reqspec)
		.get("/workspaces")
		.then()
		.assertThat()
		.body("workspaces[0].name", Matchers.equalTo("My Workspace"));
	}

}
