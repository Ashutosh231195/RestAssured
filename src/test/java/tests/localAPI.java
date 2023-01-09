package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class localAPI {
	@ Test
	public void locslGET() {
		
		baseURI="http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
		
	}
	@ Test
	public void locslPost() {
		JSONObject obj= new JSONObject();
		      obj.put("first_name", "asmita");
		      obj.put("last_name", "deshmukh");
		      obj.put("deptID",4);
		baseURI="http://localhost:3000";
		given().header("content-type","application/json").contentType(ContentType.JSON).
		body(obj.toJSONString()).
		when().
		post("profile").
		then().statusCode(201).log().all();
		
		
	}
	
	@ Test
	public void locslPut() {
		JSONObject obj= new JSONObject();
		      obj.put("first_name", "Ravi ");
		      obj.put("last_name", "Ardak");
		      obj.put("deptID",5);
		baseURI="http://localhost:3000";
		given().header("content-type","application/json").contentType(ContentType.JSON).
		body(obj.toJSONString()).
		when().
	post("profile").
		then().statusCode(201).log().all();
		System.out.println("we changed code");
		
	}
	@ Test
	public void localDeleat() {
		
		baseURI="http://localhost:3000";
		when().delete
		("/users/4").
		then().statusCode(404).log().all();
		
		System.out.println("we changed code");
	}
}
