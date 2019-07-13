package DataDrivenTest;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class UsingExcel {
	
	@Test(dataProvider = "EmpData")
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
	    
		
		@DataProvider(name = "EmpData")
		public String [][] getEmpData() throws IOException{
			String Path = "C:\\Users\\S00308\\eclipse-workspace\\APIRestAssuredSDET\\TestCases\\DataDrivenTest\\empData.xlsx";
		int rowCount =	XLUtils.getRowCount(Path, "Sheet1");
		int colNum   =  XLUtils.getCellCount(Path, "Sheet1",1);
		
		String empDat[][] = new String[rowCount][colNum];
		for(int i = 1; i<= rowCount; i++) {
			for(int j = 0;j<colNum;j++) {
				   empDat[i-1][j] = XLUtils.getCellData(Path, "Sheet1", i, j);
			}
		}
		return (empDat);
		}
}