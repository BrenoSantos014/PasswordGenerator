import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Account {
            public void insert(String fieldName, String fieldPassword) {
        String url = "jdbc:mysql://localhost:3306/history_data_base";
        String username = "root";
        String user_password = "1403";

        try {
            Connection conn = DriverManager.getConnection(url, username, user_password);

            String sql = "INSERT INTO history (username, user_password) VALUES (?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, fieldName);
            stmt.setString(2, fieldPassword);

            stmt.executeUpdate();

            System.out.println("Usuário salvo no banco!");


            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}