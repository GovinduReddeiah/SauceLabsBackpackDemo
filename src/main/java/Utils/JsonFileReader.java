package Utils;

import java.io.File;
import java.io.IOException;

import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.messages.ndjson.internal.com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileReader {
	private static JsonNode rootNode;

	static {
		try {
			ObjectMapper mapper = new ObjectMapper();
			rootNode = mapper.readTree(new File("./src/main/java/testData/testData.json"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JsonNode getUsers() {
		return rootNode.get("UserData");
	}

	public static JsonNode getCheckoutData() {
		return rootNode.get("CheckOutData");
	}

}
