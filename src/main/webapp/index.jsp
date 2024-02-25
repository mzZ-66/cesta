<%-- 
    Document   : index
    Created on : Feb 15, 2024, 10:29:53 AM
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cesta</title>
    </head>
    <body>
        <form action="sv_modificarLimiteGasto" method="post">
            <input type="number" name="limiteGasto" placeholder="Límite de gasto" required>
            <input type="submit" name="modificarLimiteGasto" value="Modificar límite de gasto">
        </form><br><br>
        <form action="sv_obtenerAlimentos" method="post">
            <input type="submit" name="obtenerAlimentos" value="Cargar lista de alimentos">
        </form>
    </body>
</html>
