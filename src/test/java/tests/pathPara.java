package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static io.restassured.RestAssured.*;
public class pathPara {
	
	@ Test
	public static void pathParam() {
		baseURI="https://reqres.in";
		given().accept(ContentType.JSON).queryParam("page", 2)
		.pathParam("id", 7)
		
	.	when()
		.get("/api/users/{id}").then().body("data.first_name", equalTo("Michael"))
		.statusCode(200).statusLine("HTTP/1.1 200 OK").log().all();
		
	}
	@ Test
	public static void QueryParam() {
		baseURI="https://.in";
		given().queryParam("page", 2).when().
		get("api/users").then().assertThat().body(
		         matchesJsonSchemaInClasspath("schema.json"));
		
		
	
	}
	@Test
	public void demo() {
		baseURI= "http://localhost:3000";
	JSONObject obj= new JSONObject();
	obj.put("name", "aniket Ardak");
	obj.put("age", "22");
given().contentType(ContentType.JSON).body(obj).
when().post("accounts/").
then().statusCode(201).log().all();
	

	
	
	
	
	}
	@Test 
	public void authBasic() {
		//baseURI="https://reqres.in";
     Map<String ,String >map= new HashMap<String ,String>();
     map.put("apitest", "RestAssurde");
	 	given().auth().oauth2("6019590651398151|0nJg693OE6uP7mHiHrRdsX32Fyg").contentType(ContentType.JSON).body(map).accept("Application/json")
		
		.when().
		get("https://www.facebook.com/games/?app_id=6019590651398151").then().statusCode(200).log().all();
 
	}
	
	@Test
public void headers() {
		Response response=given().baseUri("https://reqres.in").
				queryParam("page", 2).
				
				when().get("api/users").andReturn();
		
	String con=	response.getHeader("Connection");
	Assert.assertEquals(con,"keep-alive" );
	Headers h=	response.getHeaders();
	//Cookie serv=response.getDetailedCookie("Server");
//	System.out.println(serv.getExpiryDate());
   Map<String,String> cok=  response.getCookies();
Set<Map.Entry<String, String>> cokSet=cok.entrySet()	;
Iterator<Entry<String, String>> i=cokSet.iterator();
while(i.hasNext()){
	Entry<String,String>cokie=i.next();
	System.out.println(cokie.getKey()+":"+cokie.getValue());
}
Iterator<Header> s=	h.iterator();
	while(s.hasNext()) {
		//System.out.println(s.next());
	}
	
	}
}

