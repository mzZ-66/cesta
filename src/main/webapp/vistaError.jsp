<%-- 
    Document   : vistaError
    Created on : 16 feb 2024, 17:21:17
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Error</h1>
        <p><%= session.getAttribute("mensajeError") %></p>
        <form action="index.jsp">
            <input type="submit" value="Volver al inicio">
        </form>
    </body>
</html>
