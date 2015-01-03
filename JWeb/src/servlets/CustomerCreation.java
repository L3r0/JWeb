package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.DaoCustomer;
import beans.Customer;

public class CustomerCreation extends HttpServlet {

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/WEB-INF/createCustomer.jsp" ).forward( request, response );
		
	}
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	String message = null;
    	DaoCustomer daoCustomer = new DaoCustomer();
    	Customer customer = new Customer();
    	
        customer.setName(request.getParameter("customerName"));
        customer.setFirstName(request.getParameter("customerFirstName"));
        customer.setAdress(request.getParameter("customerAdress"));
        customer.setPhone(request.getParameter("customerPhone"));
        customer.setMail(request.getParameter("customerMail"));
        daoCustomer.addCustomer(customer);
        
        if ( customer.getName().trim().isEmpty() || customer.getFirstName().trim().isEmpty() || customer.getAdress().trim().isEmpty() || customer.getPhone().trim().isEmpty() || customer.getMail().trim().isEmpty()) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
        } else {
            message = "Customer cr�� avec succ�s !";
        }
        
        request.setAttribute("message", message);
        
        this.getServletContext().getRequestDispatcher( "/WEB-INF/displayCustomer.jsp" ).forward( request, response );
    }
}