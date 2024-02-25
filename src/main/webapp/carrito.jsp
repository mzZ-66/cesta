<%-- 
    Document   : carrito
    Created on : 16 feb 2024, 15:57:50
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="Modelo.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tu carrito</title>
    </head>
    <body>
        <h2>Carrito de Compras</h2>
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Marca</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Subtotal</th>
            </tr>
            <%
                List<Alimento> alimentos = (List<Alimento>) session.getAttribute("alimentos");
                Map<Integer, Integer> carrito = (Map<Integer, Integer>) session.getAttribute("carrito");

                if (carrito != null && !carrito.isEmpty() && alimentos != null) {
                    for (Map.Entry<Integer, Integer> entry : carrito.entrySet()) {
                        Integer codigoItem = entry.getKey();
                        Integer cantidad = entry.getValue();

                        for (Alimento alimento : alimentos) {
                            if (alimento.getCodigo() == codigoItem) {
            %>
                                <tr>
                                    <td><%= alimento.getCodigo() %></td>
                                    <td><%= alimento.getMarca() %></td>
                                    <td><%= alimento.getDescripcion() %></td>
                                    <td><%= alimento.getPrecio() %></td>
                                    <td><%= cantidad %></td>
                                    <td><%= cantidad * alimento.getPrecio() %></td>
                                </tr>
            <%
                                break; // Salir del bucle interior después de encontrar el elemento
                            }
                        }
                    }
                } else {
            %>
                    <tr>
                        <td colspan="5">El carrito está vacío</td>
                    </tr>
            <%
                }
            %>
        </table><br>
        
        <form action="vista.jsp">
            <input type="submit" value="Volver">
        </form><br>
        
        <form action="">
            <input type="submit" value="Pagar">
        </form>
        
        

    </body>
</html>
