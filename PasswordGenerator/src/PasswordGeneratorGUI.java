//Frontend

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
public class PasswordGeneratorGUI extends JFrame {
private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
       //titulo
        super("Password Generator");
    //tamanho da GUI
    setSize(540,570);
    //previne que a GUI abra outras guias quando recarrega
    setResizable(false);
    
    setLayout(null);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    //center the GUi to the screen
    setLocationRelativeTo(null);
    
    // int password generator
    passwordGenerator = new PasswordGenerator();

    //render GUI components
    addGUIComponents();
    }
    private void addGUIComponents(){
        // create title text
        JLabel titleLabel = new JLabel("Password Generator");
        // increase the font size it bold
        titleLabel.setFont((new Font("Dialog", Font.BOLD,32)));

        //center the text to the screen 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x,y coordinates and width/height values
        titleLabel.setBounds(0,10,540,39);

        // add  to GUi
        add(titleLabel);

        //create result text area
        JTextArea passwordOutput = new JTextArea();

        // prevent editing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

        // add scrollability in case output becomes too big
        JScrollPane passwordOutPane = new JScrollPane(passwordOutput);
        passwordOutPane.setBounds(25,97,479,78);

        //creat a black border around the text area
        passwordOutPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutPane);

        //create password length label
        JLabel passwordLengthJLabel = new JLabel("Password Length:");
        passwordLengthJLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthJLabel.setBounds(25,215,272,39);
        add(passwordLengthJLabel);

        // create password length input
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);

        //create toggle buttons
        //uppercase letter toggle
        JToggleButton uppercaseToggle = new JToggleButton("UpperCase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        //lowercase letter toggle
        JToggleButton lowercaseToggle = new JToggleButton("LowerCase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        lowercaseToggle.setBounds(282,302, 225, 56);
        add(lowercaseToggle);

        // numbers toggle
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        // symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        symbolsToggle.setBounds(282,373,225,56);
        add(symbolsToggle);

        //crate generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN,26));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                //validation: generate a password only when length > 0 and one of the toggled buttons is pressed
                if(passwordLengthInputArea.getText().length() <=0) return; 
                boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                uppercaseToggle.isSelected() ||
                numbersToggle.isSelected() ||
                symbolsToggle.isSelected();

                //generate password
                //converts the text to an integer value
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(anyToggleSelected){
                    String generatedPassoword = passwordGenerator.generatePassword(passwordLength, 
                    anyToggleSelected, 
                    anyToggleSelected, 
                    anyToggleSelected, 
                    anyToggleSelected);

                //display password back to the user
                passwordOutput.setText(generatedPassoword);
                }
            }
        });
        add(generateButton);
    }

}
