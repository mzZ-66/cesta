<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 28/02/2024
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="Modelo.*" %>
<%@ page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resumen de compra</title>
</head>
<body>
<h2>Resumen de compra</h2>
<%
    List<Alimento> alimentos = (List<Alimento>) session.getAttribute("alimentos");
    Map<Integer, Integer> carrito = (Map<Integer, Integer>) session.getAttribute("carrito");

    Map<Integer, Integer> listaNormales = new HashMap<>();
    Map<Integer, Integer> listaDieteticos = new HashMap<>();
    Map<Integer, Integer> listaEcologicos = new HashMap<>();
    float totalCarrito = 0;
    if (carrito != null && !carrito.isEmpty() && alimentos != null) {
        for (Map.Entry<Integer, Integer> entry : carrito.entrySet()) {
            Integer codigoItem = entry.getKey();
            Integer cantidad = entry.getValue();

            for (Alimento alimento : alimentos) {
                if (alimento.getCodigo() == codigoItem) {
                    if (alimento.getTipo() == Alimento.Tipo.DIETETICO) {
                        listaDieteticos.put(codigoItem, cantidad);
                    } else if (alimento.getTipo() == Alimento.Tipo.ECOLOGICO) {
                        listaEcologicos.put(codigoItem, cantidad);
                    } else if (alimento.getTipo() == Alimento.Tipo.NORMAL) {
                        listaNormales.put(codigoItem, cantidad);
                    }
                    totalCarrito += cantidad * alimento.getPrecio();
                }
            }
        }
    }

    float totalNormales = 0;
    float totalDieteticos = 0;
    float totalEcologicos = 0;
    if (!listaNormales.isEmpty()) { %>
<h3>Alimentos Normales</h3>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Cantidad</th>
    </tr>
    <% for (Map.Entry<Integer, Integer> entry : listaNormales.entrySet()) {
        Integer codigoItem = entry.getKey();
        Integer cantidad = entry.getValue();
        for (Alimento alimento : alimentos) {
            if (alimento.getCodigo() == codigoItem) {
                totalNormales += cantidad * alimento.getPrecio();
    %>
    <tr>
        <td><%= alimento.getMarca() %> - <%= alimento.getDescripcion() %></td>
        <td><%= cantidad %></td>
    </tr>
    <%      }
    }
    } %>
</table>
<p>Total Normales: <%= totalNormales %> €</p>
<% } %>

<% if (!listaDieteticos.isEmpty()) { %>
<h3>Alimentos Dietéticos</h3>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Cantidad</th>
    </tr>
    <% for (Map.Entry<Integer, Integer> entry : listaDieteticos.entrySet()) {
        Integer codigoItem = entry.getKey();
        Integer cantidad = entry.getValue();
        for (Alimento alimento : alimentos) {
            if (alimento.getCodigo() == codigoItem) {
                totalDieteticos += cantidad * alimento.getPrecio();
    %>
    <tr>
        <td><%= alimento.getMarca() %> - <%= alimento.getDescripcion() %></td>
        <td><%= cantidad %></td>
    </tr>
    <%      }
    }
    } %>
</table>
<p>Total Dietéticos: <%= totalDieteticos %> €</p>
<% } %>

<% if (!listaEcologicos.isEmpty()) { %>
<h3>Alimentos Ecológicos</h3>
<table border="1">
    <tr>
        <th>Nombre</th>
        <th>Cantidad</th>
    </tr>
    <% for (Map.Entry<Integer, Integer> entry : listaEcologicos.entrySet()) {
        Integer codigoItem = entry.getKey();
        Integer cantidad = entry.getValue();
        for (Alimento alimento : alimentos) {
            if (alimento.getCodigo() == codigoItem) {
                totalEcologicos += cantidad * alimento.getPrecio();
    %>
    <tr>
        <td><%= alimento.getMarca() %> - <%= alimento.getDescripcion() %></td>
        <td><%= cantidad %></td>
    </tr>
    <%      }
    }
    } %>
</table>
<p>Total Ecológicos: <%= totalEcologicos %> €</p>
<% }
    // esto es para testear
    System.out.println("Total Normales:" + totalNormales);
    System.out.println("Total Dieteticos:" + totalDieteticos);
    System.out.println("Total Ecologicos:" + totalEcologicos);
%>

</body>
</html>
