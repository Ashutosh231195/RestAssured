package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
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
		
	Response r=	given().header("content-type","application/xml").get("https://reqres.in/api/users?page=2").then().log().body().
		extract().response();
	String p=r.asString();
System.out.println(r.body());
System.out.println(r.getHeader("content-type"));;
	java.util.List<Object> obj=JsonPath.from(p).getList("data.findAll{it.id>10}");
	for(int i=0;i<obj.size();i++) {
		System.out.println(obj.get(i));
	}
	}
	
	
}
