package project;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class tokenAuth {
	RequestSpecification reqstSpec;
	@BeforeClass
	public void setup() {
		JSONObject obj= new JSONObject();
		obj.put("username", "admin");
		obj.put("password", "password123");
		reqstSpec=RestAssured.given().header("Content-Type","application/json").baseUri("https://restful-booker.herokuapp.com/").basePath("booking");

	}
	@Test
	public void tokengen() {
		
		ValidatableResponse valResp=reqstSpec.post().then();
		valResp.statusCode(200).log().all();
	}
	@Test
	public void tokenVal() {
		
		ValidatableResponse valResp=reqstSpec.post().then().body("token",Matchers.notNullValue()).body("token.length()",Matchers.is(15)).log().all();
	
	}
	@Test
	public void createBooking() {
	Response valResp=reqstSpec.contentType(ContentType.JSON).body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").post().then().log()
				.all().extract().response();
String resp=	valResp.asPrettyString();

JsonPath jp= new JsonPath(resp);
   System.out.println(jp.get("bookingid"));
	}

}
