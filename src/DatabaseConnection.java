import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/history_data_base";
    private static final String usename = "root";
    private static final String user_password = "1403";

    public static Connection getConnection() {
        try {

            Connection connection = DriverManager.getConnection(url, usename, user_password);

            System.out.println("Conectado com sucesso!");
            return connection;

        } catch (Exception e) {

            System.out.println("Erro ao conectar:");
            e.printStackTrace();
            return null;
        }
    }
}
