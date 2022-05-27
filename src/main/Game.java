package main;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class Game extends JFrame implements Runnable{

	private boolean running = true;
	
	public static final float Hz = 1/60.0f;
	
	private GameScreen screen;
	private HashSet<Integer> keysPressed = new HashSet<>();
	
	public Player player;
	
	public Game() {
		super("Game");
		
		
		this.player = new Player(this);
		

		this.screen = new GameScreen(this);
		this.add(screen);
		
		this.addKeyListener(new InputHandler());
		
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // TODO WindowListener
		this.setResizable(false);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.running = true;
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
			
			while (theta >= Hz) { // TODO if Hz = null use elapsedTime
				
				update();
				
				theta -= Hz;
			}
			
		}
		
		// TODO Save game
		dispose();	
		new OptionsMenu();
		
	}
	
	private void update() {
		// Reads inputs on update
		player.update();
		
		
		screen.update(getGraphics());
	}

	@Override
	public Graphics getGraphics() {
		return screen.getGraphics(); // TODO BufferStrategy?
	}
	
	public int getScreenWidth() {
		return screen.getWidth();
	}
	
	public int getScreenHeight() {
		return screen.getHeight();
	}
	
	public boolean isPressed(int key) {
		return keysPressed.contains(key);
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
				running = false;
				break;
			case KeyEvent.VK_P: // Debug
				player.printPlayerInfo();
				break;
			}
			
			keysPressed.remove(e.getKeyCode());
		}
		
	}
	
}
