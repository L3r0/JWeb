<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Home</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
		<input type="button" value="Admin Homepage" onclick="window.location.reload()" />
		<input type="button" value="Product Creation" onclick="location.href='AdminProductCreation'" />
		<input type="button" value="News Creation" onclick="location.href='AdminNewsCreation'" />
		<input type="button" value="Customer List" onclick="location.href='AdminDisplayCustomerList'" />
		<input type="button" value="Logout" onclick="location.href='LogOut'" />
    </body>
</html>