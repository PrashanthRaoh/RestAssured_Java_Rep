package api_Udemy_Learning;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Payload_Json_Object {

	@BeforeClass
	public void beforeclass() {

		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("https://api.getpostman.com")
				.addHeader("x-api-key", "PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e")
				.setContentType(ContentType.JSON).log(LogDetail.ALL);

		requestSpecification = builder.build();
	}

	@Test
	public void Createws_from_Jsonobject() {
		String wsname = "FromEclipse";
		HashMap<String, Object> mainObject = new HashMap<String, Object>();
		HashMap<String, String> innerObject = new HashMap<String, String>();

		innerObject.put("name", "FromEclipse");
		innerObject.put("type", "personal");
		innerObject.put("description", "Pri WS");

		mainObject.put("workspace", innerObject);

		given().body(mainObject).when().post("/workspaces").then().log().all()
		.assertThat()
		.body("workspace.name", Matchers.equalTo(wsname));
		
		
	}

}
