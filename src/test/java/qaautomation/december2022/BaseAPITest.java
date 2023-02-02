package qaautomation.december2022;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import qaautomation.december2022.utils.DataUtility;

import static io.restassured.RestAssured.given;

public class BaseAPITest {
	String token;
	
	RequestSpecification commonJsonSpec = new RequestSpecBuilder()
			.setBaseUri("https://api-staging-builder.engineer.ai")
			.setContentType(ContentType.JSON)
			.build().log().all();
			
	RequestSpecification loginJsonSpec;
	
	@BeforeMethod
	public void loginAPI() {		
		String payload = DataUtility.getDataFromExcel("requestbody", "signinBody");
		System.out.println("payload"+payload);
		
		Response responseLogin = given().spec(commonJsonSpec)
				.body(payload)
				.when().post("/users/sign_in");
		assertEquals(responseLogin.getStatusCode(), 200);
		token = responseLogin.jsonPath().get("user.authtoken");
		
		loginJsonSpec = new RequestSpecBuilder()
				.setBaseUri("https://api-staging-builder.engineer.ai")
				.setContentType(ContentType.JSON)
				.addHeader("authtoken", token)
				.build().log().all();
		
	}
}
