package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class testExample {

	@Test
	public void test1() {
		
		Response response= get("https://reqres.in/api/unknown");
	System.out.println(	response.getStatusCode());
	System.out.println(	response.getTime());
	System.out.println(response.getBody().asString());
Object h= response.getHeader("content-type");
System.out.println(h);
	}
	@Test
	public void test2() {
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		.body("data[1].id",equalTo(8)).log().all();
	}
	
	
}
