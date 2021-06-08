
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import java.sql.*;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class AgeGroup {
	 public static Connection ConnectToDB() throws Exception {

		   DriverManager.registerDriver(new org.postgresql.Driver());
		   String postgresqlUrl = "jdbc:postgresql://localhost:5432/";
			      Connection con = DriverManager.getConnection(postgresqlUrl, "makstat", "makstat123");
			      System.out.println("Connection established......");
			      return con;
			      
	 }

	    	  public static void main(String args[])   {
	    	      //Creating a JSONParser object
	    	      JSONParser jsonParser = new JSONParser();
	    	      try {
	    	         
	    	    	
	    	              JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/Elira/Desktop/tables/AgeGroup.json"));
	    	            
	    	              JSONObject jsonObject2 = (JSONObject) jsonObject.get("dataset");
	    	              //System.out.println(jsonObject2);
	    	   
	    	              JSONObject jsonObject3 = (JSONObject) jsonObject2.get("dimension");
	    	              	//System.out.println(jsonObject3);
	    	            
	    	              JSONObject jsonObject4 = (JSONObject) jsonObject3.get("Age group");
	    	              	//System.out.println(jsonObject4);
	    	              JSONObject jsonObject5 = (JSONObject) jsonObject4.get("category");
		    	              //System.out.println(jsonObject5);
	    	              JSONObject jsonObject6 = (JSONObject) jsonObject5.get("label");
	    	              	System.out.println(jsonObject6);
	    	           

	    	          
	    	    	 Connection con = ConnectToDB();
	    	 
	    	    	  for(Object object : jsonObject6.values())
	    	    		  System.out.println(object);
	    	    	 
	    	         PreparedStatement pstmt = con.prepareStatement("INSERT INTO \"sub_category\" (\"name\", \"category_id\") VALUES (?, 2)");
	    	         for(Object object : jsonObject6.values()) {
	    	            String record =  (String) object;
	    	            pstmt.setString(1,record);
	    	            pstmt.executeUpdate();
	             }
	    	         
	    	         System.out.println("Records inserted.....");
	    	      } catch (FileNotFoundException e) {
	    	         e.printStackTrace();
	    	      } catch (IOException e) {
	    	         e.printStackTrace();
	    	      } catch (ParseException e) {
	    	         e.printStackTrace();
	    	      } catch (Exception e) {
	    	         // TODO Auto-generated catch block
	    	         e.printStackTrace();
	    	      }
	    	  }
}