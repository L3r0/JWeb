package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataAccessObject.DaoProduct;
import beans.Cart;

public class AddToCart extends HttpServlet {

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        DaoProduct daoProduct = new DaoProduct();
	    	Cart cart = new Cart();
	        String message = null;

	    	cart = (Cart) session.getAttribute("cart");
	    	if ( cart == null) {
	            message = "Erreur - Vous devez vous connecter avant d'ajouter des produits à votre panier.";
		    	request.setAttribute("message", message);
		    	this.getServletContext().getRequestDispatcher( "/WEB-INF/displayInfo.jsp" ).forward( request, response );
	    	} else {
	    		cart.setValue(request.getParameter("name"), cart.getValue(request.getParameter("name")) + 1);
	    		session.setAttribute("cart", cart);
	    		request.setAttribute("products", daoProduct.getAllProduct());
		        this.getServletContext().getRequestDispatcher( "/WEB-INF/displayProductList.jsp" ).forward( request, response );
	    	}
	  }
}
