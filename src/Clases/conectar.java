package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3308/padron";

    //Constructor establece la conexión.
    public conectar() throws SQLException {
        conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                 System.out.println("Conexion establecida..");
                
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error al conectar"+ e);
        }
    }
    // este metodo nos retorna la conexion
    public static Connection getConnection() {
        Connection conexion = null;

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        return conexion;
    }
    
    //con este metodo nos desconectamos de la base de datos
    public static void cerrarConexion() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}