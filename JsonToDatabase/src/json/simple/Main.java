package json.simple;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {

    public static void main(String[] args) {
//        try {
//            Class.forName("org.postgresql.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/makstat", "makstat", "makstat123");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("Select * from category");
//            while(rs.next())
//                System.out.println(rs.getString(1) + " | " + rs.getString(2));
//            conn.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\Elira\\Downloads\\table1.json"));
            System.out.println(jsonObject);
            JSONObject jsonObject2 = (JSONObject) jsonObject.get("dataset");
            System.out.println(jsonObject2);
            JSONObject jsonObject3 = (JSONObject) jsonObject2.get("dimension");
            System.out.println(jsonObject3);
            JSONObject jsonObject4 = (JSONObject) jsonObject3.get("Sector");
            System.out.println(jsonObject4);
            JSONObject jsonObject5 = (JSONObject) jsonObject4.get("category");
            System.out.println(jsonObject5);
            JSONObject jsonObject6 = (JSONObject) jsonObject5.get("label");
            System.out.println(jsonObject6);
            String subCategory = (String) jsonObject6.get("1");
            System.out.println(subCategory);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

