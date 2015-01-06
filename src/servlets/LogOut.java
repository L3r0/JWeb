package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends HttpServlet {

	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        String message = null;
	        
	        message = "Vous vous êtes déconnecté.";
	    	
	        session.invalidate();
	        request.setAttribute("message", message);

	        this.getServletContext().getRequestDispatcher( "/WEB-INF/displayInfo.jsp" ).forward( request, response );
	        }
}
