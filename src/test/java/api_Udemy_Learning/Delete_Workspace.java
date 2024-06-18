package api_Udemy_Learning;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Delete_Workspace {
	
	RequestSpecification reqspec;
	@BeforeClass
	public void beforeclass() {
		
	RequestSpecBuilder respecbuilder = new RequestSpecBuilder();
	respecbuilder.setBaseUri("https://api.postman.com/")
	.addHeader("x-api-key","PMAK-6655f18d4584120001fb1ed2-3a49be12d5ca472a6480dadf7d8ec9572e")
	.log(LogDetail.ALL);
	
	requestSpecification  = respecbuilder.build();
	
	}
	
	@Test
	public void DeleteWS() {
		String wsid = "9ead4f6d-c541-4f73-816b-4a4522ef1db0";
		given().
		pathParam("wsid", wsid)
		.when()
		.delete("workspaces/{wsid}")
		.then()
//		.body("workspace.id", Matchers.matchesPattern("^[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}$"))
		.log()
		.all();
		
	}

}
