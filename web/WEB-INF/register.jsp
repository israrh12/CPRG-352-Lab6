

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="POST" action="ShoppingList">
            <input type="text" name="userName">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register Name">
        </form>
    </body>
</html>
