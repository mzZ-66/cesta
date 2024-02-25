<%-- 
    Document   : vista
    Created on : 16 feb 2024, 14:08:08
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de alimentos</title>
    </head>
    <body>
        <div class="container">
            <h2>Lista de Alimentos</h2>
            <table border="1">
                <tr>
                    <th>Código</th>
                    <th>Marca</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Tipo</th>
                    <th>Detalles Extra</th>
                </tr>
                <% 
                    List<Alimento> alimentos = (List<Alimento>) session.getAttribute("alimentos");
                    if (alimentos != null) {
                        for (Alimento alimento : alimentos) {
                            %>
                            <tr>
                                <td><%= alimento.getCodigo() %></td>
                                <td><%= alimento.getMarca() %></td>
                                <td><%= alimento.getDescripcion() %></td>
                                <td><%= alimento.getPrecio() + " €"%></td>
                                <td><%= alimento.getClass().getSimpleName() %></td>
                                <td><% 
                                    if (alimento instanceof Dietetico) {
                                        Dietetico dietetico = (Dietetico) alimento;
                                        out.print("Calorías: " + dietetico.getNCalorias() + " kcal");
                                    } else if (alimento instanceof Ecologico) {
                                        Ecologico ecologico = (Ecologico) alimento;
                                        out.print("Procedencia: " + ecologico.getLugarProcedencia());
                                    } else {
                                        out.print("-");
                                    }
                                %></td>
                            </tr>
                            <%
                        }
                    } else {
                        out.print("<tr><td colspan='6'>No hay alimentos disponibles.</td></tr>");
                    }
                %>
            </table>
            
            <% 
                Integer limiteGasto = (Integer) session.getAttribute("limiteGasto");
                if (limiteGasto == null) {
                    limiteGasto = 0;
                }
            %>
            <h3>Límite actual: <%= limiteGasto %> €</h3>
            
            <form action="sv_anadirAlCarrito" method="post">
                <h4 style="margin-bottom: 0;">Selecciona un producto para agregarlo al carrito:</h4>
                <select name="itemSeleccionado">
                    <option value="" disabled selected>Selecciona un producto</option>
                    <%
                        for (Alimento alimento : alimentos) {
                        %> <option value="<%= alimento.getCodigo() %>"><%= alimento.getMarca() %> - <%= alimento.getDescripcion() %></option><%
                        }
                    %>
                </select>
                <input type="number" name="cantidad" placeholder="Cantidad" required>
                <input type="submit" name="anadirAlCarrito" value="Añadir al carrito">
            </form><br>
            <form action="index.jsp">
                <input type="submit" value="Volver al inicio">
            </form>
        </div>
    </body>
</html>
