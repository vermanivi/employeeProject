package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO{
	public List<Employee> selectAll(){
	ArrayList<Employee> employeeList=new ArrayList<>();	
		
	 String JDBC_DRIVER = "org.h2.Driver";   
	 String DB_URL = "jdbc:h2:~/test";  
	   
	   //  Database credentials 
	 String USER = "sa"; 
	 String PASS = ""; 
     Connection conn = null; 
     PreparedStatement pstmt = null; 
     try{
//        // STEP 1: Register JDBC driver 
     Class.forName(JDBC_DRIVER);  
        
        // STEP 2: Open a connection 
        System.out.println("Connecting to a selected database..."); 
        conn = DriverManager.getConnection(DB_URL,USER,PASS); 
        System.out.println("Connected database successfully..."); 
        
        // STEP 3: Execute a query 

String sql = "SELECT id, first, last, age FROM Registration";
PreparedStatement prest = conn.prepareStatement(sql);
ResultSet fet = prest.executeQuery();
while(fet.next()) {
	Employee employee=new Employee();
	int id1=fet.getInt("id");
	String first_name=fet.getString("first");
	String last_name=fet.getString("last");
	int age=fet.getInt("age"); 
	System.out.println("Employee of: "+ id1+"First name is:" + first_name +"\nLastr name is :" + last_name +" of age"+age);
	
	employee.age=age;
	employee.first=first_name+" "+last_name;
	employee.id=id1;
	employeeList.add(employee);	

System.out.println("Record:" + fet);
conn.close();
prest.close();
}
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
	      return employeeList;
	   }
}









