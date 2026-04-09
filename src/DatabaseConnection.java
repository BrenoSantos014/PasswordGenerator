import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/history_data_base";
    private static final String USER = "root";
    private static final String PASSWORD = "1403";

    public static Connection getConnection() {
        try {

            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conectado com sucesso!");
            return connection;

        } catch (Exception e) {

            System.out.println("Erro ao conectar:");
            e.printStackTrace();
            return null;

        }
    }
}
