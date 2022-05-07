package main;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class OptionsMenu extends JFrame{

	private JButton clicker, quit;
	private int timesClicked;
	
	public OptionsMenu() {
		super("Options");
		this.timesClicked = 0;
		
		clicker = new JButton("Start");
		clicker.addActionListener((e) -> {this.timesClicked++; this.clicker.setText("Clicked: " + timesClicked); this.pack();}); // anonymous inner class
		clicker.setToolTipText("Click!");
		this.add(clicker); // BorderLayout.CENTER
		
		quit = new JButton("Quit");
		quit.addActionListener((e) -> this.dispose());
		quit.setToolTipText("Quits the game");
		this.add(quit, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		this.setVisible(true);
	}
	
}
