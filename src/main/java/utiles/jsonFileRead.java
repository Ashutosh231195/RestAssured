package utiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
public class jsonFileRead {
@DataProvider
	public static String[] jsondata() throws IOException, ParseException {
	String path    =	System.getProperty("user.dir");
	
		FileReader file = new FileReader(path+"\\jsondata\\data.json");
		
		JSONParser json= new JSONParser();
		Object obj=json.parse(file);
	
		JSONObject jobj=((JSONObject)obj);
	String s=	(String) jobj.get("name");
	String [] z= {s};
	HashMap<Object, Object>	map= new HashMap<Object, Object>();
	map.put("name", s);
		return z;
		
		
		
		
	}
@Test(dataProvider="jsondata")
	public static void demo(String name) throws IOException, ParseException {
	
		System.out.println(name);
	}
	
}
