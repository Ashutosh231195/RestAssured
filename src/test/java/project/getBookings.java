package project;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class getBookings {
	RequestSpecification reqstSpec;
	ResponseSpecification respSpec;
	@BeforeClass()
	public void getbookigs() {
         reqstSpec=given().log().all();
		reqstSpec.baseUri("https://restful-booker.herokuapp.com");
		reqstSpec.basePath("booking/{id}");
		reqstSpec.pathParam("id", 2);
		respSpec=given().expect().statusCode(200).contentType(ContentType.JSON);
	}
		@Test
		public void StatusCode() {
		ValidatableResponse validResp=reqstSpec.get().then()
		.assertThat().statusCode(200).log().all();
		//validResp.body("lastname", equalTo("Brown"));
	}	
	@Test(priority=2)
	public void stusline() {
	Response re=given().spec(reqstSpec).get().then().spec(respSpec).log().all().extract().response();	
	System.out.println(re.getStatusLine() + re.getStatusCode()+ re.getContentType());
	String jsonString=re.asPrettyString();
	JsonPath jsonPath= new JsonPath(jsonString);
      String date=jsonPath.getString("totalprice");
	System.out.println(Integer.parseInt(date));
	
	}
	@Test (priority=3)
	public void body() {
		given().spec(reqstSpec).get().then().assertThat().body("firstname", equalTo("Mary"));
	}
	@Test
	public void time() {
		Map<String,Object> headers= new HashMap<String,Object>();
		headers.put("content-type", "Application/json");
		
		reqstSpec.headers(headers).get().then().time(Matchers.lessThan(4000L)).contentType(ContentType.JSON);


	}

}
