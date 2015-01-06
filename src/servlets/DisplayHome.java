package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Customer;
import dataAccessObject.DaoNews;
import dataAccessObject.DaoProduct;

@SuppressWarnings("serial")
public class DisplayHome extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	Customer customer = new Customer();
    	DaoNews daoNews = new DaoNews();
    	DaoProduct daoProduct = new DaoProduct();
    	HttpSession session = request.getSession();
    	
    	customer = (Customer) session.getAttribute( "userSession" );
    	
        request.setAttribute( "news", daoNews.getAllNews());
        request.setAttribute( "products", daoProduct.getAllProduct());
        if (customer != null)
        	request.setAttribute( "currentUser", customer.getNickName());
      
        this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );
    }
}