import java.sql.Connection;
import java.sql.*;
public class AlumnoDAO {

    public void insertarAlumno (Alumno alumno){
        String query = "INSERT INTO alumnos (nombre, apellidoPaterno, apellidoMaterno, edad, genero) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();

             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellidoPaterno());
            stmt.setString(3, alumno.getApellidoMaterno());
            stmt.setInt(4, alumno.getEdad());
            stmt.setString(5, alumno.getGenero());

            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

}
