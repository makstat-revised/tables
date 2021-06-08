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


public class JsonToDatabase {
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
	         //Parsing the contents of the JSON file
//	         JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/Elira/Desktop/tables/PD099E16.json"));
//	         //Retrieving the array
//	         JSONArray jsonArray = (JSONArray) jsonObject.get("dataset");
//	         JSONArray jsonArray1 = (JSONArray) jsonObject.get("dataset");

	    	
	              JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/Elira/Desktop/tables/PD099E16.json"));
	            
	              JSONObject jsonObject2 = (JSONObject) jsonObject.get("dataset");
	        
	              JSONObject jsonObject3 = (JSONObject) jsonObject2.get("dimension");
	             
	              JSONObject jsonObject4 = (JSONObject) jsonObject3.get("Sector/ division");
	              
	              JSONObject jsonObject5 = (JSONObject) jsonObject4.get("category");
	           
	              JSONObject jsonObject6 = (JSONObject) jsonObject5.get("label");
	              
//	              String subCategory = (String) jsonObject6.get("1");
//	        	  System.out.println(subCategory);
	    	 Connection con = ConnectToDB();
	 
//	    	  for(Object object : jsonObject6.values())
//	    		  System.out.println(object);
	    	 
	         PreparedStatement pstmt = con.prepareStatement("INSERT INTO \"sub_category\" (\"name\", \"category_id\") VALUES (?, 1)");
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