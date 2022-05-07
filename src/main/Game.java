package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends JFrame implements KeyListener{

	double x = 0;
	double y = 0;
	
	/**
	 * Movement speed in m/s.
	 */
	static final double SPEED = 5.0;
	
	boolean[] WASD = new boolean[] {false, false, false, false};
	
	public Game() {
		super("Game");
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		addKeyListener(this);
		
		this.setVisible(true);
		
	}
	
	public void move(long elapsedTime) {
		if (WASD[0]) y += SPEED * (elapsedTime / 1000.0);
		if (WASD[2]) y -= SPEED * (elapsedTime / 1000.0);
		
		if (WASD[1]) x -= SPEED * (elapsedTime / 1000.0);
		if (WASD[3]) x += SPEED * (elapsedTime / 1000.0);
	}
	
	void printStats() {
		System.out.println("X: " + x + " | Y: " + y);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}

	long timeLast = 0;
	
	@Override
	public void keyPressed(KeyEvent e) {
		long elapsedTime = timeLast == 0 ? 0 : e.getWhen() - timeLast;
		timeLast = e.getWhen();

		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			WASD[0] = true;
			break;
		case KeyEvent.VK_A:
			WASD[1] = true;
			break;
		case KeyEvent.VK_S:
			WASD[2] = true;
			break;
		case KeyEvent.VK_D:
			WASD[3] = true;
			break;
		}
		

		
		move(elapsedTime);
		printStats();
	}


	@Override
	public void keyReleased(KeyEvent e) {
		long elapsedTime = e.getWhen() - timeLast;
		
		move(elapsedTime);
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			WASD[0] = false;
			break;
		case KeyEvent.VK_A:
			WASD[1] = false;
			break;
		case KeyEvent.VK_S:
			WASD[2] = false;
			break;
		case KeyEvent.VK_D:
			WASD[3] = false;
			break;
			
		case KeyEvent.VK_ENTER: //TODO Change to escape
			//TODO Save game
			dispose();
			new OptionsMenu();
		}
		
		timeLast = (WASD[0] || WASD[1] || WASD[2] || WASD[3]) ? e.getWhen() : 0;
		printStats();
		
	}
	
}
