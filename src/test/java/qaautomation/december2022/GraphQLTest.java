package qaautomation.december2022;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import qaautomation.december2022.utils.GraphQLRequestBuilder;
import static io.restassured.RestAssured.given;

public class GraphQLTest {
	
	@Test
	public void checkCEO() {
		GraphQLRequestBuilder gql = new GraphQLRequestBuilder();
		String query = "{company{ceo coo cto}}";
		gql.setQuery(query);
		String jsonStringQueryString = gql.getJSONString();
		
		Response responseCEOResponse = given().contentType(ContentType.JSON)
				.body(jsonStringQueryString)
				.when()
				.post("https://api.spacex.land/graphql");
		
		String expectedCEO = "Elon Musk";
		String ceoName = responseCEOResponse.jsonPath().get("data.company.ceo");
		System.out.println("ceoName"+ceoName);
		assertEquals(ceoName, expectedCEO);
	}
	
	@Test
	public void getLaunches() {
		GraphQLRequestBuilder gql = new GraphQLRequestBuilder();
		
		JSONObject variables = new JSONObject();
		variables.put("limit", 6);
		
		String query = "query getLaunches($limit:Int){launches(limit:$limit){mission_name}}";
		
		gql.setQuery(query);
		gql.setVariable(variables.toString());
		
		String jsonStringQueryString = gql.getJSONString(); 
		
		Response responseLaunches = given().contentType(ContentType.JSON)
				.body(jsonStringQueryString)
				.when()
				.post("https://api.spacex.land/graphql");
		String missionName = responseLaunches.jsonPath().get("data.launches[1].mission_name");
		assertEquals(missionName, "AsiaSat 6");
	}

}
