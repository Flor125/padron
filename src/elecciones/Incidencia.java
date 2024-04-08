package elecciones;
import Clases.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Incidencia {

    public static void registrarIncidencia(String usr, String observacion) {

        try (Connection conexion = conectar.getConnection()) {
            String sql = "INSERT INTO incidencia (USUARIO, HORA, OBSERVACION) VALUES (?, NOW(), ?)";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, usr);
                preparedStatement.setString(2, observacion);
                int filasAfectadas = preparedStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Ingresaste al sistema.");
                } else {
                    System.err.println("Error al registrar la incidencia.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}

