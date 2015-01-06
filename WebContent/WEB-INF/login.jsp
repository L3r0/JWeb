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
            <form method="post" action="LogIn">
                <fieldset>
                    <legend>Informations client</legend>
    
                    <label for="customerNickName">Pseudo<span class="requis">*</span></label>
                    <input type="text" id="customerNickName" name="customerNickName" value="" size="20" maxlength="20" />
                    <br />
                        
                    <label for="customerPassword">Mot de passe<span class="requis">*</span></label>
                    <input type="text" id="customerPassword" name="customerPassword" value="" size="20" maxlength="20" />
                    <br />
                        
                    <br />
                </fieldset>
                <input type="submit" value="Log In"  />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>