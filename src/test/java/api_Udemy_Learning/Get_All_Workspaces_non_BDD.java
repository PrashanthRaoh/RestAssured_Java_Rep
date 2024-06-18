package api_Udemy_Learning;

import static io.restassured.RestAssured.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_All_Workspaces_non_BDD {
	RequestSpecification reqspec;

	@BeforeClass
	public void beforeCLass() {
		/*
		 * // // reqspec =
		 * given().baseUri("https://api.postman.com/").header("x-api-key", //
		 * "PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e"); //
		 */		
		
		RequestSpecBuilder reqspecbuilder = new RequestSpecBuilder();
		reqspecbuilder.setBaseUri("https://api.postman.com/")
		.addHeader("x-api-key","PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e")
		.log(LogDetail.HEADERS);
		reqspec = reqspecbuilder.build();
	}

	@Test
	public void Test1() {
		Response responseobject = given(reqspec).
				header("dummy","dummyheaderval").
				get("/workspaces").
				then()
				.log()
				.all()
				.extract().response();
		assertThat(responseobject.statusCode(), equalTo(200));

	}
//
//	@Test
//	public void Test2() {
//		Response responseobject = given(reqspec).get("/workspaces").then().log().all().extract().response();
//		assertThat(responseobject.statusCode(), equalTo(200));
//		assertThat(responseobject.path("workspaces[0].name").toString(), equalTo("My Workspace"));
//	}
}
