package com.servlet;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.H2jdbcInsertDemo;
@WebServlet("/guru-regis")
public class Guru_register extends HttpServlet {
	
	/**
	 *  Servlet implementation class guru_register
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String first_name =request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		int age=Integer.parseInt(request.getParameter("age"));
		int id=Integer.parseInt(request.getParameter("id"));
		com.dao.H2jdbcInsertDemo h2jdbcInsert=new H2jdbcInsertDemo();

		h2jdbcInsert.insert(id, first_name, last_name, age);
		
		
				if(first_name.isEmpty()||last_name.isEmpty())
				{
				
				RequestDispatcher req=request.getRequestDispatcher("register.jsp");
				req.include(request, response);
		}
				else
				{
					RequestDispatcher req=request.getRequestDispatcher("register2.jsp");
					req.forward(request,response);
				}
				
				

	}
}
