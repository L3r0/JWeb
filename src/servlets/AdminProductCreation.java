package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.DaoProduct;
import beans.Product;

@SuppressWarnings("serial")
public class AdminProductCreation extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/adminCreateProduct.jsp" ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	String message = null;
    	DaoProduct daoProduct = new DaoProduct();
    	Product product = new Product();
    	
        product.setName(request.getParameter("productName"));
        product.setDescription(request.getParameter("productDescription"));
        product.setPrice(request.getParameter("productPrice"));
        daoProduct.addProduct(product);
        
        if ( product.getName().trim().isEmpty() || product.getDescription().trim().isEmpty() || product.getPrice().trim().isEmpty()) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
        } else {
            message = "Produit créé avec succès !";
        }
        
        request.setAttribute("message", message);
        
        this.getServletContext().getRequestDispatcher( "/WEB-INF/displayInfo.jsp" ).forward( request, response );
    }
}