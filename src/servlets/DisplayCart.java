package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cart;

@SuppressWarnings("serial")
public class DisplayCart extends HttpServlet {

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	    	Cart cart = new Cart();
	        String message = null;

	    	cart = (Cart) session.getAttribute("cart");
	    	if ( cart == null) {
	            message = "Votre panier est vide.";
	            request.setAttribute("message", message);
	            this.getServletContext().getRequestDispatcher( "/WEB-INF/displayInfo.jsp" ).forward( request, response );
	    	} else {
		        request.setAttribute("cart", cart);
	    		this.getServletContext().getRequestDispatcher( "/WEB-INF/displayCart.jsp" ).forward( request, response );
	    	}
	  }
}
