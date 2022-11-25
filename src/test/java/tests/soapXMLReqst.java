package tests;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import  io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import org.apache.commons.io.*;
import org.testng.annotations.Test;
public class soapXMLReqst {
	@Test
public void soapXML() throws IOException {
	File file = new File ("C:\\Users\\Aashuu\\eclipse-workspace\\RestAssurd\\soapfile\\add.xml");
	if (file.exists()) {
		System.out.println("   >>> FILE EXIST");
		
	}
	FileInputStream fileinput= new FileInputStream(file);
	baseURI= "https://ecs.syr.edu";
	String response=org.apache.commons.io.IOUtils.toString(fileinput,"UFT-8");
	
	given().contentType("text/xml").accept(ContentType.XML).body(response).
	when().post("calculator.asmx")
	.then().statusCode(200);
}
}
