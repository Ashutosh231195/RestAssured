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
		accept(ContentType.JSON).body(obj.toJSONString()).
		when().
		post("/users").
		then().statusCode(201).log().all();
		
		
	}
	
	@ Test
	public void locslPut() {
		JSONObject obj= new JSONObject();
		      obj.put("first_name", "ASMITA");
		      obj.put("last_name", "DESHMUKH");
		      obj.put("deptID",4);
		baseURI="http://localhost:3000";
		given().header("content-type","application/json").contentType(ContentType.JSON).
		accept(ContentType.JSON).body(obj.toJSONString()).
		when().
		put("/users/4").
		then().statusCode(200).log().all();
		
		
	}
	@ Test
	public void localDeleat() {
		
		baseURI="http://localhost:3000";
		when().delete
		("/users/4").
		then().statusCode(404).log().all();
		
		
	}
}
