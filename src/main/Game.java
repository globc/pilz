package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends JFrame implements KeyListener, Runnable{

	private static final float Hz = 1/60.0f;
	
	double x = 0;
	double y = 0;
	
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
		
		new Thread(this).start();
		
	}
	
	@Override
	public void run() {
		
		long timeLast = System.nanoTime();
		float theta = 0;
		
		while (true) {
			long timeNow = System.nanoTime();
			long elapsedTime = timeNow - timeLast;
			theta += elapsedTime / 1000000000.0f;
			timeLast = timeNow;
			
			while (theta >= Hz) {
				
				double xLast = x;
				double yLast = y;
				move();
				
				if (xLast != x || yLast != y) printStats();
				
				theta -= Hz;
			}
			
		}
		
	}
	
	public void move() {
		double distance = SPEED * Hz;
		
		y += WASD[0] ? distance : 0;
		y -= WASD[2] ? distance : 0;
		
		x -= WASD[1] ? distance : 0;
		x += WASD[3] ? distance : 0;
	}
	
	void printStats() {
		System.out.println("X: " + x + " | Y: " + y);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {

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
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
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
		
	}

	
	
}
