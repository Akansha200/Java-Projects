package sample;
import java.sql.*;
import javax.swing.*;
public class Sqlitesample {
//	    public static void main(String[] args) throws Exception {
//	        try {
//	            Class.forName("org.sqlite.JDBC");
//	            Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
//            System.out.println("connected successfully");
//            JOptionPane.showMessageDialog(null,"Connected successfully");
//           conn.close();
//	        }
//        catch(Exception e)
//	        {
//	            System.out.println(e);
//	            JOptionPane.showMessageDialog(null,"Connection error");
//	        }
	
	 public static Connection ConnectDB() {
	        try {
	            Class.forName("org.sqlite.JDBC");
	            Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
         System.out.println("connected successfully");
         JOptionPane.showMessageDialog(null,"Connected successfully");
         return conn;
        
        
	        }
     catch(Exception e)
	        {
	            System.out.println(e);
	            JOptionPane.showMessageDialog(null,"Connection error");
	            return null;
	        }
	
	    }
	







}



