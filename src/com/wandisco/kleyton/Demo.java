package com.wandisco.kleyton;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import com.wandisco.kleyton.volumeCalculator.Shape;
import com.wandisco.kleyton.volumeCalculator.ShapeFactory;

/**
 * GUI demonstration using AWT (Abstract Window Toolkit).
 * 
 * @author <a href="mailto:kleyton.ohare@gmail.com">Kleyton O'Hare</a>
 */
@SuppressWarnings("serial")
public class Demo extends JFrame {
	private static final int WIDTH = 590;
	private static final int HEIGHT = 330;
	private JPanel panel;
	private JLabel shape;
	private JTextField input;
	private JLabel inputLabel;
	private ButtonGroup bg;
	private JTextPane displayResult = new JTextPane();
	private Font font = new Font("Arial", Font.PLAIN, 18);

	/**
	 * Building the frame
	 */
	public Demo() {
		super("Volume Calculator");						// frame title
		panel = new JPanel();
			panel.setBackground(Color.white);
			panel.setLayout(null);
		setContentPane(panel);							// pane property

		// when user presses 'X' on the top right corner
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				closeProgram();
			}
		});
		
		// Title
		JLabel title = new JLabel("Welcome to Volume Calculator");
			title.setFont(new Font("Arial Black", Font.PLAIN, 20));
			title.setBounds(130, 0, 352, 50);
			panel.add(title);

		// Shape choices
		shape = new JLabel("Choose a shape:");
			shape.setFont(font);
			shape.setBounds(30, 65, 150, 30);
			panel.add(shape);
			
		JRadioButton sphere = new JRadioButton("Sphere");
			sphere.setBounds(200, 65, 100, 30);
			sphere.setFont(font);
			sphere.setBackground(Color.white);
			sphere.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayInputField("What's the sphere radius?");
				}
			});
			panel.add(sphere);

		JRadioButton cube = new JRadioButton("Cube");
			cube.setFont(font);
			cube.setBackground(Color.WHITE);
			cube.setBounds(320, 65, 80, 30);
			cube.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayInputField("What's the cube width?");
				}
			});
			panel.add(cube);

		JRadioButton tetrahedron = new JRadioButton("Tetrahedron");
			tetrahedron.setFont(font);
			tetrahedron.setBackground(Color.WHITE);
			tetrahedron.setBounds(420, 65, 145, 30);
			tetrahedron.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					displayInputField("What's the tetrahedron edge?");
				}
			});
			panel.add(tetrahedron);
		
		// Group radio buttons
		bg = new ButtonGroup();
			bg.add(sphere);
			bg.add(cube);
			bg.add(tetrahedron);
		
		// Get user's value
		inputLabel = new JLabel();
			inputLabel.setFont(font);
			inputLabel.setBounds(30, 120, 250, 30);
		
		input = new JTextField(10);
			input.setFont(font);
			input.setBounds(290, 120, 80, 30);		
		
		// Submit calculation
		JButton submit = new JButton("Calculate");
			submit.setBounds(200, 230, 150, 40);
			submit.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					int value = 0;
					Shape shape = null;
					
					try {
						value = Integer.valueOf(input.getText());
						
						// positive values only
						if(value <= 0)
							throw new IllegalArgumentException();
						
						if(sphere.isSelected()) {
							shape = ShapeFactory.getShape("sphere", value);
						} else if (cube.isSelected()) {
							shape = ShapeFactory.getShape("cube", value);
						} else if (tetrahedron.isSelected()) {
							shape = ShapeFactory.getShape("tetrahedron", value);					
						}

					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, "Not a valid entry.\nPositive numbers only.", 
								"Alert", JOptionPane.WARNING_MESSAGE);
					}	
	
					// response field
					if(shape != null) {
						displayResult.setFont(font);
						displayResult.setForeground(Color.BLUE);
						displayResult.setBounds(30, 175, 600, 40);
						displayResult.setText(shape.toString());
						panel.add(displayResult);
						panel.add(resetButton());
						panel.repaint();
					}
				}
			});
			panel.add(submit);

		// Close program
		JButton close = new JButton("Close");
			close.setBounds(450, 230, 90, 40);
			close.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					closeProgram();
				}
			});
			panel.add(close);
			
		JLabel author = new JLabel("by Kleyton O'Hare");
			author.setFont(new Font("Arial", Font.PLAIN, 12));
			author.setBounds(30, 250, 100, 20);
			panel.add(author);
		
		validate();	// validate the container
		repaint();	// repaint the container after adding or removing components
	}
	
	/**
	 * Display question and input field
	 * 
	 * @param text question to be asked
	 */
	private void displayInputField(String text) {
		panel.remove(displayResult);
		inputLabel.setText(text);
		panel.add(inputLabel);
		panel.add(input);
		panel.repaint();
	}
	
	/**
	 * Hides components from the input field
	 * 
	 * @return button
	 */
	private JButton resetButton() {
		JButton reset = new JButton("Reset");
		reset.setBounds(460, 120, 80, 30);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
				panel.remove(displayResult);
				repaint();
			}
		});
		
		return reset;
	}
	
	/**
	 * Prompts a question whether user is sure to exit program
	 */
	private void closeProgram() {
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Closing program...", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo frame = new Demo();
					frame.setSize(WIDTH, HEIGHT);
					frame.setLocationRelativeTo(null);			// sets the program to the centre of the screen
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

					UIManager.put("OptionPane.background", Color.white); 	// set colour for JOptionPane
					UIManager.put("Panel.background", Color.white); 		// set colour for JOptionPane
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
