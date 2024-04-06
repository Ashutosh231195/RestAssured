package demo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.Response;

import io.restassured.http.ContentType;
import pojo.productPojo;

import static io.restassured.RestAssured.*;

public class createUser {

	
	@Test
	public void serialisation() throws JsonProcessingException {
		productPojo pojo=	new productPojo("1", "ardak@gmail.com", "Ashutosh", "Ardak");

		   ObjectMapper map= new ObjectMapper();
		  String jsonString =map.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		    System.out.println(jsonString);
		baseURI ="http://localhost:3000/";
          given().header("content-type","Applicstion/json").contentType(ContentType.JSON)
.	   body(jsonString).when()
	.post("profile");
		
			}
	
@Test
public void deSerialisation() {
	baseURI="http://localhost:3000/";
	io.restassured.response.Response re= given().queryParam("id", 1).contentType(ContentType.JSON).when()
	.get("profile").then().assertThat().statusCode(200).extract().response();
	   ObjectMapper map= new ObjectMapper();
	 String jsonString=  re.asPrettyString();
	   try {
		   productPojo obj=	map.readValue(jsonString,productPojo.class );
		         System.out.println(obj.getEmail());
			System.out.println( obj.getFirst_name());
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 


}
}
