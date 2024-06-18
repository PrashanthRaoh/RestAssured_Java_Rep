package api_Udemy_Learning;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.io.OutputDecorator;

import static io.restassured.RestAssured.*;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class DownloadFIle {

	
	@Test
	void downloadfile() {
		byte[] ba = given()
		.baseUri("https://raw.githubusercontent.com")
		.when()
		.get("/appium/appium/master/packages/appium/sample-code/apps/ApiDemos-debug.apk")
		.then()
		.log().all()
		.extract().response().asByteArray();
		
	}
}
