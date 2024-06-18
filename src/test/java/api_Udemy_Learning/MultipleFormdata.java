package api_Udemy_Learning;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;

public class MultipleFormdata {
	@Test
	void formdata() {
		given()
		.baseUri("https://postman-echo.com/")
		.multiPart("abc","{'test1' : 11, 'test2' : 'tt'}","application/json")
		.multiPart("file" , new File("src/main/resources/Payload.json"))
		.queryParam("abc", "check")
		.log().all()
		.when()
		.post("/post")
		.then()
		.log().all();
		
		
	}
}
