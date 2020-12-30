package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.H2jdbcInsertDemo;
import com.dao.*;

/**
 * Servlet implementation class Fetchdata
 */
@WebServlet("/Fetchdata")
public class Fetchdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Employee r=new Employee();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetchdata() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    // Method to handle GET method request.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
       
       // Set response content type
       response.setContentType("text/html");

       PrintWriter out = response.getWriter();
       String title = "Employee Details required";
       String docType =
          "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

       out.println(docType +
          "<html>\n" +
             "<head><title>" + title + "</title></head>\n" +
             "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                   "  <li><b>Emplyee mane: </b>: "
                   + r.first + "\n" +
                   "  <li><b>Employee age: </b>: "
                   + r.age + "\n" +
                   "  <li><b>Employee id:</b>: "
                   + r.id + "\n" +
                "</ul>\n" +
             "</body>"+
          "</html>"
       );
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		com.dao.H2jdbcInsertDemo h2jdbcdelete=new H2jdbcInsertDemo();
		try {
			 r=h2jdbcdelete.fetch(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request.setAttribute("Name",);
		doGet(request, response);
	}

}
