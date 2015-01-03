package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.DaoNews;

public class DisplayNews extends HttpServlet {
    private List<String> news = new ArrayList<String>();

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	DaoNews daoNews = new DaoNews();
        request.setAttribute( "news", daoNews.getAllNews());
      
        this.getServletContext().getRequestDispatcher( "/home.jsp" ).forward( request, response );
    }
}