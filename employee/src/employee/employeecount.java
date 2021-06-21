package employee;

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

public class employeecount {

	 public static Connection ConnectToDB() throws Exception {

		   DriverManager.registerDriver(new org.postgresql.Driver());
		   String postgresqlUrl = "jdbc:postgresql://localhost:5432/";
			      Connection con = DriverManager.getConnection(postgresqlUrl, "makstat", "makstat123");
			      System.out.println("Connection established......");
			      return con;
			      
	 }
	 

	      
	 public static void main(String args[])   {
	      //Creating a JSONParser objec
		


	        JSONParser jsonParser = new JSONParser();
	        try {
	            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/Elira/Desktop/tables/employeecount.json"));
	     
	            JSONObject jsonObject2 = (JSONObject) jsonObject.get("dataset");
	      
	            JSONArray jsonArray = (JSONArray) jsonObject2.get("value");
	    
	            Connection con = ConnectToDB();
	           
	            int subCategories[] = {5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};
	            int subCategoryIndex = 0;
	            int years[] = {2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019};
	            int yearIndex = 0;
	            boolean gender = false;

	            PreparedStatement pstmt = con.prepareStatement("INSERT INTO \"employee_count\" (\"count\", \"sex\", \"year\",\"sub_category_id\") VALUES (?, ?, ?, ?)");
	            for (Object count: jsonArray) {
	                if (count instanceof Double) {
	                    Double countDouble = (Double) count;
	                    if (countDouble == null) {
	                        int countInteger = 0;
	                        System.out.print(countInteger);
	                        System.out.print("--");
	                        System.out.print(subCategories[subCategoryIndex]);
	                        System.out.print("--");
	                        System.out.print(years[yearIndex]);
	                        System.out.print("--");
	                        System.out.println(gender);
	                        
	                       
	        	            pstmt.setInt(1,countInteger);

	        	            pstmt.setBoolean(2,gender);
	        	     
	        	            pstmt.setInt(3,years[yearIndex]);

	        	            pstmt.setInt(4,subCategories[subCategoryIndex]);
	        	            pstmt.executeUpdate();
	        	            
	        	            
	                    } else {
	                        Integer countInteger = countDouble.intValue();
	                        System.out.print(countInteger);
	                        System.out.print("--");
	                        System.out.print(subCategories[subCategoryIndex]);
	                        System.out.print("--");
	                        System.out.print(years[yearIndex]);
	                        System.out.print("--");
	                        System.out.println(gender);
	                        
	                        
	                        pstmt.setInt(1,countInteger);

	        	            pstmt.setBoolean(2,gender);
	        	     
	        	            pstmt.setInt(3,years[yearIndex]);

	        	            pstmt.setInt(4,subCategories[subCategoryIndex]);
	        	            pstmt.executeUpdate();
	        	            

	        	            
	                    }
	                } else {
	                    Long countLong = (Long) count;
	                    if (countLong == null) {
	                        int countInteger = 0;
	                        System.out.print(countInteger);
	                        System.out.print("--");
	                        System.out.print(subCategories[subCategoryIndex]);
	                        System.out.print("--");
	                        System.out.print(years[yearIndex]);
	                        System.out.print("--");
	                        System.out.println(gender);
	                        
	                        pstmt.setInt(1,countInteger);

	        	            pstmt.setBoolean(2,gender);
	        	     
	        	            pstmt.setInt(3,years[yearIndex]);

	        	            pstmt.setInt(4,subCategories[subCategoryIndex]);
	        	            pstmt.executeUpdate();
	        	            
	        	            
	                    } else {
	                        Integer countInteger = countLong.intValue();
	                        System.out.print(countInteger);
	                        System.out.print("--");
	                        System.out.print(subCategories[subCategoryIndex]);
	                        System.out.print("--");
	                        System.out.print(years[yearIndex]);
	                        System.out.print("--");
	                        System.out.println(gender);
	                        
	                        
	                        pstmt.setInt(1,countInteger);

	        	            pstmt.setBoolean(2,gender);
	        	     
	        	            pstmt.setInt(3,years[yearIndex]);

	        	            pstmt.setInt(4,subCategories[subCategoryIndex]);
	        	            pstmt.executeUpdate();
 	            
	                    }
	                    
	                    
	                }

	                if (gender) {
	                    yearIndex++;
	                    if (yearIndex == years.length) {
	                        yearIndex = 0;
	                        subCategoryIndex++;
	                        if (subCategoryIndex == subCategories.length)
	                            subCategoryIndex = 0;
	                    }
	                }
	                gender = !gender;
	              
	                
	              
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
