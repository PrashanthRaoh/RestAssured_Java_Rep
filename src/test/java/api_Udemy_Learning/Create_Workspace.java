package api_Udemy_Learning;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Create_Workspace {

	RequestSpecification reqspec;
	ResponseSpecification responseSpecification ;
	
	
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("https://api.getpostman.com").
		addHeader("x-api-key","PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e")
		.setContentType(ContentType.JSON).log(LogDetail.ALL);
		requestSpecification = builder.build();
		
		ResponseSpecBuilder responsespecbuilder = new ResponseSpecBuilder();
		responsespecbuilder
		.expectStatusCode(200)
		.expectContentType(ContentType.JSON)
		.log(LogDetail.ALL);
		
		responseSpecification = responsespecbuilder.build();
		
	}
		@Test
		void validateResponse() {
			
			String payload = "{\r\n"
					+ "    \"workspace\": {\r\n"
					+ "        \"name\": \"FromRest\",\r\n"
					+ "        \"type\": \"personal\",\r\n"
					+ "        \"description\": \"RA created this\"\r\n"
					+ "    }\r\n"
					+ "}";
			
		
			 given()
	            .body(payload)
	            .when()
	            .post("/workspaces")
	            .then()
	            .log().all()
	            .assertThat()
	            .body("workspace.name", Matchers.equalTo("FromRest"),
	            		"workspace.id", Matchers.matchesPattern("^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}$"));
				
		}
}
