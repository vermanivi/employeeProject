package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class H2jdbcInsertDemo {
	public Employee fetch(int id) {
		
		Employee r=new Employee();
		 String JDBC_DRIVER = "org.h2.Driver";   
		 String DB_URL = "jdbc:h2:~/test";  
		   
		   //  Database credentials 
		 String USER = "sa"; 
		 String PASS = ""; 
	      Connection conn = null; 
	      PreparedStatement pstmt = null; 
	      try{
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to a selected database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
	         System.out.println("Connected database successfully..."); 
	         
	         // STEP 3: Execute a query 

    String sql = "SELECT id, first, last, age FROM Registration where id = ?";
    PreparedStatement prest = conn.prepareStatement(sql);
    prest.setInt(1, id);
    ResultSet fet = prest.executeQuery();
    while(fet.next()) {
    	int id1=fet.getInt("id");
    	String first_name=fet.getString("first");
    	String last_name=fet.getString("last");
    	int age=fet.getInt("age"); 
    	System.out.println("Employee of: "+ id1+"First name is:" + first_name +"\nLastr name is :" + last_name +" of age"+age);
    	
    	r.age=age;
    	r.first=first_name+" "+last_name;
    	r.id=id1;
    	
    	
    }
    
    System.out.println("Record:" + fet);
    conn.close();
    prest.close();
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
		      return r;
		   }
	
	
	
    
	


	  
	   public void insert(int id,String first_name,String last_name,int age) { 
		   // JDBC driver name and database URL 
		 String JDBC_DRIVER = "org.h2.Driver";   
		 String DB_URL = "jdbc:h2:~/test";  
		   
		   //  Database credentials 
		 String USER = "sa"; 
		 String PASS = ""; 
	      Connection conn = null; 
	      PreparedStatement pstmt = null; 
	      try{
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to a selected database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
	         System.out.println("Connected database successfully..."); 
	         
	         // STEP 3: Execute a query 
	       String sql="INSERT INTO Registration (ID,FIRST,LAST,AGE) VALUES (?,?,?,?)";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1,id);
	         pstmt.setString(2, first_name);
	         pstmt.setString(3, last_name);
	         pstmt.setInt(4, age);
	         int affectedRows =pstmt.executeUpdate();
	         System.out.println(affectedRows + "row(s) affected");
	         
	         
	         // STEP 4: Clean-up environment 
	         pstmt.close(); 
	         conn.close(); 
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
	   } 
	   public void delete(int id) throws Exception {
			 String JDBC_DRIVER = "org.h2.Driver";   
			 String DB_URL = "jdbc:h2:~/test";  
			   
			   //  Database credentials 
			 String USER = "sa"; 
			 String PASS = ""; 
		      Connection conn = null; 
		      PreparedStatement pstmt = null; 
		      try{
		         // STEP 1: Register JDBC driver 
		         Class.forName(JDBC_DRIVER);  
		         
		         // STEP 2: Open a connection 
		         System.out.println("Connecting to a selected database..."); 
		         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
		         System.out.println("Connected database successfully..."); 
		         
		         // STEP 3: Execute a query 

	    String sql = "DELETE FROM Registration where id = ?";
	    PreparedStatement prest = conn.prepareStatement(sql);
	    prest.setInt(1, id);
	    int del = prest.executeUpdate();
	    System.out.println("Number of deleted records: " + del);
	    conn.close();
	    prest.close();
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
			   } 
		}


