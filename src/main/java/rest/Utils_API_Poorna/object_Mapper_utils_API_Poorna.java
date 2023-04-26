package rest.Utils_API_Poorna;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import testData_Poorna.AddData_Payload_API_Poorna;
import testData_Poorna.GetData_Payload_API_Poorna;

public class object_Mapper_utils_API_Poorna {

	public String serializeObject(Object user) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		String jsonPayLoad = om.writeValueAsString(user);
		return jsonPayLoad;
	}

	public Object deserializeJSON(Response res) throws JsonMappingException, JsonProcessingException {
		String sFirstObj=JsonPath.read(res.getBody().asString(), "$.data[0]");
		ObjectMapper om = new ObjectMapper();

		GetData_Payload_API_Poorna user = om.readValue(sFirstObj, GetData_Payload_API_Poorna.class);
		return user;
	}
	

}
 