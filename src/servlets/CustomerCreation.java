package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Customer;

public class CustomerCreation extends HttpServlet {

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /*
         * R�cup�ration des donn�es saisies, envoy�es en tant que param�tres de
         * la requ�te GET g�n�r�e � la validation du formulaire
         */
        String name = request.getParameter( "customerName" );
        String firstName = request.getParameter( "customerFirstName" );
        String adress = request.getParameter( "customerAdress" );
        String phone = request.getParameter( "customerPhone" );
        String mail = request.getParameter( "customerMail" );

        String message;
        /*
         * Initialisation du message � afficher : si un des champs obligatoires
         * du formulaire n'est pas renseign�, alors on affiche un message
         * d'erreur, sinon on affiche un message de succ�s
         */
        if ( name.trim().isEmpty() || adress.trim().isEmpty() || phone.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"createCustomer.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'un client.";
        } else {
            message = "Client cr�� avec succ�s !";
        }
        /*
         * Cr�ation du bean Client et initialisation avec les donn�es r�cup�r�es
         */
        Customer customer = new Customer();
        customer.setName( name );
        customer.setFirstName( firstName );
        customer.setAdress( adress );
        customer.setPhone( phone );
        customer.setMail( mail );

        /* Ajout du bean et du message � l'objet requ�te */
        request.setAttribute( "customer", customer );
        request.setAttribute( "message", message );

        /* Transmission � la page JSP en charge de l'affichage des donn�es */
        this.getServletContext().getRequestDispatcher( "/displayCustomer.jsp" ).forward( request, response );
    }
}