package tests;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class testGET {
	@Test
	public void getPost() {
		baseURI="https://reqres.in/api";
  given().get("/users?page=2").then().statusCode(200).body("data[0].first_namae",equalTo("Michael"));
}
	 @Test
	 public void Post() {
		 baseURI="https://reqres.in/api";
		 JSONObject obj= new JSONObject ();
		 obj.put("name", "morpheus");
		 obj.put("job", "leader");
		 given().header("content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString()).when().
		 post("/users").then().statusCode(201).log().all();
		 
	 }
}