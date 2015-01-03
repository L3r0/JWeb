<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Customers List</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>Name</th>
                <th>FirstName</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Mail</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td><c:out value="${customer.id}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.firstName}" /></td>
                    <td><c:out value="${customer.adress}" /></td>
                    <td><c:out value="${customer.phone}" /></td>
                    <td><c:out value="${customer.mail}" /></td>
                    <td><a href="AdminUpdateCustomer?id=<c:out value="${customer.id}"/>">Update</a></td>
                    <td><a href="AdminDeleteCustomer?id=<c:out value="${customer.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>