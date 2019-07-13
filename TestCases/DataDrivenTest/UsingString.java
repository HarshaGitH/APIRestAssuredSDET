package DataDrivenTest;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class UsingString {
	
	@Test(dataProvider = "empData")
	public void Datapro(String ename,String esal, String eage) {
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
	    requestParam.put("name", ename);
	    requestParam.put("salary", esal);
	    requestParam.put("age", eage);
	    httprequest.body(requestParam.toJSONString());
	    httprequest.header("content-Type","application/json");
	    
	    Response resp = httprequest.request(Method.POST,"/create");
	    
	    String response = resp.asString();
	    System.out.println(response);
	    
	//    Assert.assertEquals("Harsha", resp.jsonPath().get("name"));
	}
    
	@DataProvider(name="empData")
	public String [][] getempDat() {
		String empData [][] = {{"Harsht","200","27"},{"Harshu","220","29"},{"HarshRd","500","37"}};
		return empData;
		
	}
}
