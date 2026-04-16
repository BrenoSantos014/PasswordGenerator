import javax.swing.*;
import java.awt.*;



public class HistoryPage extends JFrame {

    public HistoryPage() {
        setTitle("Counts");
        //tamanho da GUI
        setSize(580,670);
        //previne que a GUI abra outras guias quando recarrega
        setResizable(false);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //center the GUi to the screen
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Counts");
        // increase the font size it bold
        titleLabel.setFont((new Font("Dialog", Font.BOLD,32)));

        //center the text to the screen
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x,y coordinates and width/height values
        titleLabel.setBounds(0,10,540,39);
;
        // add  to GUi
        add(titleLabel);

        setVisible(true);

        JLabel titleLabel2 = new JLabel("Coming soon...");
        // increase the font size it bold
        titleLabel2.setFont((new Font("Dialog", Font.BOLD, 32)));
        titleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel2.setBounds(0,150,540,39);
        add(titleLabel2);
        // history button
        JToggleButton passwordGeneratorGUIToggle = new JToggleButton("Password");
        passwordGeneratorGUIToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        passwordGeneratorGUIToggle.setBounds(25,90,225,56);
        passwordGeneratorGUIToggle.addActionListener(e -> {
            new PasswordGeneratorGUI(); // abre a outra página
            dispose();// fecha a atual
        });
        add(passwordGeneratorGUIToggle);
        setVisible(true);
    }
}

