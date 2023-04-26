package rest.Utils_API_Poorna;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jayway.jsonpath.JsonPath;

import constants_API_Poorna.FileConstants_API_Poorna;

public class DataUtils_API_Poorna {
	protected static Logger logger = LogManager.getLogger("");
	
public static String readJsonFiletoString(String sFilePath) throws IOException {
	byte[] data = Files.readAllBytes(Paths.get(sFilePath));
	return new String (data, StandardCharsets.UTF_8);
	}

//did not use try catch method
public static Object sLoginValidationData(String jsonPath) throws IOException {
	String loginValidation = null;
	loginValidation=DataUtils_API_Poorna.readJsonFiletoString(FileConstants_API_Poorna.LOGIN_VALIDATION_POORNA_FILE_PATH);
	Object value = JsonPath.read(loginValidation,jsonPath);
	return value;
}
}
