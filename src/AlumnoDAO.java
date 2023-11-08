import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Alumno> obtenerTodosLosAlumnos() {
        List<Alumno> listaDeAlumnos = new ArrayList<>();

        String query = "SELECT * FROM alumnos";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Alumno alumno = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidoPaterno"),
                        rs.getString("apellidoMaterno"),
                        rs.getInt("edad"),
                        rs.getString("genero")
                );
                listaDeAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDeAlumnos;
    }

    public void eliminarAlumnnoPorId(int id){
        String query = "DELETE FROM alumnos WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void actualizarAlumno(Alumno alumno){
        String query = "UPDATE alumnos SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, edad = ?, genero = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();

             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellidoPaterno());
            stmt.setString(3, alumno.getApellidoMaterno());
            stmt.setInt(4, alumno.getEdad());
            stmt.setString(5, alumno.getGenero());
            stmt.setInt(6, alumno.getId());

            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }


    }

}
