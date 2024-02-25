/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class OperacionesAlimento {
    private Connection conexion;

    public OperacionesAlimento() throws SQLException, ClassNotFoundException {
        conexion = ConexionBD.getConexion();
    }
    
    public List<Alimento> obtenerTodosLosAlimentos() throws SQLException {
        List<Alimento> alimentos = new ArrayList<>();
        String query = "SELECT * FROM alimento";
        PreparedStatement statement = conexion.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int codigo = resultSet.getInt("codigo");
            String marca = resultSet.getString("marca");
            String descripcion = resultSet.getString("descripcion");
            float precio = resultSet.getFloat("precio");
            String tipo = resultSet.getString("tipo");

            Alimento alimento;
            switch (tipo) {
                case "DIETETICO":
                    int nCalorias = resultSet.getInt("nCalorias");
                    alimento = new Dietetico(codigo, marca, descripcion, precio, nCalorias);
                    break;
                case "ECOLOGICO":
                    String lugarProcedencia = resultSet.getString("lugarProcedencia");
                    alimento = new Ecologico(codigo, marca, descripcion, precio, lugarProcedencia);
                    break;
                default:
                    alimento = new Alimento(codigo, marca, descripcion, precio);
                    break;
            }

            alimentos.add(alimento);
        }

        // Cerrar recursos
        resultSet.close();
        statement.close();

        return alimentos;
    }
    
//    public void test() throws SQLException {
//        String query = "INSERT INTO alimento (codigo, marca, descripcion, precio) VALUES (1, 'MarcaA', 'DescripciónA', 10.50)";
//        conexion.createStatement().executeUpdate(query);
//    }
    
//    public void ejemploConsultaPreparada(int idUsuario, String nombreUsuario) throws SQLException {
//        String query = "SELECT * FROM usuarios WHERE id = ? AND nombre = ?";
//        PreparedStatement statement = conexion.prepareStatement(query);
//
//        // Estableciendo los valores de los parámetros
//        statement.setInt(1, idUsuario); // Primer parámetro es un int
//        statement.setString(2, nombreUsuario); // Segundo parámetro es un String
//
//        ResultSet resultSet = statement.executeQuery();
//
//        while (resultSet.next()) {
//            // Aquí puedes obtener los datos del usuario y procesarlos
//            int id = resultSet.getInt("id");
//            String nombre = resultSet.getString("nombre");
//            // Otros campos...
//            
//            // Puedes imprimir los datos o hacer lo que necesites con ellos
//            System.out.println("ID: " + id + ", Nombre: " + nombre);
//        }
//        
//        // Cerrar recursos
//        resultSet.close();
//        statement.close();
//    }

}
