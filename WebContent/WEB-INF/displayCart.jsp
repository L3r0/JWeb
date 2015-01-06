<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Panier</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <h1>Panier</h1>

    <table border=1>
        <thead>
            <tr>
                <th>Panier</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cart['cart']}" var="cart">
                <tr>
                    <td><c:out value="${cart}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>