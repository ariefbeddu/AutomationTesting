package qaautomation.december2022;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import qaautomation.december2022.schemalist.SchemaDashboard;
import qaautomation.december2022.schemalist.SchemaNegative;
import qaautomation.december2022.utils.DataUtility;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class APITestAfterRefactor extends BaseAPITest{
	String token;

	
	@Test 
	public void userAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseUser = given().spec(loginJsonSpec).when().get("/user");
		assertEquals(responseUser.statusCode(), 200);
	}
	
	@Test 
	public void dashboardAPI() {
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseDashboard = given().spec(loginJsonSpec)
				.when().get(DataUtility.getDataFromExcel("path", "dashboard"));
		responseDashboard.then().assertThat().body(matchesJsonSchema(DataUtility.getDataFromExcel("schemas","dashboardschema")));
		assertEquals(responseDashboard.statusCode(), 200);
	}
	@Test 
	public void dashboardAPIUsingSchemaInCode() {
		SchemaDashboard schema = new SchemaDashboard();
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseDashboard = given().spec(loginJsonSpec)
				.when().get(DataUtility.getDataFromExcel("path", "dashboard"));
		responseDashboard.then().assertThat().body(matchesJsonSchema(schema.dashboardSchema()));
		assertEquals(responseDashboard.statusCode(), 200);
	}
	
	@Test 
	public void dashboardAPIWithoutToken() {
		SchemaNegative schema = new SchemaNegative();
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		Response responseDashboard = given().spec(commonJsonSpec)
				.when().get("/build_cards?status=completed");
		responseDashboard.then().assertThat().body(matchesJsonSchema(schema.schemaNegative()));

	}
	
}
