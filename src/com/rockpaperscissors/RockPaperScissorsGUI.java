package com.rockpaperscissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RockPaperScissorsGUI {
    private JFrame frame;
    private JButton rockButton, paperButton, scissorsButton, playAgainButton;
    private JLabel resultLabel, computerChoiceLabel, userChoiceLabel, welcomeLabel;
    

    public RockPaperScissorsGUI() {
        createGUI();
    }
    
    private void createGUI() {

        frame = new JFrame("Welcome to Shey's Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); 
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        welcomeLabel = new JLabel("Choose your weapon!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        
        rockButton.addActionListener(new ButtonClickListener());
        paperButton.addActionListener(new ButtonClickListener());
        scissorsButton.addActionListener(new ButtonClickListener());
        
        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        
        userChoiceLabel = new JLabel("Your choice: ", JLabel.CENTER);
        computerChoiceLabel = new JLabel("Computer choice: ", JLabel.CENTER);
        resultLabel = new JLabel("Make your choice!", JLabel.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        

        playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(new PlayAgainListener());
        playAgainButton.setVisible(false);
        

        centerPanel.add(buttonPanel);
        centerPanel.add(userChoiceLabel);
        centerPanel.add(computerChoiceLabel);
        centerPanel.add(resultLabel);
        centerPanel.add(playAgainButton);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userChoice = e.getActionCommand().toLowerCase();
            
            // Get both result and computer's choice from main code 
            // AI was used here since i had issues getting the computer randomized choice from the main code to the GUI
            String[] resultAndChoice = RockPaperScissors.play(userChoice).split("\\|");
            String result = resultAndChoice[0];
            String computerChoice = resultAndChoice[1];
            
            userChoiceLabel.setText("Your choice: " + userChoice);
            computerChoiceLabel.setText("Computer choice: " + computerChoice);
            resultLabel.setText(result);
            
            playAgainButton.setVisible(true);
            rockButton.setEnabled(false);
            paperButton.setEnabled(false);
            scissorsButton.setEnabled(false);
        }
    }
    
    private class PlayAgainListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            userChoiceLabel.setText("Your choice: ");
            computerChoiceLabel.setText("Computer choice: ");
            resultLabel.setText("Make your choice!");
            
            playAgainButton.setVisible(false);

            rockButton.setEnabled(true);
            paperButton.setEnabled(true);
            scissorsButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			new RockPaperScissorsGUI();
    		}
    	});
        
    }
}
