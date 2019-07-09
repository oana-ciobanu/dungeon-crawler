package GUI;

import GameEngine.Game;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public JFrame window;
    public JPanel startButtonBackground, midTextArea, choiceButtonPanel, playerPanel;
    public JTextArea mainTextArea, titleTextArea;
    public JButton choice1, choice2, choice3, choice4;
    public JTextField userInput;


    Font subtitleFont = new Font("Times New Roman", Font.PLAIN, 28);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);


    public void createGUI(Game.choiceHandler cHandler) {





        //WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);




        //USER INPUT

        userInput = new JTextField();
        userInput.setBounds(250, 220, 300, 40);
        userInput.setBackground(Color.black);
        userInput.setFont(subtitleFont);
        userInput.setForeground(Color.white);
        userInput.addActionListener(cHandler);
        userInput.setActionCommand("Enter");
        userInput.setVisible(false);

        window.add(userInput);



        //GAME SCREEN
        midTextArea = new JPanel();
        midTextArea.setBounds(100, 150, 600, 250);
        midTextArea.setBackground(Color.black);
        window.add(midTextArea);

        mainTextArea = new JTextArea("Insert text here!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(subtitleFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        midTextArea.add(mainTextArea);
        mainTextArea.setVisible(true);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtonPanel);

        choice1 = new JButton("");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFocusPainted(false);
        choice1.setFont(normalFont);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFocusPainted(false);
        choice2.setFont(normalFont);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFocusPainted(false);
        choice3.setFont(normalFont);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFocusPainted(false);
        choice4.setFont(normalFont);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 300);
        playerPanel.setBackground(Color.black);
        //   playerPanel.setLayout(new GridLayout(2, 4));
        window.add(playerPanel);

        titleTextArea = new JTextArea("");
        titleTextArea.setBounds(0, 0, 600, 100);
        titleTextArea.setBackground(Color.black);
        titleTextArea.setForeground(Color.white);
        titleTextArea.setFont(normalFont);
        titleTextArea.setLineWrap(true);
        titleTextArea.setWrapStyleWord(true);
        titleTextArea.setEditable(false);
        titleTextArea.setVisible(true);
        playerPanel.add(titleTextArea);


        window.setVisible(true);

    }
}