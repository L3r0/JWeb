package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.DaoProduct;
import beans.Product;

public class AdminProductCreation extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
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
            message = "Produit cr�� avec succ�s !";
        }
        
        request.setAttribute("message", message);
        
        this.getServletContext().getRequestDispatcher( "/adminDisplayProduct.jsp" ).forward( request, response );
    }
}