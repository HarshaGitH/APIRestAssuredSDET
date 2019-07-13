package PostReq;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OnO {
	
	@Test
	public void bearer() {
		
		
		//Base uri
		RestAssured.baseURI = "http://10.4.11.108:8090/api/iam/oauth";
		
	    RequestSpecification request = RestAssured.given().config(RestAssured.config() .encoderConfig(EncoderConfig.encoderConfig() 
	    		.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC))) .contentType(ContentType.URLENC.withCharset("UTF-8")) 
			      .formParam("grant_type", "password")
			      .formParam("username", "HONO")
			      .formParam("password", "PASSWORD%")
			      .header("Content-Type", "application/x-www-form-urlencoded")
			     .header("Authorization", "Basic bWVyY2F0b3I6")
			     .header("Referer", "http://10.4.11.108").request();
	    
	    Response response = request.request(Method.POST,"/token");
	    String resp = response.getBody().asString();
	    int statuscode = response.getStatusCode();
	    String token = response.jsonPath().get("access_token");
		System.out.println(token);
		System.out.println("statuscode" +statuscode);

}
}
