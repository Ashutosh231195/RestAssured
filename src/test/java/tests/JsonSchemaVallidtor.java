package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class JsonSchemaVallidtor {
	String server=null;
	@BeforeClass
	public void setUp() {
InputStream input	=getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties prop= new Properties();
		try {
			prop.load(input);
		server=	prop.getProperty("server");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	
	public void test2() {
		
		given().baseUri(server).basePath("api").queryParam("page", 2).
		when().get("/users").then()
		.statusCode(200).log().all();
		
	}
	
	
		public static String  Jdata() throws IOException, ParseException {
			JSONParser p= new JSONParser();
			String path=System.getProperty("user.dir");
			FileReader file= new FileReader(path+"\\jsondata\\data.json");
			Object obj=p.parse(file);
			String name=null;
		JSONObject json=	(JSONObject)obj;
	JSONArray ar=	(JSONArray)json.get("players");
	for(int i=0;i<ar.size();i++) {
	JSONObject o=(JSONObject) ar.get(i);
	 name=(String)o.get("name");
	}
	
		return name;
		}
	@Test
	public void create(String name) throws IOException, ParseException {
		 baseURI="http://localhost:3000";
		 JSONObject obj= new JSONObject ();
		 obj.put("name",name);
		 
		 given().header("content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).body(obj.toJSONString())
		 .when().
		 post("profie").then().
		 statusCode(201).log().all();
	}
	
	//@Test
		
	public void players() throws ParseException, IOException {
	
	given().auth().basic("", "").
	pathParam(server, server).
	queryParams(server, server, null)
	.accept("").when().get().then().statusCode(200).log().all();
	
	}

}
