package tests;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Authentication {
	  @BeforeClass
	    public static void setUP()
	    {
	     // baseURI ="http://restapi.demoqa.com";
		authentication=  preemptive().basic(DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH);
	    }
	 
	    /**
	     * Here we are using basic way of authentication
	     */
	   
	    @Test
	    public void forValidLoginWay1()
	    {
	        given().auth()
	                .basic("ToolsQA", "TestPassword")
	                .when()
	                .get("/authentication/CheckForAuthentication")
	                .then()
	                .assertThat()
	                .statusCode(HttpStatus.SC_OK).log().all(true);
	                
	    }
	 
	 
	    /**
	     * Here we are using preemptive way of response verification
	     */
	    @Test
	    public void forValidLoginWay2()
	    {
	        given().auth()
	                .preemptive()
	                .basic("ToolsQA", "TestPassword")
	                .when()
	                .get("/authentication/CheckForAuthentication")
	                .then()
	                .assertThat()
	                .statusCode(200).log().all(true);
	    }
	 
	    /**
	     * Here we ary trying to verify invalid login response
	     */
	    @Test
	    public void forInvalidLoginWay1()
	    {
	       given().auth()
	                .basic("InvalidUserName", "InvalidPassword")
	                .when()
	                .get("/authentication/CheckForAuthentication")
	                .then()
	                .assertThat()
	                .statusCode(HttpStatus.SC_UNAUTHORIZED).log().all(true)
;	    }
	 
	    @Test
	    public void forInvalidLoginWay2()
	    {
	      given().auth()
	                .preemptive()
	                .basic("InvalidUserName", "InvalidPassword")
	                .when()
	                .get("/authentication/CheckForAuthentication")
	                .then()
	                .assertThat()
	                .statusCode(401).log().all(true);
	    }
	}


