package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class JsonSchemaVallidtor {
	@Test
	public void test2() {
		
		given().get("https://reqres.in/api/users?page=2").then()
		.assertThat().body(matchesJsonSchemaInClasspath("Scheema.json")).statusCode(200);
		
	}

}
