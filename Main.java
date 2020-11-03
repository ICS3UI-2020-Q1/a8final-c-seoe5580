import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables

  JLabel increaseLabel;
  JLabel counterLabel;
  
  JTextField increaseTextField;
  JTextField counterTextField;
  
  JButton increaseButton;
  JButton resetButton;

  JPanel mainPanel;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Test");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    // initialize the main JPanel
    mainPanel = new JPanel();
    // turns the manual layouts on
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    // creates labels
    increaseLabel = new JLabel("Increase By:");
    counterLabel = new JLabel("Counter:");
    // using the set bound it will locate the label
    increaseLabel.setBounds(250,200,150,40);
    counterLabel.setBounds(250,280,150,40);

    // adds the created label to the main panel
    mainPanel.add(increaseLabel);
    mainPanel.add(counterLabel);

    // creates a text field
    increaseTextField = new JTextField();
    counterTextField = new JTextField("0");
    // using the set bound it will locate the text field
    increaseTextField.setBounds(450,200,150,40);
    counterTextField.setBounds(450,280,150,40);

    // this will stop the user from typing inside the counter box
    counterTextField.setEnabled(false);

    // adds the created textfield to the main panel
    mainPanel.add(increaseTextField);
    mainPanel.add(counterTextField);

    // creates buttons
    increaseButton = new JButton("increase");
    resetButton = new JButton("reset");
    // using set bound it will locate the buttons
    increaseButton.setBounds(250,120,150,40);
    resetButton.setBounds(450,120,150,40);

    // declaring a action command to the button so we know which button is pressed later
    increaseButton.setActionCommand("increase");
    resetButton.setActionCommand("reset");

    // adds the action listener to the button
    increaseButton.addActionListener(this);
    resetButton.addActionListener(this);

    // adds the button to the main panel
    mainPanel.add(increaseButton);
    mainPanel.add(resetButton);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    // declares a sum variable for the calculation
    int sum = 0;

    // using the if state meant when increase button is pressed it will do the following:
    if(command.equals("increase")){
      // it will get the number from the user and store it
      String increaseText = increaseTextField.getText();
      // turn text into integer
      int increaseBy = Integer.parseInt(increaseText);
      
      // using the nested if statement it will calculate the following:
      if(sum < 10 && sum != 10){
        sum = sum + increaseBy;
        counterTextField.setText("" + sum);
      }else if(sum == 10){
        sum = sum;
        counterTextField.setText("" + sum);
      }
    // using the else if statement it will do the following when reset button is pressed
    }else if(command.equals("reset")){
      sum = 0;
      increaseTextField.setText("");
      counterTextField.setText("0");
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
