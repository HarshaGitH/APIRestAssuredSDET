package GetReq;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Req1 {

  @Test
  public void getweatherdetails() {
	  
	  //Specify the Base URI
	  RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
	  
	  //Which request like get post
	  RequestSpecification httprequest = RestAssured.given();
	  
	  //Response object 
	  Response response = httprequest.request(Method.GET,"/Hyderabad");
	  
	  //Print response in the console window
	   String resp =  response.getBody().asString();
	   System.out.println("Response body is " + resp);
	   
	  //Verify the status code and Status line.
	   int status =   response.getStatusCode();
	   Assert.assertEquals(status, 200);
	   
	   //Status line verification
	   
	  String  line = response.getStatusLine();
	  System.out.println("Status LINE" + line);
	  
	  Assert.assertEquals(line, "HTTP/1.1 200 OK");
	  Headers allheaders = response.headers();
	   
	   for (Header header:allheaders) {
		   System.out.println(header.getName() +"     "+ header.getValue());
		   
	   }
	    
	  
  }

}
