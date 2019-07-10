package PostReq;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Post1 {
   

	@Test
	public void post() {
		
		
		//Base uri
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request pay load as we have to send the request in the JSON format setting the body first
		 JSONObject requestparam = new JSONObject();
		requestparam.put("FirstName", "Harsha3");
		requestparam.put("LastName", "Reddy1");
		requestparam.put("UserName", "Harsh");
		requestparam.put("Password", "Harshxyz");
		requestparam.put("Email", "Harshaet.com");
		httprequest.header("content-Type","application/json");
		httprequest.body(requestparam.toJSONString());
		
		Response response = httprequest.request(Method.POST,"/register");
		
		String resp = response.getBody().asString();
		System.out.println(resp);
		
		int Statuscode = response.getStatusCode();
		System.out.println("Statuscode is " + Statuscode );
		String succescode = response.jsonPath().get("SuccessCode");
		System.out.println("SuccesCode is " + succescode);
		 
		 Assert.assertEquals(201, Statuscode);
		 Assert.assertEquals("OPERATION_SUCCESS", succescode);
		 
		 //Get all the headers
		   Headers allheaders = response.headers();
		    for (Header header:allheaders) {
			   System.out.println(header.getName() +"     "+ header.getValue());	   
		   }
		 
		 
	}
	
}
