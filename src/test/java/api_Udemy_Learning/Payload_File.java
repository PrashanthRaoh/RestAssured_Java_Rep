package api_Udemy_Learning;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
public class Payload_File {
	RequestSpecification reqspec;
	@BeforeClass
	public void beforeclass() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("https://api.getpostman.com").
		addHeader("x-api-key","PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e")
		.setContentType(ContentType.JSON).log(LogDetail.ALL);
		requestSpecification = builder.build();
		
	}
	
	@Test
	public void Jsonfile() {
		File file = new File("src/main/resources/Payload.json");
		given()
		.body(file)
		.when()
		.post("/workspaces")
		.then()
		.log()
		.all();
	}
}
