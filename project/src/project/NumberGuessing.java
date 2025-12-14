package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGuessing extends JFrame implements ActionListener {

    JTextField guessField;
    JLabel messageLabel;
    JButton guessButton, resetButton;
    int randomNumber;

    public NumberGuessing() {
        Random rand = new Random();
        randomNumber = rand.nextInt(100) + 1;
        setTitle("Number Guessing Game");
        setSize(400, 200);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel instruction = new JLabel("Guess a number between 1 and 100", JLabel.CENTER);
        guessField = new JTextField();
        messageLabel = new JLabel("Enter your guess", JLabel.CENTER);

        guessButton = new JButton("Guess");
        resetButton = new JButton("Reset");
        guessButton.addActionListener(this);
        resetButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guessButton);
        buttonPanel.add(resetButton);
        add(instruction);
        add(guessField);
        add(messageLabel);
        add(buttonPanel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            try {
                int userGuess = Integer.parseInt(guessField.getText());

                if (userGuess > randomNumber) {
                    messageLabel.setText("Too High!");
                } else if (userGuess < randomNumber) {
                    messageLabel.setText("Too Low!");
                } else {
                    messageLabel.setText("Correct! 🎉 You guessed it!");
                }
            } catch (NumberFormatException ex) {
                messageLabel.setText("Please enter a valid number!");
            }
        }

        if (e.getSource() == resetButton) {
            Random rand = new Random();
            randomNumber = rand.nextInt(100) + 1;
            guessField.setText("");
            messageLabel.setText("Game Reset! Enter your guess");
        }
    }

    public static void main(String[] args) {
        new NumberGuessing();
    }
}

