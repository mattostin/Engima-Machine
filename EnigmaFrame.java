import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {
    private JComboBox<Integer> innerRotorComboBox;
    private JComboBox<Integer> middleRotorComboBox;
    private JComboBox<Integer> outerRotorComboBox;
    private JTextField startPositions;
    private JButton buttonEncrypt;
    private JButton buttonDecrypt;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    public EnigmaFrame() {
        // Create the main panel with GridBagLayout
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Initialize UI components
        innerRotorComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        middleRotorComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        outerRotorComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        startPositions = new JTextField("###", 5);
        buttonEncrypt = new JButton("Encrypt");
        buttonDecrypt = new JButton("Decrypt");

        // Add Inner Rotor ComboBox
        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(new JLabel("Inner"), gbc);
        gbc.gridx = 1;
        topPanel.add(innerRotorComboBox, gbc);

        // Add Middle Rotor ComboBox
        gbc.gridx = 2;
        topPanel.add(new JLabel("Middle"), gbc);
        gbc.gridx = 3;
        topPanel.add(middleRotorComboBox, gbc);

        // Add Outer Rotor ComboBox
        gbc.gridx = 4;
        topPanel.add(new JLabel("Outer"), gbc);
        gbc.gridx = 5;
        topPanel.add(outerRotorComboBox, gbc);

        // Add Initial Positions TextField
        gbc.gridx = 6;
        topPanel.add(new JLabel("Initial Positions"), gbc);
        gbc.gridx = 7;
        topPanel.add(startPositions, gbc);

        // Add Encrypt and Decrypt buttons
        gbc.gridx = 8;
        topPanel.add(buttonEncrypt, gbc);
        gbc.gridx = 9;
        topPanel.add(buttonDecrypt, gbc);

        // Add the top panel to the frame's NORTH
        add(topPanel, BorderLayout.NORTH);

        // Create a panel for Input and Output
        JPanel inputOutputPanel = new JPanel();
        inputOutputPanel.setLayout(new GridLayout(2, 1));

        // Add Input TextArea
        inputTextArea = new JTextArea(5, 20);
        inputTextArea.setLineWrap(true);
        inputTextArea.setMargin(new Insets(10, 10, 10, 10));
        inputOutputPanel.add(new JLabel("Input"));
        inputOutputPanel.add(new JScrollPane(inputTextArea));

        // Add Output TextArea
        outputTextArea = new JTextArea(5, 20);
        outputTextArea.setLineWrap(true);
        outputTextArea.setMargin(new Insets(10, 10, 10, 10));
        inputOutputPanel.add(new JLabel("Output"));
        inputOutputPanel.add(new JScrollPane(outputTextArea));

        // Add the Input/Output panel to the frame's CENTER
        add(inputOutputPanel, BorderLayout.CENTER);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Enigma GUI");
        pack();
        setLocationRelativeTo(null);

        // Add action listener for encryption button
        buttonEncrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextArea.getText();
                int innerRotor = (int) innerRotorComboBox.getSelectedItem();
                int middleRotor = (int) middleRotorComboBox.getSelectedItem();
                int outerRotor = (int) outerRotorComboBox.getSelectedItem();
                String start = startPositions.getText();
                if (!validateSettingsInput(start, innerRotor, middleRotor, outerRotor, inputText)) {
                    return;
                }
                Enigma enigma = new Enigma(innerRotor, middleRotor, outerRotor, start);
                String outputText = enigma.encrypt(inputText);
                outputTextArea.setText(outputText);
            }
        });

        // Add action listener for decryption button
        buttonDecrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextArea.getText();
                int innerRotor = (int) innerRotorComboBox.getSelectedItem();
                int middleRotor = (int) middleRotorComboBox.getSelectedItem();
                int outerRotor = (int) outerRotorComboBox.getSelectedItem();
                String start = startPositions.getText();
                if (!validateSettingsInput(start, innerRotor, middleRotor, outerRotor, inputText)) {
                    return;
                }
                Enigma enigma = new Enigma(innerRotor, middleRotor, outerRotor, start);
                String outputText = enigma.decrypt(inputText);
                outputTextArea.setText(outputText);
            }
        });
    }

    // Method for input validation 
    private Boolean validateSettingsInput(String start, int inner, int middle, int outer, String input) {
        return true; 
    }
}
