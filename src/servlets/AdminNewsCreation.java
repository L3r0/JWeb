package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataAccessObject.DaoNews;
import beans.News;

public class AdminNewsCreation extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	String message = null;
    	DaoNews daoNews = new DaoNews();
    	News news = new News();
    	
        news.setName(request.getParameter("newsName"));
        news.setContent(request.getParameter("newsContent"));
        daoNews.addNews(news);
        
        if ( news.getName().trim().isEmpty() || news.getContent().trim().isEmpty()) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
        } else {
            message = "News cr�� avec succ�s !";
        }
        
        request.setAttribute("message", message);
        
        this.getServletContext().getRequestDispatcher( "/adminDisplayNews.jsp" ).forward( request, response );
    }
}