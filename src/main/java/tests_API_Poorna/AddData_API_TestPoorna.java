package tests_API_Poorna;

import java.io.IOException;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import constants_API_Poorna.FileConstants_API_Poorna;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import rest.Utils_API_Poorna.DataUtils_API_Poorna;

public class AddData_API_TestPoorna extends BaseTest_API_POORNA {
	protected static Logger logger = LogManager.getLogger("");
static String token ="";
	@Test
	public void AddDataTC_02() throws IOException {
		String sEnv = DataUtils_API_Poorna.readJsonFiletoString(FileConstants_API_Poorna.ENV_URI_API_POORNA_FILE_PATH);
		String sUri = JsonPath.read(sEnv, "$.prod.URL");
		sUri = sUri + JsonPath.read(sEnv, "$.prod.endpoint.adddata");
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("token", token);

		/*
		 * HashMap<String, String>sPayLoad=new HashMap<String, String>(); String
		 * creds=DataUtils_API_Poorna.readJsonFiletoString(FileConstants_API_Poorna.
		 * USER_ACC_API_POORNA_FILE_PATH); sPayLoad.put("username", JsonPath.read(creds,
		 * "$.prod.valid.username")); sPayLoad.put("password", JsonPath.read(creds,
		 * "$.prod.valid.password")); Response res=oRestUtil.taPost(sUri, headers,
		 * sPayLoad);
		 */

	}

}
