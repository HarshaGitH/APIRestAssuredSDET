package GetReq;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class practi {
	
	@Test
	public void getReq() {
		
		RestAssured.baseURI = "";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response resp = httprequest.request(Method.GET, "");
		
		String respon1 = resp.asString();
		
		int statuscode = resp.getStatusCode();
		String succ = resp.jsonPath().get("");
		
		
		
		
		
		
		
	}

}
