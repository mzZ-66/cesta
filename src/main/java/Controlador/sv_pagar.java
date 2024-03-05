package Controlador;

import DAO.OperacionesAlimento;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "sv_pagar", value = "/sv_pagar")
public class sv_pagar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // esta es la lista de los elementos comprados y sus cantidades que se pide en el ej. 3, ya la tenía hecha desde antes
        Map<Integer, Integer> carrito = (Map<Integer, Integer>) request.getSession().getAttribute("carrito");
        try {
            OperacionesAlimento operacionesAlimento = new OperacionesAlimento();

            // al pagar, tengo que reducir el stock de los alimentos que se compran
            for (Map.Entry<Integer, Integer> entry : carrito.entrySet()) {
                Integer codigoItem = entry.getKey();
                Integer cantidad = entry.getValue();
                operacionesAlimento.reducirStock(codigoItem, cantidad);
            }
            response.sendRedirect("vistaPagoRealizado.jsp");
        } catch (Exception e) {
            request.getSession().setAttribute("mensajeError", e.getMessage());
            response.sendRedirect("vistaError.jsp");
        }
    }
}