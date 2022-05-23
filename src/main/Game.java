package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Game extends JFrame implements Runnable{

	boolean running = true;
	
	public static final float Hz = 1/60.0f;
	
	private Screen screen;
	HashSet<Integer> keysPressed = new HashSet<>();
	
	private Player player;
	
	public Game() {
		super("Game");
		
		
		this.player = new Player(this);
		

		this.screen = new Screen();
		this.add(screen);
		
		this.addKeyListener(new InputHandler());
		
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // TODO WindowListener
		this.setResizable(false);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		new Thread(this).start();
		
	}
	
	@Override
	public void run() {
		
		long timeLast = System.nanoTime();
		float theta = 0;
		
		while (running) {
			long timeNow = System.nanoTime();
			long elapsedTime = timeNow - timeLast;
			theta += elapsedTime / 1000000000.0f;
			timeLast = timeNow;
			
			while (theta >= Hz) {
				
				update();
				
				theta -= Hz;
			}
			
		}
		
	}
	
	private void update() {
		// Reads inputs on update
		player.update();
		screen.update(screen.getGraphics());
		
	}


	class Screen extends Canvas {
		
		Screen(){
			this.setSize(1280, 720);
			this.setBackground(Color.black);
			this.setFocusable(false);
		}
		
		@Override
		public void paint(Graphics g) {
			g.setColor(Color.white);
			g.drawOval((int) player.x - 5, (int) player.z - 5, 9, 9);
			// TODO Draw player -> Projection
			g.dispose();
		}
		
	}

	class InputHandler extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			keysPressed.add(e.getKeyCode());
		}


		@Override
		public void keyReleased(KeyEvent e) {
			
			// Not on update
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER: // TODO Set to ESCAPE
				// TODO Save game
				dispose();
				running = false;
				new OptionsMenu();
				break;
			case KeyEvent.VK_P: // Debug
				player.printPlayerInfo();
				break;
			}
			
			keysPressed.remove(e.getKeyCode());
		}
		
	}
	
}
