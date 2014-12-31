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
            <form method="get" action="AdminNewsCreation">
                <fieldset>
                    <legend>Creation d'un produit</legend>
    
                    <label for="newsName">Titre de la news <span class="requis">*</span></label>
                    <input type="text" id="newsName" name="newsName" value="" size="20" maxlength="20" />
                    <br />
                    
                    <label for="newsContent">Content <span class="requis">*</span></label>
                    <input type="text" id="newsContent" name="newsContent" value="" size="20" maxlength="20" />
                    <br />
    
                </fieldset>
                <input type="submit" value="Valider"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>