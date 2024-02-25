/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Excepciones.*;
import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pablo
 */
public class sv_anadirAlCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sv_anadirAlCarrito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sv_anadirAlCarrito at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        int codigoItemSeleccionado = Integer.parseInt(request.getParameter("itemSeleccionado"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        Map<Integer, Integer> carrito = (Map<Integer, Integer>) request.getSession().getAttribute("carrito");
        List<Alimento> alimentos = (List<Alimento>) request.getSession().getAttribute("alimentos");

        if (carrito == null) {
            carrito = new HashMap<>();
            request.getSession().setAttribute("carrito", carrito);
        }

        if (carrito.containsKey(codigoItemSeleccionado)) {
            cantidad += carrito.get(codigoItemSeleccionado);
        }

        carrito.put(codigoItemSeleccionado, cantidad);

        // calculo el total del carrito
        float totalCarrito = 0;
        for (Map.Entry<Integer, Integer> entry : carrito.entrySet()) {
            int codigo = entry.getKey();
            int cantidadItem = entry.getValue();
            for (Alimento alimento : alimentos) {
                if (alimento.getCodigo() == codigo) {
                    totalCarrito += alimento.getPrecio() * cantidadItem;
                    break; // Salir del bucle interno después de encontrar el elemento
                }
            }
        }
        
    Integer limiteGastoObj = (Integer) request.getSession().getAttribute("limiteGasto");
    int limiteGasto = (limiteGastoObj != null) ? limiteGastoObj : 0;

        try {
            if (totalCarrito > limiteGasto) {
                throw new ExcepcionLimiteGastoSuperado("El total del carrito supera el límite de gasto establecido.");
            }
            response.sendRedirect("carrito.jsp");
        } catch (ExcepcionLimiteGastoSuperado e) {
            request.getSession().setAttribute("mensajeError", e.getMessage());
            response.sendRedirect("vistaError.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
