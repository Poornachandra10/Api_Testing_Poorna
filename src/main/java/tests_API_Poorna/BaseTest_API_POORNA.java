package tests_API_Poorna;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

import rest.Utils_API_Poorna.RestUtils_API_Poorna;
import rest.Utils_API_Poorna.object_Mapper_utils_API_Poorna;

public class BaseTest_API_POORNA  {
	protected static Logger logger = LogManager.getLogger("");
RestUtils_API_Poorna oRestUtil=null;

object_Mapper_utils_API_Poorna oRestUtil_1=null;

@BeforeSuite

public void setUp() {
	oRestUtil=new RestUtils_API_Poorna();
	oRestUtil_1= new object_Mapper_utils_API_Poorna();
}

}
