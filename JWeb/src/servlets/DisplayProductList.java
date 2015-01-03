package servlets;

import dataAccessObject.DaoProduct;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayProductList extends HttpServlet {

    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	DaoProduct daoProduct = new DaoProduct();
        request.setAttribute("products", daoProduct.getAllProduct());
        
        this.getServletContext().getRequestDispatcher( "/WEB-INF/displayProductList.jsp" ).forward( request, response );
    }
}