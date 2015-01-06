package servlets;

import dataAccessObject.DaoCustomer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminDisplayCustomerList extends HttpServlet {

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	DaoCustomer daoCustomer = new DaoCustomer();
        request.setAttribute("customers", daoCustomer.getAllCustomers());
        
        this.getServletContext().getRequestDispatcher( "/WEB-INF/adminDisplayCustomer.jsp" ).forward( request, response );
    }
}