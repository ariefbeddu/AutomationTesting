package qaautomation.december2022.schemalist;

public class SchemaDashboard {
	public String dashboardSchema() {
		String s = "{\r\n" + 
				"  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\r\n" + 
				"  \"type\": \"object\",\r\n" + 
				"  \"properties\": {\r\n" + 
				"    \"completed_build_card\": {\r\n" + 
				"      \"type\": \"array\",\r\n" + 
				"      \"items\": {}\r\n" + 
				"    },\r\n" + 
				"    \"build_card_count\": {\r\n" + 
				"      \"type\": \"object\",\r\n" + 
				"      \"properties\": {\r\n" + 
				"        \"project_completed\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"completed\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"incomplete\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"running\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"invited\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"archived\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"prototype\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"custom_prototype\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"tailor_made_prototype\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"freemium\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        }\r\n" + 
				"      },\r\n" + 
				"      \"required\": [\r\n" + 
				"        \"project_completed\",\r\n" + 
				"        \"completed\",\r\n" + 
				"        \"incomplete\",\r\n" + 
				"        \"running\",\r\n" + 
				"        \"invited\",\r\n" + 
				"        \"archived\",\r\n" + 
				"        \"prototype\",\r\n" + 
				"        \"custom_prototype\",\r\n" + 
				"        \"tailor_made_prototype\",\r\n" + 
				"        \"freemium\"\r\n" + 
				"      ]\r\n" + 
				"    }\r\n" + 
				"  },\r\n" + 
				"  \"required\": [\r\n" + 
				"    \"completed_build_card\",\r\n" + 
				"    \"build_card_count\"\r\n" + 
				"  ]\r\n" + 
				"}";

		return s;
	}
}