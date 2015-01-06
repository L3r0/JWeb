<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Home</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
		<input type="button" value="Home" onclick="location.href='Home'" />
		<input type="button" value="Product" onclick="location.href='DisplayProductList'" />
		<input type="button" value="Login" onclick="location.href='LogIn'" />
		<input type="button" value="Register" onclick="location.href='CustomerCreation'" />
		<input type="button" value="Cart" onclick="location.href='DisplayCart'" />
		<input type="button" value="Logout" onclick="location.href='LogOut'" />
	
	<c:out value="${currentUser}" />

		<h1>News</h1>

    <table border=1>
        <thead>
            <tr>
                <th>News Id</th>
                <th>Name</th>
                <th>Content</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${news}" var="news">
                <tr>
                    <td><c:out value="${news.id}" /></td>
                    <td><c:out value="${news.name}" /></td>
                    <td><c:out value="${news.content}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
        <h1>Product List</h1>

    <table border=1>
        <thead>
            <tr>
                <th>News Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Prix</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${products}" var="products">
                <tr>
                    <td><c:out value="${products.id}" /></td>
                    <td><c:out value="${products.name}" /></td>
                    <td><c:out value="${products.description}" /></td>
                    <td><c:out value="${products.price}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </body>
</html>