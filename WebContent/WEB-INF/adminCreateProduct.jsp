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
            <form method="post" action="AdminProductCreation">
                <fieldset>
                    <legend>Creation d'un produit</legend>
    
                    <label for="productName">Nom du produit <span class="requis">*</span></label>
                    <input type="text" id="productName" name="productName" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="productDescription">Description <span class="requis">*</span></label>
                    <input type="text" id="productDescription" name="productDescription" value="" size="20" maxlength="20" />
                    <br />
    
                    <label for="productPrice">Prix <span class="requis">*</span></label>
                    <input type="text" id="productPrice" name="productPrice" value="" size="20" maxlength="20" />
                    <br />
    
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>