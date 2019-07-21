package PostReq;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OnO {
	
	@Test
	public void bearer() {
		//Base uri
		RestAssured.baseURI = "http://10.4.11.108:8090/api/iam/oauth";
		RequestSpecification request = RestAssured.given();
	    request.header("Content-Type", "application/x-www-form-urlencoded");
	    request.header("Authorization", "Basic bWVyY2F0b3I6");
	    request.header("Referer", "http://10.4.11.108");
	    request.formParam("password", "PASSWORD%");
	    request.formParam("username", "HONO");
	    request.formParam("grant_type", "password");
	    Response response = request.request(Method.POST,"/token");
	    String resp = response.getBody().asString();
	    System.out.println(resp);
	    int statuscode = response.getStatusCode();
	    String conten = response.getContentType();
	    String token = response.jsonPath().get("access_token");
	    String token1 = response.jsonPath().get("token_type");
	    System.out.println(token1);
		System.out.println(conten);
		System.out.println("statuscode" +statuscode);
}
}


