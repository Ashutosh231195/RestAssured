import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

public class jasondata {
	public static JSONObject  Jdata() throws IOException, ParseException {
		JSONParser p= new JSONParser();
		FileReader file= new FileReader("C:\\Users\\Aashuu\\eclipse-workspace\\RestAssurd\\jsondata\\data.json");
		Object obj=p.parse(file);
		
	JSONObject json=	(JSONObject)obj;
	return json;
	}
	
	@Test
	public static void forigenPlayer() throws IOException, ParseException {
		JSONObject json=  jasondata.Jdata();
	String nm=(String) json.get("name");
	String sal=(String) json.get("location");
System.out.println(nm);
System.out.println(sal);
JSONArray ar=(JSONArray) json.get("players");
int Player=11;
for (int i=0;i<ar.size();i++) {
	JSONObject ob=	(JSONObject)ar.get(i);
String contry=	(String) ob.get("country");
if(contry.equalsIgnoreCase("india")) {
	Player--;
}
}
Assert.assertEquals(4,Player );

System.out.println(Player);
}
@Test
public void wicketKipper() throws IOException, ParseException {
	JSONObject json=  jasondata.Jdata();
	JSONArray ar=(JSONArray) json.get("players");
int wiketKipper=0;
	for (int i=0;i<ar.size();i++) {
		JSONObject ob=	(JSONObject)ar.get(i);
	String role=	(String) ob.get("role");
	if(role.equalsIgnoreCase("Wicket-keeper")) {
		wiketKipper++;
	}
	
	}
	System.out.println(wiketKipper);
	Assert.assertEquals(1, wiketKipper);
}
	

}
