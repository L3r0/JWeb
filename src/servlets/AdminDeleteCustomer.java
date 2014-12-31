package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.DaoCustomer;

public class AdminDeleteCustomer extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	DaoCustomer daoCustomer = new DaoCustomer();
    	int id = Integer.parseInt(request.getParameter( "id" ));

    	daoCustomer.deleteCustomer(id);
	}
}