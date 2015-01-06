package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.DaoCustomer;

@SuppressWarnings("serial")
public class AdminDeleteCustomer extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	DaoCustomer daoCustomer = new DaoCustomer();
    	int id = Integer.parseInt(request.getParameter( "id" ));

    	daoCustomer.deleteCustomer(id);
    	
    	request.setAttribute("customers", daoCustomer.getAllCustomers());
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/adminDisplayCustomer.jsp" ).forward( request, response );
	}
}