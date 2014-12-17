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
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String name = request.getParameter( "customerName" );
        String firstName = request.getParameter( "customerFirstName" );
        String adress = request.getParameter( "customerAdress" );
        String phone = request.getParameter( "customerPhone" );
        String mail = request.getParameter( "customerMail" );

        String message;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( name.trim().isEmpty() || adress.trim().isEmpty() || phone.trim().isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"createCustomer.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
        } else {
            message = "Client créé avec succès !";
        }
        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        Customer customer = new Customer();
        customer.setName( name );
        customer.setFirstName( firstName );
        customer.setAdress( adress );
        customer.setPhone( phone );
        customer.setMail( mail );

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( "customer", customer );
        request.setAttribute( "message", message );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( "/displayCustomer.jsp" ).forward( request, response );
    }
}