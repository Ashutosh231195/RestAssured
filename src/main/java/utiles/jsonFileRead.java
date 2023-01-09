package utiles;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonFileRead {

	public static JSONObject jsondata() throws IOException, ParseException {
	String path    =	System.getProperty("user.dir");
	
		FileReader file = new FileReader(path+"\\jsondata\\data.json");
		
		JSONParser json= new JSONParser();
		Object obj=json.parse(file);
		JSONObject jobj=((JSONObject)obj);
		
		return jobj;
	}
	
}
