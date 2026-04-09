import javax.swing.*;
import java.awt.*;

public class HistoryPage extends JFrame {

    public HistoryPage() {
        setTitle("Segunda Página");
        //tamanho da GUI
        setSize(580,670);
        //previne que a GUI abra outras guias quando recarrega
        setResizable(false);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //center the GUi to the screen
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Você está na segunda página!", JLabel.CENTER);
        add(label);

        setVisible(true);

        // history button
        JToggleButton PasswordGeneratorGUIToggle = new JToggleButton("Password");
        PasswordGeneratorGUIToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        PasswordGeneratorGUIToggle.setBounds(25,90,225,56);
        PasswordGeneratorGUIToggle.addActionListener(e -> {
            new PasswordGeneratorGUI(); // abre a outra página
            dispose();// fecha a atual
        });
        add(PasswordGeneratorGUIToggle);
    }
}

