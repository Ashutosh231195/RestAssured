package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class putPATCHDELT {
@	Test
public void put() {
	 baseURI="https://reqres.in/api";
	 JSONObject obj= new JSONObject ();
	 obj.put("name", "Ashutosh");
	 obj.put("job", "leader");
	 given().header("content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString()).when().
	 put("/users/2").then().statusCode(200).log().all();
	 

}
@Test
public void patch() {
	 baseURI="https://reqres.in";
	 JSONObject obj= new JSONObject ();
	 obj.put("name", "Ashutosh");
	 obj.put("job", "Ardak");
	 given().header("content-type","application/json").accept(ContentType.JSON).body(obj.toJSONString()).when().
	 put("/api/users/2").then().statusCode(200).log().all();
	 

}
@Test
public void deleat() {
	 baseURI="https://reqres.in";
	 
	 when().delete
	 ("/api/users/2").then().statusCode(204).log().all().and();
	 

}
}
