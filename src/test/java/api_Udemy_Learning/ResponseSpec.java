package api_Udemy_Learning;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

	RequestSpecification reqspecbuilder;
	ResponseSpecification responsespec;

	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder reqspecbuilder = new RequestSpecBuilder();
		reqspecbuilder.setBaseUri("https://api.postman.com/")
				.addHeader("x-api-key", "PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e")
				.log(LogDetail.ALL);
		RestAssured.requestSpecification = reqspecbuilder.build();

		responsespec = RestAssured.responseSpecification.statusCode(200).contentType(ContentType.JSON);
	}

	@Test
	public void test1() {
		given().spec(reqspecbuilder).
		 get("/workspaces")
				.then().spec(responsespec)
				.log().all();
	}

}
