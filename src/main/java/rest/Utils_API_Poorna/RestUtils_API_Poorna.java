package rest.Utils_API_Poorna;

import java.io.File;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constants_API_Poorna.FileConstants_API_Poorna;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.given;


/**
 * @author poorn
 *
 */
public class RestUtils_API_Poorna {
	protected static Logger logger = LogManager.getLogger("");
	
	public Response taPost(String sBaseUri,HashMap<String, String> header, HashMap<String, String>payload ) {
		RestAssured.baseURI=sBaseUri;
		logger.debug("Baseuri");   
		System.out.println(sBaseUri);
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().body(payload).post()
				.then().statusCode(201).extract().response();
		
	return res;
	}
	public Response taPost(String sBaseUri,HashMap<String, String> header, Object payload ) {
		RestAssured.baseURI=sBaseUri;
		logger.debug("Baseuri");
		RestAssured.useRelaxedHTTPSValidation();
		System.out.println("taPost: URI :"+sBaseUri);
		Response res = RestAssured.given().headers(header).when().body(payload).post().then()
				
				.statusCode(201).extract().response();
		
	return res;
	}
	
	public Response taPostSchemaValidation(String sBaseUri,HashMap<String, String> header, Object payload ) {
		RestAssured.baseURI=sBaseUri;
		logger.debug("Baseuri");
		RestAssured.useRelaxedHTTPSValidation();
		System.out.println("taPost: URI :"+sBaseUri);
		Response res = RestAssured.given().headers(header).when().body(payload).post().then()
				.assertThat().body(matchesJsonSchema(new File(FileConstants_API_Poorna.LOGIN_SCHEMA_VALIDATION_FILE_PATH))).extract().response();
				//.then().statusCode(201).extract().response();
		
	return res;
	}
	public Response taPost(String sBaseUri,HashMap<String, String> header, String payload ) {
		RestAssured.baseURI=sBaseUri;
		logger.debug("Baseuri");
		System.out.println(sBaseUri);
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().body(payload).post();
				//.then().statusCode(201).extract().response();
		
	return res;
	}
	/**
	 * @param sBaseUri
	 * @param header
	 * @return
	 */
	public Response taget(String sBaseUri,HashMap<String, String>header) {
		RestAssured.baseURI=sBaseUri;
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().get();
		
	return res;
	}
	
	/**
	 * @param sBaseUri
	 * @param header
	 * @param payload
	 * @return
	 */
	public Response taPut(String sBaseUri,HashMap<String, String>header, HashMap<String, String>payload) {
		RestAssured.baseURI=sBaseUri;
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().body(payload).put();
		
	return res;
	}
	
	/**
	 * @param sBaseUri
	 * @param header
	 * @param payload
	 * @return
	 */
	public Response taDelete(String sBaseUri, HashMap<String, String>header, HashMap<String, String>payload) {
		RestAssured.baseURI=sBaseUri;
		RestAssured.useRelaxedHTTPSValidation();
		Response res=RestAssured.given().headers(header).when().body(payload).delete();
		return res;
	}
	public Response taLogout(String sBaseUri,HashMap<String, String> header) {
		RestAssured.baseURI=sBaseUri;
		logger.debug("Baseuri");   
		System.out.println(sBaseUri);
		RestAssured.useRelaxedHTTPSValidation();
		Response res = RestAssured.given().headers(header).when().post();
		
		//		.then().statusCode(201).extract().response();
	
	return res;
	}
	
}
