package DataDrivenTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class AddNewEmp {
	
	
	@Test
	public void addNewEmp() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
	    requestParam.put("name", "Harshar");
	    requestParam.put("salary", "2000");
	    requestParam.put("age", "28");
	    httprequest.body(requestParam.toJSONString());
	    httprequest.header("content-Type","application/json");
	    
	    Response resp = httprequest.request(Method.POST,"/create");
	    
	    String response = resp.asString();
	    System.out.println(response);
	    
	    Assert.assertEquals("Harsha", resp.jsonPath().get("name"));
	    
	    
		
		
		
	}

}
