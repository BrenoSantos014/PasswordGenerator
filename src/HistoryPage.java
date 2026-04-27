import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryPage extends JFrame {
    private JTable titleJTable;
    private DefaultTableModel model;

    public HistoryPage() {
        setTitle("Counts");
        setSize(580, 670);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tittle page
        JLabel titleLabel = new JLabel("Counts");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 540, 39);
        add(titleLabel);

        // Botton back
        JToggleButton passwordGeneratorGUIToggle = new JToggleButton("Password");
        passwordGeneratorGUIToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        passwordGeneratorGUIToggle.setBounds(25, 80, 225, 56);
        passwordGeneratorGUIToggle.addActionListener(e -> {
            new PasswordGeneratorGUI().setVisible(true);
            dispose();
        });
        add(passwordGeneratorGUIToggle);

        // Config the table
        String[] colun = {"ID", "Title", "Password"};
        model = new DefaultTableModel(colun, 0);

        titleJTable = new JTable(model);
        titleJTable.setRowHeight(25);
        titleJTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // the scroll line (JScrollPane)
        JScrollPane scrollPane = new JScrollPane(titleJTable);
        // Posicionado abaixo do botão
        scrollPane.setBounds(25, 160, 510, 430);
        add(scrollPane);

        // Charge a bank
        carregarDadosDoBanco();

        setVisible(true);
    }

    public void carregarDadosDoBanco() {
        model.setNumRows(0); // Limpa a tabela antes de preencher

        //The elements implanted on table
        String sql = "SELECT id, username, user_password FROM history";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (conn == null) return;

            while (rs.next()) {
                // get elements in the bank
                model.addRow(new Object[]{
                        rs.getInt("id"),                 //Get id
                        rs.getString("username"),       // Get username
                        rs.getString("user_password")   // Get user_password
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
