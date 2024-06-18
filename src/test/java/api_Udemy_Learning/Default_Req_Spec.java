package api_Udemy_Learning;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Default_Req_Spec {
	
	
	@BeforeClass
	public void beforeClass() {
		RequestSpecBuilder reqspecbuilder = new RequestSpecBuilder();
		reqspecbuilder.setBaseUri("https://api.postman.com/").
		addHeader("x-api-key","PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e");
		RestAssured.requestSpecification = reqspecbuilder.build();
		
	}
	
	@Test
	public void Test1() {
		 Response response = get("/workspaces").then()
				.log().all().extract().response();
		 
		 assertThat(response.statusCode(), equalTo(200));
				
	}

}
