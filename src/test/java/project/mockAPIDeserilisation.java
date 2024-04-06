package project;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class mockAPIDeserilisation {
	RequestSpecification ReqstSpec;
	@BeforeClass
	public void setUp() {
		 ReqstSpec	=RestAssured.given();
		ReqstSpec.header("Content-Type","Application/json").log().all();
	}
	@Test
	public void mocky() {
		
	 Map<String, Object> re=	ReqstSpec.get("https://run.mocky.io/v3/a0110e70-8127-456d-8a09-bbde7e82cb3b").then().log().all().extract().as(new TypeRef<Map<String,Object>>(){});
	int id=(Integer)re.get("bookingid");
    Map<String,Object> booking=	(Map<String,Object>)re.get("booking");
	System.out.println(id);
	Map<String,Object> dates=	(Map<String,Object>)re.get("bookingdates");
   System.out.println(booking.get("lastname"));
   System.out.println(dates);
	}
}
