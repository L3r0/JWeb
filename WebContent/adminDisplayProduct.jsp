<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Product Created</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <p class="info">${ message }</p>
        <p>Name : ${ product.name }</p>
        <p>Description : ${ product.description }</p>
        <p>Price : ${ product.price }</p>
    </body>
</html>