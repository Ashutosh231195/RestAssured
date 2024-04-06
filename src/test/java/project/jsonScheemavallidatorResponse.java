package project;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
public class jsonScheemavallidatorResponse {
	RequestSpecification spec;
	@BeforeClass
	public void setUp() {
	 spec=	RestAssured.given().baseUri("https://restful-booker.herokuapp.com").basePath("booking").pathParam("id", 2).contentType(ContentType.JSON);
	}
   
	@Test
	public void vallidateScheama() {
	Response re=	RestAssured.given().spec(spec).get("/{id}").then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("scheema.json")).statusCode(200).log().all().extract().response();
	String conttype=  re.getHeader("Content-Type");
	System.out.println(conttype);
Headers h=	 re.getHeaders();
 List<Header> l=  h.asList();
 System.out.println(l);
 
 
 
 
	
	}
	
}
