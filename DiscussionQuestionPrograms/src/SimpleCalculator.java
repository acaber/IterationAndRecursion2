/**
 * File Name: SimpleCalculator.java
 * Author: Rebecca Johnson
 * Date: July 7, 2017
 * Purpose: Performs simple calculations through a GUI
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {

	//holds height and weight for JFrame
	private static final int WIDTH = 300;
	private static final int HEIGHT = 220;
	
	//add and subtract buttons
	private static JButton addBtn;
	private static JButton subtractBtn;
	
	//text fields for input and output
	private static JTextField inputFirstNumberTxt;
	private static JTextField inputSecondNumberTxt;
	private static JTextField outputFirstNumberTxt;
	private static JTextField outputSecondNumberTxt;
	private static JTextField outputResultsTxt;
	
	//labels for input and output
	private static JLabel inputFirstNumberLabel;
	private static JLabel inputSecondNumberLabel;
	private static JLabel outputFirstNumberLabel;
	private static JLabel outputSecondNumberLabel;
	private static JLabel outputResultsLabel;
	
	//constructor
	public SimpleCalculator() {
		super("Simple Calculator");
		
		//lays out the basic specifications of the frame
		setFrame(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		
		//creates a Jpanel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(panel, BorderLayout.NORTH);
		
		//add button specifications
		addBtn = new JButton("Add");
		panel.add(addBtn);
		addBtn.setToolTipText("Adds two numbers.");
		
		//subtract button specifications
		subtractBtn = new JButton("Subtract");
		panel.add(subtractBtn);
		subtractBtn.setToolTipText("Subtracts two numbers.");		
		
		//textPanel specifications
		JPanel textPanel = new JPanel();
		add(textPanel, BorderLayout.CENTER);
		
		//first text box and label specifications
		inputFirstNumberLabel = new JLabel("Enter First Number:");
		textPanel.add(inputFirstNumberLabel);
		inputFirstNumberTxt = new JTextField(10);
		textPanel.add(inputFirstNumberTxt);
		inputFirstNumberTxt.setEditable(true);
		
		//second text box and label specifications
		inputSecondNumberLabel = new JLabel("Enter Second Number:");
		textPanel.add(inputSecondNumberLabel);
		inputSecondNumberTxt = new JTextField(10);
		textPanel.add(inputSecondNumberTxt);
		inputSecondNumberTxt.setEditable(true);
		
		//third text box and label specifications
		outputFirstNumberLabel = new JLabel("First Number Entered:");
		textPanel.add(outputFirstNumberLabel);
		outputFirstNumberTxt = new JTextField(10);
		textPanel.add(outputFirstNumberTxt);
		outputFirstNumberTxt.setEditable(false);
		
		//fourth text box and label specifications
		outputSecondNumberLabel = new JLabel("Second Number Entered:");
		textPanel.add(outputSecondNumberLabel);
		outputSecondNumberTxt = new JTextField(10);
		textPanel.add(outputSecondNumberTxt);
		outputSecondNumberTxt.setEditable(false);
		
		//fifth text box and label specifications
		outputResultsLabel = new JLabel("Result:");
		textPanel.add(outputResultsLabel);
		outputResultsTxt = new JTextField(10);
		textPanel.add(outputResultsTxt);
		outputResultsTxt.setEditable(false);			
	}
	
	@Override //needed to implement the ActionListener interface
	public void actionPerformed(ActionEvent arg0) {}
	
	//this method creates the frame
	private void setFrame(int width, int height) {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
			
	//this method displays the GUI
	private void display() {
		setVisible(true);
	}

	//checks if the input is a numeric value
	public static boolean isNumericValue(String input) {
			
		boolean numericValue = false;
		try {
			Integer.parseInt(input);
			numericValue = true;		
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Error: Input is not an integer");
		}
		return numericValue;
	}
	
	//method that performs the addition request
	private static void performAdditionRequest(int firstNumber, int secondNumber) {
		int result = firstNumber + secondNumber;
		
		outputFirstNumberTxt.setText(String.format("%s", Integer.toString(firstNumber)));
		outputSecondNumberTxt.setText(String.format("%s", Integer.toString(secondNumber)));
		outputResultsTxt.setText(String.format("%s", Integer.toString(result)));
	}
	
	//method that performs the subtraction request
	private static void performSubtractionRequest(int firstNumber, int secondNumber) {
		int result = firstNumber - secondNumber;
		
		outputFirstNumberTxt.setText(String.format("%s", Integer.toString(firstNumber)));
		outputSecondNumberTxt.setText(String.format("%s", Integer.toString(secondNumber)));
		outputResultsTxt.setText(String.format("%s", Integer.toString(result)));
	}

	//main method
	public static void main(String[] args) {	
		SimpleCalculator c = new SimpleCalculator();
		c.display();
		
		//add button event handler
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ 
				
				if(isNumericValue(inputFirstNumberTxt.getText()) 
						&& isNumericValue(inputSecondNumberTxt.getText())) 
					performAdditionRequest(Integer.parseInt(inputFirstNumberTxt.getText()),
							Integer.parseInt(inputSecondNumberTxt.getText()));
			}
		});
		
		//subtract button event handler
		subtractBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ 
				
				if(isNumericValue(inputFirstNumberTxt.getText()) 
						&& isNumericValue(inputSecondNumberTxt.getText())) 
					performSubtractionRequest(Integer.parseInt(inputFirstNumberTxt.getText()),
							Integer.parseInt(inputSecondNumberTxt.getText()));	
			}
		});
		
	}
}








