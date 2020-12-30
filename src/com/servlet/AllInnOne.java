package com.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dao.Employee;

public class AllInnOne {
	Employee r=new Employee();
	 String JDBC_DRIVER = "org.h2.Driver";   
	 String DB_URL = "jdbc:h2:~/test";  
	   
	   //  Database credentials 
	 String USER = "sa"; 
	 String PASS = ""; 
     Connection conn = null; 
     PreparedStatement pstmt = null; 
    

}
