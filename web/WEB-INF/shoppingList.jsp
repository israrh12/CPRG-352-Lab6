

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <h4>Hello, ${username}</h4>
        <a href="ShoppingList?action=logout">Logout</a>
        <form method="POST" action="">
            <h3>Add an Item</h3>
            <input type="text" name="item">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add Item">
        </form>
        <form method="POST" action="">
            <ol>
                <c:forEach var="item" items="${items}">
                    <li><input type="radio"  name="item" value="${item}">${item}</li>
                </c:forEach>
            </ol>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
