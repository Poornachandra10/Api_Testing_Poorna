package tests_API_Poorna;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.jayway.jsonpath.JsonPath;

import constants_API_Poorna.FileConstants_API_Poorna;
import io.restassured.response.Response;
import rest.Utils_API_Poorna.DataUtils_API_Poorna;
import testData_Poorna.AddData_Payload_API_Poorna;

public class LoginTest_API_Poorna extends BaseTest_API_POORNA {
	protected static Logger logger = LogManager.getLogger("");
	static String token = "";

	@Test

	public void login_Tc_01() throws IOException {

		String sEnv = DataUtils_API_Poorna.readJsonFiletoString(FileConstants_API_Poorna.ENV_URI_API_POORNA_FILE_PATH);

		System.out.println("sEnv" + sEnv);
		// String
		// sUri=JsonPath.read(FileConstants_API_Poorna.ENV_URI_API_POORNA_FILE_PATH,"$.prod.URL");

		String sUri = JsonPath.read(sEnv, "$.prod.URL");

		System.out.println(sUri);
		sUri = sUri + JsonPath.read(sEnv, "$.prod.endpoint.login");
		logger.debug("entered login url and end point");
		System.out.println(sUri);
		// declaring the headers
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		logger.debug("entered headers");
		// decalring the payload
		HashMap<String, String> sPayLoad = new HashMap<String, String>();
		String creds = DataUtils_API_Poorna
				.readJsonFiletoString(FileConstants_API_Poorna.USER_ACC_API_POORNA_FILE_PATH);
		sPayLoad.put("username", JsonPath.read(creds, "$.prod.valid.username"));
		sPayLoad.put("password", JsonPath.read(creds, "$.prod.valid.password"));
		// 1.here we need to call the method to give input to run ta post
		// Response res=oRestUtil.taPost(sUri, headers, sPayLoad);

		// here we are giving schema validation and together giving input to run post
		Response res = oRestUtil.taPostSchemaValidation(sUri, headers, sPayLoad);
		// System.out.println(res);
		token = res.jsonPath().getString("token").replaceAll("\\[", "").replaceAll("]", "");

		// All asserts are woring fine:for me
		// assertThat(String.valueOf(res.getStatusCode()).toString(),
		// equalToIgnoringCase("201"));

		// String
		// expectedStatusCodes=DataUtils_API_Poorna.readJsonFiletoString(FileConstants_API_Poorna.LOGIN_VALIDATION_POORNA_FILE_PATH);
		// System.out.println(expectedStatusCodes);
		// assertThat("matched",equalToIgnoringCase(String.valueOf(res.getStatusCode()),
		// JsonPath.read(expectedStatusCodes,"$.login_TC01[0]").toString()));
		assertThat("status code should match", res.getStatusCode() == 201);
//assertThat(String.valueOf(res.getStaode(tusC)),equalToIgnoringCase("201"));
//assertThat("Status code should match", res.getStatusCode()==JsonPath.reas(expectedStatusCode,"$.login_TC01[0]"));
//equalToIgnoringCase("201")
//equalTo("201") both should work;
	}

	@Test(dependsOnMethods = "login_Tc_01")
	public void AddDataTC_02() throws IOException {
		String sEnv = DataUtils_API_Poorna.readJsonFiletoString(FileConstants_API_Poorna.ENV_URI_API_POORNA_FILE_PATH);
		String sUri = JsonPath.read(sEnv, "$.prod.URL");
		sUri = sUri + JsonPath.read(sEnv, "$.prod.endpoint.adddata");
		logger.debug("entered login url and end point");
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		logger.debug("entered headers");
		AddData_Payload_API_Poorna user1 = new AddData_Payload_API_Poorna("19009913", "3", "1234532", "641046");

		Response res = oRestUtil.taPost(sUri, headers, oRestUtil_1.serializeObject(user1));
		System.out.println(res.asPrettyString());
	}

	@Test(dependsOnMethods = "AddDataTC_02")
	public void update_Data_TC03() throws IOException {
		String sEnv = DataUtils_API_Poorna.readJsonFiletoString(FileConstants_API_Poorna.ENV_URI_API_POORNA_FILE_PATH);
		String sUri = JsonPath.read(sEnv, "$.prod.URL");
		sUri = sUri + JsonPath.read(sEnv, "$.prod.endpoint.updatedata");
		logger.debug("entered login url and end point");
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		logger.debug("entered headers");
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("accountno", "19009913");
		payload.put("departmentno", "4");
		payload.put("salary", "123432");
		payload.put("pincode", "641046");
		Response res = oRestUtil.taPut(sUri, headers, payload);
		System.out.println(res.asPrettyString());

	}
	
	@Test (dependsOnMethods="AddDataTC_02")
	public void getDataTC04() throws IOException {
		String sEnv=DataUtils_API_Poorna.readJsonFiletoString(FileConstants_API_Poorna.ENV_URI_API_POORNA_FILE_PATH);
		String sUri=JsonPath.read(sEnv,"$.prod.URL");
		sUri=sUri+JsonPath.read(sEnv, "$.prod.endpoint.getdata");
		logger.debug("entered login url and end point");
		HashMap<String, String> headers=new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);
		logger.debug("entered headers");
		//HashMap<String, String> payLoad=new HashMap<String, String>();
		Response res=oRestUtil.taget(sUri, headers);
		System.out.println(res.asPrettyString());
		
	}
}
