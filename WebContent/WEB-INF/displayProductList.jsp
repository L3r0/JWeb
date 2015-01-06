<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Product List</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
        <h1>Product List</h1>

    <table border=1>
        <thead>
            <tr>
                <th>News Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Prix</th>
                <th colspan=1>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="products">
                <tr>
                    <td><c:out value="${products.id}" /></td>
                    <td><c:out value="${products.name}" /></td>
                    <td><c:out value="${products.description}" /></td>
                    <td><c:out value="${products.price}" /></td>
                    <td><a href="AddToCart?name=<c:out value="${products.name}"/>">Add to cart</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>