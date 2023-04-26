package practice_LINEAR_Way;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class first_Api_Automation {

	public static void main(String[] args) throws InterruptedException {
//logging in with test assured.baseURI class
		
		RestAssured.baseURI = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";

		// This is the third way he thought in April 17 th 2023, api 3 session-
		// class:other way of giving headers

		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		Response res = RestAssured.given().headers(headers).when()
				.body("{\"username\":\"mar2023poorna@ta.com\",\"password\":\"Mar231234\"}").post("login").then()
				.statusCode(201).extract().response();

		// This is the first way he thought in class:other way of giving headers
		// Response res=(Response)
		// RestAssured.given().contentType(ContentType.JSON).when().body("{\"username\":\"mar2023poorna@ta.com\",\"password\":\"Mar231234\"}").post();

		// This is the second way he thought in class:other way of giving headers
		// Response res =RestAssured.given().header("Content-Type",
		// "application/json").when().body("{\"username\":\"mar2023poorna@ta.com\",\"password\":\"Mar231234\"}").post();

		System.out.println(res.asPrettyString());
//*********************************************************
// Extracting the token
		String token = res.jsonPath().getString("token").replaceAll("\\[", "").replaceAll("]", "");
		System.out.println(token);

// extracting userid
		String userid = res.jsonPath().getString("userid").replaceAll("\\[", "").replaceAll("]", "");
		System.out.println(userid);

		// RestAssured.baseURI="https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/addData";
		// instead of calling it each and every time we can give inside post (), the url
		// remains same . so we are doing this;
//**********************************************
		// Adding data ro user files

		HashMap<String, String> addDataHeaders = new HashMap<String, String>();

		addDataHeaders.put("Content-Type", "application/json");
		addDataHeaders.put("token", token);
		// addDataHeaders.put("userid", userid);
		// String
		// payload={"accountno":"T010101010","departmentno":"1","salary":"123456789","pincode":"641046"}

		HashMap<String, String> addPayload = new HashMap<String, String>();
		addPayload.put("accountno", "Poorna010");
		addPayload.put("departmentno", "8");
		addPayload.put("salary", "1984980");
		addPayload.put("pincode", "641046");

		Response res2 = RestAssured.given().headers(addDataHeaders).when().body(addPayload).post("addData").then()
				.statusCode(201).extract().response();

		System.out.println(res2.asPrettyString());
//*******************************
		// Extracting new token for update:Doin it by my own.if its wrong del it

		/*
		 * RestAssured.baseURI =
		 * "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net/";
		 * HashMap<String, String> headers = new HashMap<String, String>();
		 * headers.put("Content-Type", "application/json"); Response res =
		 * RestAssured.given().headers(headers).when()
		 * .body("{\"username\":\"mar2023poorna@ta.com\",\"password\":\"Mar231234\"}").
		 * post("login").then() .statusCode(201).extract().response();
		 * System.out.println(res.asPrettyString());
		 * 
		 */

		// Adding data ro user files

		/*
		 * HashMap<String, String> addDataHeaders = new HashMap<String, String>();
		 * 
		 * addDataHeaders.put("Content-Type", "application/json");
		 * addDataHeaders.put("token", token);
		 * 
		 * HashMap<String, String> addPayload = new HashMap<String, String>();
		 * addPayload.put("accountno", "Poorni10"); addPayload.put("departmentno", "1");
		 * addPayload.put("salary", "19764789"); addPayload.put("pincode", "641046");
		 * 
		 * 
		 * Response res2 =
		 * RestAssured.given().headers(addDataHeaders).when().body(addPayload).post(
		 * "addData").then() .statusCode(201).extract().response();
		 * 
		 * 
		 * System.out.println(res2.asPrettyString());
		 */
		// *****************************************
		// Trying update data

		HashMap<String, String> UpdateDataHeaders = new HashMap<String, String>();
		UpdateDataHeaders.put("Content-Type", "application/json");
		UpdateDataHeaders.put("token", token);

		HashMap<String, String> addPayloadUpdate = new HashMap<String, String>();
		addPayloadUpdate.put("accountno", "Poorni10");
		addPayloadUpdate.put("departmentno", "9");
		addPayloadUpdate.put("salary", "950309");
		addPayloadUpdate.put("pincode", "641046");
		addPayloadUpdate.put("userid", userid);
		addPayloadUpdate.put("id", "vlc6dHfOafNMU0Z675Ps");
		Response res3 = RestAssured.given().headers(UpdateDataHeaders).when().body(addPayloadUpdate).put("updateData");
		// .then().statusCode(201).extract().response();

		System.out.println(res3.asPrettyString());
		// **********************************
		// Trying to get data
		//success< its printing all datas....
		//so, i m commenting out
		
		//HashMap<String, String> getDataHeaders = new HashMap<String, String>();
		//getDataHeaders.put("Content-Type", "application/json");
		//getDataHeaders.put("token", token);

		/*
		 * HashMap<String, String> getData = new HashMap<String, String>();
		 * getData.put("userid", userid); getData.put("id", "vlc6dHfOafNMU0Z675Ps");
		 */
		//Response res4 = RestAssured.given().headers(getDataHeaders).when().get("getdata");

		//System.out.println(res4.asPrettyString());
		
		
		
		HashMap<String, String> deleteDataHeaders = new HashMap<String, String>();
		deleteDataHeaders.put("Content-Type", "application/json");
		deleteDataHeaders.put("token", token);	
		
		HashMap<String, String> deleteData = new HashMap<String, String>();
		deleteData.put("userid", userid);
		deleteData.put("id", "vlc6dHfOafNMU0Z675Ps");
		
	}
}
