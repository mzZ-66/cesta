/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author pablo
 */
public class ConexionBD {
    private static Connection conexion = null;
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cesta", "root", "");
        }
        return conexion;
    }
}
