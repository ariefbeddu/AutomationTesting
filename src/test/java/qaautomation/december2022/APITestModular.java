package qaautomation.december2022;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import qaautomation.traindec022.pages.api.LoginAPI;

public class APITestModular {
	String token;

	@Test (priority = 1)
	public void loginAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		
		LoginAPI loginAPI = new LoginAPI();
		
		String email="testlabs@gmail.com";
		String password="builder123";
		String payload = loginAPI.loginAPIpayload(email, password);
		String pathLogin = loginAPI.loginAPIpath();
		
		System.out.println(payload);
		Response responseLogin = RestAssured.given()
				.contentType("application/json")
				.body(payload).when().post(pathLogin);
		assertEquals(responseLogin.getStatusCode(), 200);
		token = responseLogin.jsonPath().get("user.authtoken");
	}
	public void loginAPIFalseEmail() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		
		LoginAPI loginAPI = new LoginAPI();
		
		String email="qwe@gmail.com";
		String password="builder123";
		String payload = loginAPI.loginAPIpayload(email, password);
		String pathLogin = loginAPI.loginAPIpath();
		
		System.out.println(payload);
		Response responseLogin = RestAssured.given()
				.contentType("application/json")
				.body(payload).when().post(pathLogin);
		assertEquals(responseLogin.getStatusCode(), 422);
		token = responseLogin.jsonPath().get("user.authtoken");
	}
}