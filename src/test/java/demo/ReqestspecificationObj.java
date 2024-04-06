package demo;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AdressPojo;
import pojo.Facebook;
import pojo.postPojo;
import pojo.postResponsePojo;
import pojo.productPojo;
import pojo.productPojoResponse;

public class ReqestspecificationObj {
	RequestSpecification spec;
	static String json;
	@BeforeClass
	public void rqstSpecifiction() {
	 spec=	given();
	spec.baseUri("http://localhost:3000/");
	spec.contentType(ContentType.JSON);
	spec.auth().none();
	spec.header("content-type","Appliczation/json");
   spec.basePath("posts");
   spec.log().all();
   
   ResponseSpecification re=  expect();
   re.statusCode(200);
   re.contentType(ContentType.JSON);
   re.time(Matchers.lessThan(500L));
	}
	
	public static String jbody() {
		productPojo obj= new productPojo("ashu@gmail.com", "ashu","ardak", "gamechanger");
		ObjectMapper map= new ObjectMapper ();
		try {
			json=		map.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	@Test
	public void post() {

		AdressPojo  re=	given().spec(spec).contentType(ContentType.JSON).when().get()
	//	.then().extract().response().as(postPojo.class);
			.then().extract().response().jsonPath().getObject("facebook", AdressPojo.class);
	
	
	Facebook obj= new Facebook();
String fn=	obj.getFirst_name();

	System.out.println(re.getCountry());

	
	}
	
	@Test
	public void profileGet() {
		
		productPojoResponse re=	given().spec(spec).get().then().extract().response().as(productPojoResponse.class);
		  System.out.println(re.getEmail());
		
	}

}
