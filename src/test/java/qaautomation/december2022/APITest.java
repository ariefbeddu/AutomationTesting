package qaautomation.december2022;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APITest {
	
	String token;
	Faker faker = new Faker();
	String first_name =  faker.name().firstName();
	String last_name =  faker.name().lastName();
	String email = faker.internet().emailAddress();
	String password = faker.internet().password();
	String handphone = "+62-88888888888";
	
	
	@Test
	public void signupAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		String payload = "{\"user\":{\"first_name\":\""+first_name+"\","
				+ "\"last_name\":\""+last_name+"\","
				+ "\"email\":\""+email+"\","
				+ "\"password\":\""+password+"\","
				+ "\"phone_number\":\""+handphone+"\","	
				+ "\"user_type\":\"User\",\"currency_id\":2}}";
		System.out.println(payload);

		Response responseSignUp = RestAssured.given()
				.contentType("application/json")
				.body(payload).when().post("/users");
		assertEquals(responseSignUp.statusCode(),200);
		token = responseSignUp.jsonPath().get("user.authtoken");
	}
	

		@Test(priority=1)
		public void loginAPI() {
			RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
			String payload = "{\"email\":\"testlabs@gmail.com\",\"password\":\"builder123\"}";
			
			Response responseLogin = RestAssured.given()
					.contentType("application/json")
					.body(payload).when().post("/users/sign_in");
			assertEquals(responseLogin.statusCode(),200);
			token = responseLogin.jsonPath().get("user.authtoken");
		}

		@Test(priority=2)
		public void userAPI() {
			RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
			Response responseUser = RestAssured.given()
					.contentType("application/json")
					.header("authtoken", token)
					.when().get("/user");
			assertEquals(responseUser.statusCode(),200);
		}
		
		@Test(priority=3)
		public void dashboardAPI() {
			RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
			Response responseDashboard = RestAssured.given()
					.contentType("application/json")
					.header("authtoken", token)
					.when().get("/build_cards?status=completed");
			assertEquals(responseDashboard.statusCode(),200);
		}
	}