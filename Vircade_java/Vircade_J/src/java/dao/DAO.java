package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    public Connection conectar(){
        Connection con = null;
       
        try {
            // Registrar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
           
            // Cadena de conexion a la base de datos
            String url = "jdbc:mysql://localhost:3306/ProyectoConAutos";
            String user = "root";
            String password = "";
           
            // Establecer la conexion
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            // Manejo de error si el driver no se encuentra
            e.printStackTrace();
        } catch (SQLException e) {
            // Manejo de error si ocurre un problema con la conexion
            e.printStackTrace();
        }
        return con;
    }
}