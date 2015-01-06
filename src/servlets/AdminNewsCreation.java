package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.DaoNews;
import beans.News;

@SuppressWarnings("serial")
public class AdminNewsCreation extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/adminCreateNews.jsp" ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	String message = null;
    	DaoNews daoNews = new DaoNews();
    	News news = new News();
    	
        news.setName(request.getParameter("newsName"));
        news.setContent(request.getParameter("newsContent"));
        daoNews.addNews(news);
        
        if ( news.getName().trim().isEmpty() || news.getContent().trim().isEmpty()) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
        } else {
            message = "News créé avec succès !";
        }
        
        request.setAttribute("message", message);
        
        this.getServletContext().getRequestDispatcher( "/WEB-INF/displayInfo.jsp" ).forward( request, response );
    }
}