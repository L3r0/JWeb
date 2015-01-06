package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccessObject.DaoCustomer;
import beans.Customer;
import beans.Cart;

@SuppressWarnings("serial")
public class LogIn extends HttpServlet {

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        this.getServletContext().getRequestDispatcher( "/WEB-INF/login.jsp" ).forward( request, response );
	    }

	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        String message = null;
	    	DaoCustomer daoCustomer = new DaoCustomer();
	    	Customer customer = null;
	    	Cart cart = new Cart();
	    	
	    	customer = daoCustomer.getCustomer(request.getParameter("customerNickName"), request.getParameter("customerPassword"));
	        
	        if (customer.getNickName() == null) {
	            message = "Erreur - Pseudo ou mot de passe incorrect.";
	            request.setAttribute("message", message);
	            this.getServletContext().getRequestDispatcher( "/WEB-INF/displayInfo.jsp" ).forward( request, response );
	            return;
	        } else {
	            message = "Vous êtes connecté.";
	            request.setAttribute("message", message);
	            session.setAttribute("cart", cart);
	            session.setAttribute( "userSession", customer );
	            
	        if ( customer.getNickName().equals("admin") && customer.getPassword().equals("admin"))
	        	this.getServletContext().getRequestDispatcher( "/WEB-INF/adminHome.jsp" ).forward( request, response );
	        else
	        	this.getServletContext().getRequestDispatcher( "/WEB-INF/displayInfo.jsp" ).forward( request, response );
	        }
	    }
}
