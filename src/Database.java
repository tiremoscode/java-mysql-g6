import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Database {

    private static final String urlServer = "jdbc:mysql://localhost:3306/crud_alumnos_g6";
    private static final String userServer = "user";
    private static final String passwordServer = "password";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(urlServer, userServer, passwordServer);
    }

}
