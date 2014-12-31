<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Customer creation</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <div>
            <form method="get" action="customerCreation">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="customerName">Nom<span class="requis">*</span></label>
                    <input type="text" id="customerName" name="customerName" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="customerFirstName">Prénom<span class="requis">*</span></label>
                    <input type="text" id="customerFirstName" name="customerFirstName" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="customerAdress">Adresse de livraison<span class="requis">*</span></label>
                    <input type="text" id="customerAdress" name="customerAdress" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="customerPhone">Numéro de téléphone<span class="requis">*</span></label>
                    <input type="text" id="customerPhone" name="customerPhone" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="customerMail">Adresse email<span class="requis">*</span></label>
                    <input type="email" id="customerMail" name="customerMail" value="" size="20" maxlength="60" />
                    <br />
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>