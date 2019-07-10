package GetReq;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Authetication {
	
	@Test
	public void author() {
		
		 //Specify the Base URI
		  RestAssured.baseURI ="http://restapi.demoqa.com/authentication/CheckForAuthentication/";
		  
		  //BasicAuthentication
		  PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		  RestAssured.authentication = auth;
		  auth.setUserName("ToolsQA");
		  auth.setPassword("TestPassword");
		  
		 
		  
		  //Which request like get post
		  RequestSpecification httprequest = RestAssured.given();
		  
		  Response response = httprequest.request(Method.GET,"/");
		  
		 //Resposne Code
		  String respo = response.asString();
		  System.out.println(respo);
		  
		  int statuscode = response.getStatusCode();
		  Assert.assertEquals(200, statuscode);
		  
		
		
	}

}
