package tests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import org.json.simple.JSONObject;

public class testGET {
	@Test
	public void getPost() {
		baseURI="https://reqres.in/api";
  given().get("/users?page=2").then().statusCode(200).
  body("data[0].first_namae",equalTo(null));
}
	 @Test
	 public void Post() {
		 baseURI="http://localhost:3000";
		 JSONObject obj= new JSONObject ();
		 obj.put("name", "morpheus");
		 obj.put("job", "leader");
		 given().header("content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString())
		 .when().
		 post("/users").then().
		 statusCode(201).log().all();
		 
	 }
	 @Test
	 public void test2() {
	given(). header("Content-Type","Application/json").
	       accept(ContentType.JSON).
	       get("https://reqres.in/api/users").then().
	       body("data[2].first_name",equalTo("Emma")).log().all();
	 }
	 @Test
	 public void test3() {

	     Response respn=  get("https://reqres.in/api/users");
	    Headers ct= respn.getHeaders();
	   System.out.println( ct.getList("connection"));
	    System.out.println(ct);
	    	//	 then().
	    //   body("data[2].first_name",equalTo("Emma")).log().all();
	 }
}