//Frontend

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
public class PasswordGeneratorGUI extends JFrame {
private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
       //titulo
        super("Password Generator");
    //tamanho da GUI
    setSize(580,670);
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

        // history button
        JToggleButton historyToggle = new JToggleButton("History");
        historyToggle.setFont(new Font("Dialog", Font.PLAIN,26));
        historyToggle.setBounds(25,90,225,56);
        historyToggle.addActionListener(e -> {
            new HistoryPage(); // abre a outra página
            dispose();// fecha a atual
        });
        add(historyToggle);

            //create email/username area
            JLabel nameLengthJLabel = new JLabel("Username/E-mail:");
            nameLengthJLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
            nameLengthJLabel.setBounds(25, 170, 272, 39);
            add(nameLengthJLabel);

            // create username/ E-mail length input
            JTextArea usernameLengthInputArea = new JTextArea();
            usernameLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
            usernameLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            usernameLengthInputArea.setBounds(280, 170, 192, 39);
            add(usernameLengthInputArea);

            // add scrollability in case output becomes too big (nt rum)
            // JScrollPane usernameOutPane = new JScrollPane(usernameLengthInputArea);
            // usernameLengthInputArea.setBounds(280,55,479,78);

            //create result text area
            JTextArea passwordOutput = new JTextArea();

            // prevent editing the text area
            passwordOutput.setEditable(false);
            passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));

            // add scrollability in case output becomes too big
            JScrollPane passwordOutPane = new JScrollPane(passwordOutput);
            passwordOutPane.setBounds(25, 240, 479, 78);

            //creat a black border around the text area
            passwordOutPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(passwordOutPane);

            //create password length label
            JLabel passwordLengthJLabel = new JLabel("Password Length:");
            passwordLengthJLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
            passwordLengthJLabel.setBounds(25, 350, 272, 39);
            add(passwordLengthJLabel);

            // create password length input
            JTextArea passwordLengthInputArea = new JTextArea();
            passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
            passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            passwordLengthInputArea.setBounds(310, 350, 192, 39);
            add(passwordLengthInputArea);

            //create toggle buttons
            //uppercase letter toggle
            JToggleButton uppercaseToggle = new JToggleButton("LowerCase");
            uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
            uppercaseToggle.setBounds(25, 420, 225, 56);
            add(uppercaseToggle);

            //lowercase letter toggle
            JToggleButton lowercaseToggle = new JToggleButton("UpperCase");
            lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
            lowercaseToggle.setBounds(282, 420, 225, 56);
            add(lowercaseToggle);

            // numbers toggle
            JToggleButton numbersToggle = new JToggleButton("Numbers");
            numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
            numbersToggle.setBounds(25, 490, 225, 56);
            add(numbersToggle);

            // symbols toggle
            JToggleButton symbolsToggle = new JToggleButton("Symbols");
            symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
            symbolsToggle.setBounds(282, 490, 225, 56);
            add(symbolsToggle);

            //crate generate button
            JButton generateButton = new JButton("Generate");
            generateButton.setFont(new Font("Dialog", Font.PLAIN, 26));
            generateButton.setBounds(155, 560, 222, 41);
            generateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //validation: generate a password only when length > 0 and one of the toggled buttons is pressed
                    if (passwordLengthInputArea.getText().length() <= 0) return;
                    boolean anyToggleSelected = lowercaseToggle.isSelected() ||
                            uppercaseToggle.isSelected() ||
                            numbersToggle.isSelected() ||
                            symbolsToggle.isSelected();

                    //generate password
                    //converts the text to an integer value
                    int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                    if (anyToggleSelected) {
                        String generatedPassoword = passwordGenerator.generatePassword(passwordLength,
                                lowercaseToggle.isSelected(),
                                uppercaseToggle.isSelected(),
                                numbersToggle.isSelected(),
                                symbolsToggle.isSelected());

                        //display password back to the user
                        passwordOutput.setText(generatedPassoword);
                    }
                }
            });
            add(generateButton);
        }
    }