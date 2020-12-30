package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee;
import com.dao.EmployeesDAO;


/**
 * Servlet implementation class AllData
 */
@WebServlet("/EmployeesController")
public class EmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	       // Set response content type
	       response.setContentType("text/html");

	       PrintWriter out = response.getWriter();
	       String title = "Employee Details ";
	       String docType =
	          "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

	       out.println(docType +
	          "<html>\n" +
	             "<head><title>" + title + "</title></head>\n" +
	             "<body bgcolor = \"#f0f0f0\">\n" +
	                "<h1 align = \"center\">" + title + "</h1>\n"                          
	       );
	       
	       
	       int columnCount=3;
	     EmployeesDAO selet=new EmployeesDAO();
	     List<Employee>  employeesList=  selet.selectAll();
	       int rowCount = employeesList.size();

	       out.println("<P ALIGN='center'><TABLE BORDER=1>");
	       
	       out.println("<TR>");
	       
	         out.println("<TH>" + "ID" + "</TH>");
	         out.println("<TH>" + "Name" + "</TH>");
	         out.println("<TH>" + "Age" + "</TH>");
	         
	       out.println("</TR>");
	       
	       
	       
		for(Employee emp: employeesList) {
	    	   out.println("<TR>");
	    	    out.println("<TD>" + emp.id + "</TD>");
	    	    out.println("<TD>" + emp.first + "</TD>");
	    	    out.println("<TD>" + emp.age + "</TD>");	    	   
	    	   out.println("</TR>");
	    	   
	       }
	       
	       out.println("</TABLE></P>");
	       
	       
	       out.println("</body>"+
	 	          "</html>");
	}


	
	
}
