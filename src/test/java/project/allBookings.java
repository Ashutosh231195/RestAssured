package project;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;

public class allBookings {
	RequestSpecification reqstSpec;
	@BeforeTest
	public void setUP() {
		 reqstSpec=	given().baseUri("https://restful-booker.herokuapp.com").basePath("booking").log().all();
		
		reqstSpec.auth().basic(DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH);
	}
	@Test
    public void allBookoings() {
		reqstSpec.get().then().statusCode(200).log().all();
	}
}
