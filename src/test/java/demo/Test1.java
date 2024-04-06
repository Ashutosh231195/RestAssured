package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Test1 {
	
	@Test
	public void demo() {
		//baseURI="https://weatherapi-com.p.rapidapi.com/current.json";
	Response re=given().queryParam("q", "mumbai").header("X-RapidAPI-Key","a7b405b63dmsh325ebce736b9875p12dd92jsn72682db5c334").
		accept(ContentType.JSON).
		when().get("https://weatherapi-com.p.rapidapi.com/current.json").
		then().body("location.region", equalTo("Maharashtra")).log().
		body().extract().
		response();
	String h=re.header("cdn-pullzone");
	long time=re.getTime();
	System.out.println(time +re.getStatusLine());
	Headers header=re.headers();
	System.out.println(header);
	Assert.assertEquals(h, "93447");
		System.out.println(re.asString());
	}
@Test 
public void body() {
	Object obj=null;
Response re =given().auth().preemptive().basic(DEFAULT_PATH, "").body( obj).
header("content-type","application/json").
when().post().then().assertThat().body("",equalTo("")).log().body().extract().response();

	int st=re.getStatusCode();
	
	String ss=re.jsonPath().get("SuccessCode");
	System.out.println(ss);
	System.out.println(st);
	Assert.assertEquals(st, 200);

}
}
