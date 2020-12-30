package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {	
	public boolean update(int id,String fname,String lname,int age) {

		 String JDBC_DRIVER = "org.h2.Driver";   
		 String DB_URL = "jdbc:h2:~/test";    
	   //  Database credentials 
	 String USER = "sa"; 
	 String PASS = ""; 
    Connection conn = null; 
    PreparedStatement pstmt = null;
    try{
//      // STEP 1: Register JDBC driver 
      Class.forName(JDBC_DRIVER);  
      
      // STEP 2: Open a connection 
      System.out.println("Connecting to a selected database..."); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS); 
      System.out.println("Connected database successfully..."); 
    
      // STEP 3: Execute a query 


    String query="UPDATE Registration set first=?,last=?,age=? where id=?";
    pstmt=conn.prepareStatement(query);
   
    pstmt.setString(1, fname);
    pstmt.setString(2,lname);
    pstmt.setInt(3, age);
    pstmt.setInt(4,id );
    pstmt.executeUpdate();
    return true;
    
    
    } catch(SQLException se) { 
        // Handle errors for JDBC 
        se.printStackTrace(); 
     } catch(Exception e) { 
        // Handle errors for Class.forName 
        e.printStackTrace(); 
     } finally { 
        // finally block used to close resources 
        try {
           if(pstmt!=null) pstmt.close();  
        } catch(SQLException se2) { 
        } // nothing we can do 
        try { 
           if(conn!=null) conn.close(); 
        } catch(SQLException se) { 
           se.printStackTrace(); 
        } // end finally try 
     } // end try 
   System.out.println("Goodbye!"); 
  return false;
	}
	

}
